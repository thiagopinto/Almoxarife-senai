package senai.almoxarife;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import senai.almoxarife.empity.Material;
import senai.almoxarife.view.TelaInicioForm;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("System_Almoxarifado");
		EntityManager manager = factory.createEntityManager();
		
		Material m = new Material();
		m.setNome("Papel A4");
		m.setUnidade("Caixa");
		m.setEstoqueMin(5);
		m.setEstoqueMax(10);
		
		manager.getTransaction().begin();
		
		manager.persist(m);
		
		manager.getTransaction().commit();
	}

}
