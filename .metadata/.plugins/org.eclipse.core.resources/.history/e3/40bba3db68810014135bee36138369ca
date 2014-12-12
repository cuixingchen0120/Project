package neu.edu.cs5200;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ShoppingCartHistoryDAO {

	//gai!!
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("neu.edu.cs5200");
	EntityManager em = null;
	
	public ShoppingCartHistoryDAO() {
		em = factory.createEntityManager();
	}
	
	public void addOrderHistory(ShoppingCartHistory history) {
		em.getTransaction().begin();
		em.persist(history);
		em.getTransaction().commit();
	}
	
	public List<ShoppingCartHistory> findHistoryByUser(User user) {
		em.getTransaction().begin();
        Query q = em.createQuery("select h from ShoppingCartHistory h where h.user = :user");
        q.setParameter("user", user);
        List<ShoppingCartHistory> history = q.getResultList();
		em.getTransaction().commit();
		return history;
	}
	
	public List<ShoppingCartHistory> findHistoryByCard(Card card) {
		em.getTransaction().begin();
        Query q = em.createQuery("select h from ShoppingCartHistory h where h.card = :card");
        q.setParameter("card", card);
        List<ShoppingCartHistory> history = q.getResultList();
		em.getTransaction().commit();
		return history;
	}
	
	public List<ShoppingCartHistory> findHistoryAfterDate(Date date) {
		em.getTransaction().begin();
        Query q = em.createQuery("select h from ShoppingCartHistory h");
        List<ShoppingCartHistory> history = q.getResultList();
        Iterator<ShoppingCartHistory> iter = history.iterator();
        while (iter.hasNext()) {
        	ShoppingCartHistory s = iter.next();
        	if (s.getDate().before(date))
        		iter.remove();
        }
        em.getTransaction().commit();
		return history;
	}
	
	public List<ShoppingCartHistory> findHistoryBeforeDate(Date date) {
		em.getTransaction().begin();
        Query q = em.createQuery("select h from ShoppingCartHistory h");
        List<ShoppingCartHistory> history = q.getResultList();
        Iterator<ShoppingCartHistory> iter = history.iterator();
        while (iter.hasNext()) {
        	ShoppingCartHistory s = iter.next();
        	if (s.getDate().after(date))
        		iter.remove();
        }
        em.getTransaction().commit();
		return history;
	}
	
	public static void main(String[] args) {

	}

}
