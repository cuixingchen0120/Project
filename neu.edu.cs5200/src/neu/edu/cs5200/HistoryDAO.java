package neu.edu.cs5200;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HistoryDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("neu.edu.cs5200");
	EntityManager em = null;
	
	public HistoryDAO(){
		em = factory.createEntityManager();
	} 
	
	public History createHistory(User user ,History history) {

		em.getTransaction().begin();
		em.persist(history);
		
		history.setUser(user);
		em.merge(history);
		user.getHistories().add(history);
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		
		return history;
		

	}
	
	public List<History> findAllHistory(User user){
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("select h from History h where h.user.id=:userid1");
		
		query.setParameter("userid1",user.getId());
		
		List<History> historys = query.getResultList(); 
		
		em.getTransaction().commit();
		em.close();
		return historys;
	}
	
//    public List<History> ListHistory(String username){
//  
//  		em.getTransaction().begin();  
//  		Query query = em.createQuery("SELECT h FROM History h WHERE h.username=:username");
//		query.setParameter("username", username);
//  		List<History> history = (List<History>)query.getResultList();
//  		em.getTransaction().commit();
//  		return history;
//  	}
//    
//    public History HistoryByCard(String cardname){
//    	em.getTransaction().begin();
//    	Query query = em.createQuery("SELECT name FROM Card c WHERE c.cardname=:cardname");
//    	query.setParameter("cardname", cardname);
//    	String cardname1 = (String)query.getSingleResult();
//    	Timestamp date = new Timestamp(System.currentTimeMillis());
//    	History history = new History(null,cardname1,date);
//    	em.getTransaction().commit();
//    	return history;
//    }
	

	public void deleteHistory(int historyId){
	
		em.getTransaction().begin();
		
		History history = em.find(History.class, historyId);
		em.remove(history);
//		User user = history.getUser();
//		user.getHistories().remove(history);
//		em.merge(user);
//		
//		History managed = em.merge(history);
//		em.remove(managed);
		
		em.getTransaction().commit();
		
		
	}
	
	public void deleteHistoryByusername(String username){
		em.getTransaction().begin();
		Query query = em.createQuery("select h from History h where h.username=:username");
		query.setParameter("username",username);
		List<History> histories= (List<History>)query.getResultList();
		em.remove(histories);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<History> findHistoryByUsername(String username){
		em.getTransaction().begin();
		Query query = em.createQuery("select h from History h where h.username=:username");
		query.setParameter("username",username);
		List<History> histories= (List<History>)query.getResultList();
		em.getTransaction().commit();
		return histories;
	}

	
	public static void main(String[] args) {
//		UserDAO dao = new UserDAO();
//		String username = "hyy";
//		User user = new User();
//		user =dao.findUserbyUsername(username);
		HistoryDAO hdao = new HistoryDAO();
//		History history = new History(null,new Date(), username , user);
//		
//		hdao.createHistory(user, history);
		//History history = new History(u1.getUsername(),"Skinrender",date);
		//dao.createHistory(u1, history);
		List<History> histories = hdao.findHistoryByUsername("hyy");
		for(History dir:histories) {
			//hdao.deleteHistory(dir);
			System.out.println(dir.getUser());
			hdao.deleteHistory(dir.getHistoryid());
		}	
		
		
		
	}
	
	
}