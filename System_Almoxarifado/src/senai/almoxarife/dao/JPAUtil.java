package senai.almoxarife.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("JPAService");
	private static EntityManager entityManager = emf.createEntityManager();
	private static final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
	private static final ThreadLocal<EntityTransaction> threadTransaction = new ThreadLocal<EntityTransaction>();
	private static final ThreadLocal<Long> threadCount = new ThreadLocal<Long>();
	private static Exception e = null;

	public JPAUtil() {
		emf = Persistence.createEntityManagerFactory("JPAService");
		entityManager = emf.createEntityManager();
	}

	public static EntityManager getEntityManager() {
		entityManager = threadEntityManager.get();
		try {
			if (entityManager == null) {
				entityManager = emf.createEntityManager();
				threadEntityManager.set(entityManager);
			}
		} catch (RuntimeException ex) {
			e = ex;
		}
		return entityManager;
	}

	public static void closeEntityManager() {
		if (!podeComitar())
			return;
		try {
			entityManager = threadEntityManager.get();
			threadEntityManager.set(null);
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
				System.out.println("Fechou a sessão para="
						+ Thread.currentThread().getName());
			}

			EntityTransaction tx = threadTransaction.get();
			if (tx != null && tx.isActive()) {
				rollbackTransaction();
				throw new RuntimeException(
						"EntityManager sendo fechado com transação ativa.");
			}
		} catch (RuntimeException ex) {
			e = ex;
		}
	}

	public static void beginTransaction() {
		alteraContador(1);
		EntityTransaction tx = threadTransaction.get();
		try {
			if (tx == null) {
				tx = getEntityManager().getTransaction();
				tx.begin();
				threadTransaction.set(tx);
				System.out.println("Criou transacao para="
						+ Thread.currentThread().getName());
			} else {
				System.out.println("Nao criou transacao para="
						+ Thread.currentThread().getName());

			}
		} catch (RuntimeException ex) {
			e = ex;
		}
	}

	public static boolean isTransacaoAtiva() {
		EntityTransaction tx = threadTransaction.get();
		return (tx != null && tx.isActive());
	}

	private static void alteraContador(int i) {
		Long count = threadCount.get();
		if (count == null)
			count = 0L;
		count += i;
		threadCount.set(count);
	}

	public static boolean podeComitar() {
		Long count = threadCount.get();
		return (count == null || count == 0);
	}

	public static void commitTransaction() {
		alteraContador(-1);
		if (!podeComitar()) {
			System.out.println("NÃO, comitou transacao para="
					+ Thread.currentThread().getName());
			return;
		}
		EntityTransaction tx = threadTransaction.get();
		if (tx != null && tx.isActive()) {
			tx.commit();
			System.out.println("Comitou transacao para="
					+ Thread.currentThread().getName());
		}
		threadTransaction.set(null);
	}

	public static void rollbackTransaction() {

		EntityTransaction tx = threadTransaction.get();
		try {
			threadTransaction.set(null);
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} catch (RuntimeException ex) {
			e = ex;
		} finally {
			closeEntityManager();
		}
	}
}
