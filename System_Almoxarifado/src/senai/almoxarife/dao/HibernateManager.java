package senai.almoxarife.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HibernateManager {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("System_Almoxarifado");
	static EntityManager manager = factory.createEntityManager();
	
	public HibernateManager() {
		
	}
	
	public static EntityManager getManager() {
		try{
			return manager;					
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		
	}
	
	public static void persistirObject(Object object){
		EntityManager manager = HibernateManager.getManager();
		
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit();
		manager.close();
	}

	public static <T> List<T> findObject(String value){
		EntityManager manager = HibernateManager.getManager();

		manager.getTransaction().begin();
		
		Query query = manager.createQuery(value);
		List<T> retorno = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		
		return retorno;
		
	}
}
