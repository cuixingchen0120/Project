package neu.edu.cs5200;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RateDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("neu.edu.cs5200");
	EntityManager em = null;
	
	public RateDAO(){
		em = factory.createEntityManager();
	} 
	
	public void createRate(Rate rate) {

		em.getTransaction().begin();
		em.persist(rate);
		em.getTransaction().commit();

	}
	
    public List<Rate> ListRate(String username){
  
  		em.getTransaction().begin();  
  		Query query = em.createQuery("SELECT r FROM Rate r WHERE r.username=:username");
		query.setParameter("username", username);
  		List<Rate> rate = (List<Rate>)query.getResultList();
  		em.getTransaction().commit();
  		return rate;
  	}
    
	public void deleteRate(){
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Rate r");
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		}
}