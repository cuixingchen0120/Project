package neu.edu.cs5200;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import neu.edu.cs5200.*;


public class CommentDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("neu.edu.cs5200");
	EntityManager em = null;
	
	public CommentDAO(){
		em=factory.createEntityManager();
	}
	
	/* create the comment */
	public void  createComment(Comment comment){
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();	
		
		
	}
	
	/* find the particular comment */
	public Comment findDeveloperById(int commentId){
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class,commentId);
		em.getTransaction().commit();
		return comment;
	}
	

	
	/*remove a developer */
	public void removeDeveloperById(int commentId){
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class,commentId);
		em.remove(comment);
		em.getTransaction().commit();
		
	}
	
	
	public List<Comment> findAllComment(){
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Comment c");
		List<Comment> comments= (List<Comment>)query.getResultList();
		em.getTransaction().commit();
		return comments;
	}
	
	public List<Comment> findCommentByCardname(String cardname){
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Comment c where c.cardname=:cardname");
		query.setParameter("cardname",cardname);
		List<Comment> comments= (List<Comment>)query.getResultList();
		em.getTransaction().commit();
		return comments;
	}

	
	public void deleteComment(int commentId){
		
		em.getTransaction().begin();
		
		Comment comment = em.find(Comment.class, commentId);
		em.remove(comment);
		em.getTransaction().commit();
		
		
	}
	
	


	public List<Comment> findCommentByUsername(String username){
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Comment c where c.username=:username");
		query.setParameter("username",username);
		List<Comment> comments= (List<Comment>)query.getResultList();
		em.getTransaction().commit();
		return comments;
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommentDAO dao = new CommentDAO();
		
		 
	
//		UserDAO udao = new UserDAO();
//		User u1 = udao.findUserbyUsername("hyy");
		//User u2 = udao.findUserbyUsername("undavid");
		
		//Comment c1 = new Comment("Wrath of God","a very bad card",new Date(),"hyy",u1);
		//dao.deleteComment(c1);
		//Comment c2 = new Comment("Skinrender","a very good card",new Date(),"undavid",u2);
//		Developer d2 = new Developer("Bob","WonderLand","alice@wonderland.com",new Date());
	//	Developer d3 = new Developer("Charlie","WonderLand","alice@wonderland.com",new Date());
//		Developer d4 = new Developer("Dan","WonderLand","alice@wonderland.com",new Date());
		
		//dao.createComment(c1);
		//dao.createComment(c2);
		List<Comment> comments = dao.findCommentByUsername("hyy");
		
		for(Comment dir:comments) {
			
		System.out.println(dir.getUser());
			dao.deleteComment(dir.getCommentid());
		}
//		
		
	   // dao.createDeveloper(d2);
//		dao.createDeveloper(d3);
//		dao.createDeveloper(d4);
		
//		dao.changeDevelopersLastName(d3,"Brown");
//		Developer dan= dao.findDeveloperById(4);
//		System.out.println(dan.getFirst());
//		
//		
//		dao.removeDeveloperById(3);
	}

}
