package senai.almoxarife.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
