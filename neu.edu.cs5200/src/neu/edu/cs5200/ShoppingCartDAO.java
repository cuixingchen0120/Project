package neu.edu.cs5200;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ShoppingCartDAO {

	//gai!!
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("neu.edu.cs5200");
	EntityManager em = null;
	
	public ShoppingCartDAO(){
		em = factory.createEntityManager();
	}
	

	public void orderCard(ShoppingCart order) {		
        ShoppingCartHistory sch = new ShoppingCartHistory(order.getUser(), order.getCard(), order.getOrderNum(), ShoppingCartHistory.Process.ORDER);
        ShoppingCartHistoryDAO schDao = new ShoppingCartHistoryDAO();
        schDao.addOrderHistory(sch);

        em.getTransaction().begin();
		ShoppingCart exist = em.find(ShoppingCart.class, order.getId());
        if (exist != null) {
        	exist.setOrderNum(exist.getOrderNum() + order.getOrderNum());//add new num to order num and update, 
        	em.detach(exist);//composite two foreign keys as the primary key
        	em.merge(exist);
        } else {
        	em.persist(order);
        }
		em.getTransaction().commit();
	}
	
	public void orderCard(User user, Card card, int num) {
        ShoppingCartHistory sch = new ShoppingCartHistory(user, card, num, ShoppingCartHistory.Process.ORDER);
        ShoppingCartHistoryDAO schDao = new ShoppingCartHistoryDAO();
        schDao.addOrderHistory(sch);
        
		em.getTransaction().begin();
		ShoppingCart order = new ShoppingCart(user, card, num);
		ShoppingCart exist = em.find(ShoppingCart.class, order.getId());
        if (exist != null) {
        	exist.setOrderNum(exist.getOrderNum() + num);
        	em.detach(exist);
        	em.merge(exist);
        } else {
        	em.persist(order);
        }
		em.getTransaction().commit();
	}
	
	public List<ShoppingCart> findOrderByUser(User user) {
		em.getTransaction().begin();
        Query q = em.createQuery("select s from ShoppingCart s where s.user = :user");
        q.setParameter("user",  user);
		List<ShoppingCart> orders = q.getResultList();
		Iterator<ShoppingCart> iter = orders.iterator();
		while (iter.hasNext()) {
			ShoppingCart order = iter.next();
			if (order.getOrderNum() <= 0)
				iter.remove();
		}
		em.getTransaction().commit();
		return orders;
	}

	public List<ShoppingCart> findOrderByCard(Card card) {
		em.getTransaction().begin();
        Query q = em.createQuery("select s from ShoppingCart s where s.card = :card");
        q.setParameter("card", card);
		List<ShoppingCart> orders = q.getResultList();
		Iterator<ShoppingCart> iter = orders.iterator();
		while (iter.hasNext()) {
			ShoppingCart order = iter.next();
			if (order.getOrderNum() <= 0)
				iter.remove();
		}
		em.getTransaction().commit();
		return orders;
	}
	
	public ShoppingCart findOrderByUserAndCard(User user, Card card) {
		em.getTransaction().begin();
		ShoppingCart idx = new ShoppingCart(user, card);
		ShoppingCart order = em.find(ShoppingCart.class, idx.getId());
		em.getTransaction().commit();
		return order;
	}
	
	public void deliverOrderToUser(User user, Card card, int num) {//after order, the num of cards delivery , dellivery num<order, else wrong
		em.getTransaction().begin();
		ShoppingCart order = em.find(ShoppingCart.class, new ShoppingCart(user, card, num).getId());
		if (order != null) {
			if (order.getOrderNum() < num) {
            	System.out.println("Error: the num of delivery is larger than the num of order.");
			} else {
		        ShoppingCartHistory sch = new ShoppingCartHistory(user, card, num, ShoppingCartHistory.Process.DELIVERY);
		        ShoppingCartHistoryDAO schDao = new ShoppingCartHistoryDAO();
		        schDao.addOrderHistory(sch);
		        
				order.setOrderNum(order.getOrderNum() - num);
				order.setHistoryNum(order.getHistoryNum() + num);
				em.detach(order);
				em.merge(order);
			}
		} else {
        	System.out.println("Error: the order (user: " + user.getId() + ", card: " + card.getId() + ") does not exist.");
		}
		em.getTransaction().commit();
	}
	
	public void deliverOrderToUser(User user, Card card) {//all cards deliver
		em.getTransaction().begin();
		ShoppingCart order = em.find(ShoppingCart.class, new ShoppingCart(user, card).getId());
		if (order != null) {
			if (order.getOrderNum() <= 0) {
            	System.out.println("Error: user " + user.getId() + " has no available order of card " + card.getId() + ".");
			} else {
		        ShoppingCartHistory sch = new ShoppingCartHistory(user, card, order.getOrderNum(), ShoppingCartHistory.Process.DELIVERY);
		        ShoppingCartHistoryDAO schDao = new ShoppingCartHistoryDAO();
		        schDao.addOrderHistory(sch);
		        
				order.setHistoryNum(order.getHistoryNum() + order.getOrderNum());
				order.setOrderNum(0);
				em.detach(order);
				em.merge(order);
			}
		} else {
        	System.out.println("Error: the order (user: " + user.getId() + ", card: " + card.getId() + ") does not exist.");
		}
		em.getTransaction().commit();
	}
	
	public void deliverOrderToUser(User user) {//deliver all cards user ordered 
		em.getTransaction().begin();
	    Query q = em.createQuery("select s from ShoppingCart s where s.user = :user");
	    q.setParameter("user", user);
        List<ShoppingCart> orders = q.getResultList();
        if (! orders.isEmpty()) {
            for (ShoppingCart order : orders) {
            	if (order.getOrderNum() > 0) {
    		        ShoppingCartHistory sch = new ShoppingCartHistory(user, order.getCard(), order.getOrderNum(), ShoppingCartHistory.Process.DELIVERY);
    		        ShoppingCartHistoryDAO schDao = new ShoppingCartHistoryDAO();
    		        schDao.addOrderHistory(sch);
    		        
    				order.setHistoryNum(order.getHistoryNum() + order.getOrderNum());
    				order.setOrderNum(0);
    				em.detach(order);
    				em.merge(order);
            	}
            }
        } else {
        	System.out.println("Error: the user " + user.getId() + " ordered nothing.");
        }
		em.getTransaction().commit();
	}

	
	public static void main(String[] args) {
		ShoppingCartDAO dao = new ShoppingCartDAO();
		UserDAO udao = new UserDAO();
		CardDAO cdao = new CardDAO();
//		
		User u1 = udao.findUser(1);
		User u2 = udao.findUser(2);
		User u3 = udao.findUser(3);
//		
		Card c1 = cdao.findCardById(1);
		Card c2 = cdao.findCardById(2);
		Card c3 = cdao.findCardById(3);
//
		dao.orderCard(u1, c1, 1);
		dao.orderCard(u1, c1, 2);
		dao.orderCard(u1, c2, 4);
		dao.orderCard(u1, c3, 5);
		dao.orderCard(u2, c2, 1);
		dao.orderCard(u2, c3, 2);
		dao.orderCard(u3, c3, 1);

	List<ShoppingCart> sc1 = dao.findOrderByUser(u2);
	List<ShoppingCart> sc2 = dao.findOrderByUser(u3);
		dao.deliverOrderToUser(u2);
		List<ShoppingCart> sc3 = dao.findOrderByUser(u2);
		dao.deliverOrderToUser(u1, c1, 2);
		dao.orderCard(u1, c1, 5);
		dao.deliverOrderToUser(u1, c1, 5);
		System.out.println(sc1);
		System.out.println(sc2);
		System.out.println(sc3);
	}
}

