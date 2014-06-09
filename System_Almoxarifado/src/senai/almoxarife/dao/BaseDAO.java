package senai.almoxarife.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

public class BaseDAO {

	public <T> T create(T entity) {
		T retornoEntity = null;

		try {
			JPAUtil.beginTransaction();
			retornoEntity = JPAUtil.getEntityManager().merge(entity);
			JPAUtil.commitTransaction();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		return retornoEntity;
	}

	public <T> T update(T entity) {
		T retornoEntity = null;

		try {

			JPAUtil.beginTransaction();
			retornoEntity = JPAUtil.getEntityManager().merge(entity);
			JPAUtil.commitTransaction();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		return retornoEntity;
	}

	public <T> void delete(T entity) {
		try {
			JPAUtil.beginTransaction();

			entity = JPAUtil.getEntityManager().merge(entity);
			JPAUtil.getEntityManager().remove(entity);
			JPAUtil.getEntityManager().flush();
			JPAUtil.commitTransaction();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}

	public <T> T findByIdClass(Class<T> klass, Object id) {
		T retorno = null;

		try {
			retorno = (T) JPAUtil.getEntityManager().find(klass, id);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> findByAllClass(Class<T> klass, String... orderbys) {
		List retorno = null;

		try {
			String query = "select o from " + klass.getSimpleName()
					+ "  o  order by ";

			for (String order : orderbys) {
				query += order + " , ";
			}
			query = query.substring(0, query.length() - 2);
			Query q = JPAUtil.getEntityManager().createQuery(query);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> findByAllClass(Class<T> klass) {
		List retorno = null;
		try {
			String query = "select o from " + klass.getSimpleName() + "  o ";
			Query q = JPAUtil.getEntityManager().createQuery(query);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> findByProperty(Class<T> klass, String propertyName,
			Object propertyValue) {
		List retorno = null;
		try {
			String query = "select o from " + klass.getSimpleName()
					+ "  o  where o." + propertyName + "  = :propertyValue ";
			Query q = JPAUtil.getEntityManager().createQuery(query)
					.setParameter("propertyValue", propertyValue);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> findByProperty(Class<T> klass, String propertyName,
			Object propertyValue, String operador, String... orderbys) {
		List retorno = null;
		try {
			String query = null;
			if (!operador.equalsIgnoreCase("like")) {
				query = "select o from " + klass.getSimpleName()
						+ "  o  where o." + propertyName + "  " + operador
						+ " :propertyValue ";
			} else {
				query = "select o from " + klass.getSimpleName()
						+ "  o  where upper(o." + propertyName + ")  "
						+ operador + " upper(:propertyValue) ";
			}

			if (orderbys != null && orderbys.length > 0) {
				query += " order by ";
				for (String order : orderbys) {
					query += "o." + order + " , ";
				}
				query = query.substring(0, query.length() - 2);
			}

			Query q = JPAUtil.getEntityManager().createQuery(query)
					.setParameter("propertyValue", propertyValue);
			retorno = q.getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> findByProperty(Class<T> klass, String propertyName,
			Object propertyValue, String operador) {
		List retorno = null;
		try {
			String query = "select o from " + klass.getSimpleName()
					+ "  o  where o." + propertyName + "  " + operador
					+ " :propertyValue ";

			Query q = JPAUtil.getEntityManager().createQuery(query)
					.setParameter("propertyValue", propertyValue);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByScript(String queryLabel) {
		Query query = JPAUtil.getEntityManager().createQuery(queryLabel);
		return query.getResultList();
	}

	public <T> List<T> findByScriptNativeQuery(Class<T> klass, String query,
			Map<String, Object> map) {
		try {
			Query qry = JPAUtil.getEntityManager().createNativeQuery(query,
					klass);
			if (!map.equals(null)) {
				if (map.size() > 0) {
					for (Entry<String, Object> str : map.entrySet()) {
						qry.setParameter(str.getKey(), str.getValue());
					}
				}
			}
			List<T> objs = qry.getResultList();

			return objs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Object[]> findByScriptNativeQuery(String query,
			Map<String, Object> map) {
		try {
			Query qry = JPAUtil.getEntityManager().createNativeQuery(query);
			if (!map.equals(null)) {
				if (map.size() > 0) {
					for (Entry<String, Object> str : map.entrySet()) {
						qry.setParameter(str.getKey(), str.getValue());
					}
				}
			}
			List<Object[]> objs = qry.getResultList();
			return objs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Object[]> findByScriptNativeQuery(String query) {
		try {
			Query qry = JPAUtil.getEntityManager().createNativeQuery(query);
			List<Object[]> objs = qry.getResultList();
			return objs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> List<T> findByParamsQuery(String query, Map<String, Object> map) {
		try {
			Query qry = JPAUtil.getEntityManager().createQuery(query);
			if (map.size() > 0) {
				for (Entry<String, Object> str : map.entrySet()) {
					qry.setParameter(str.getKey(), str.getValue());
				}
			}
			List<T> objs = qry.getResultList();
			return objs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findByEntityFields(
			Class<? extends Object> classAction,
			QueryMetaDataEntity queryMetaData, String... propertyNames) {

		String pqlBuf = "";
		pqlBuf = ("SELECT p.id");
		for (int i = 0; i < propertyNames.length; i++) {
			pqlBuf = pqlBuf + (",");
			pqlBuf = pqlBuf + ("p.");
			pqlBuf = pqlBuf + (propertyNames[i]);
		}
		pqlBuf = pqlBuf + (" FROM " + classAction.getSimpleName() + " p");

		if (queryMetaData.getPropertyName() != null) {
			pqlBuf = pqlBuf + (" WHERE p.");
			pqlBuf = pqlBuf + (queryMetaData.getPropertyName());
			if (queryMetaData.getSearchTerm() == null) {
				pqlBuf = pqlBuf + (" IS NULL");
			} else {
				pqlBuf = pqlBuf + (" = :searchTerm");
			}
		}

		if (queryMetaData != null && queryMetaData.getAscending().length > 0) {
			pqlBuf = pqlBuf + (" ORDER BY ");
			for (int i = 0; i < queryMetaData.getAscending().length; i++) {
				if (i > 0) {
					pqlBuf = pqlBuf + (",");
				}
				pqlBuf = pqlBuf + ("p.");
				pqlBuf = pqlBuf + (queryMetaData.getOrderBy()[i]);
				if (!queryMetaData.getAscending()[i]) {
					pqlBuf = pqlBuf + (" DESC");
				}
			}
		}

		String pql = pqlBuf;
		Query query = JPAUtil.getEntityManager().createQuery(pql);
		if (queryMetaData.getPropertyName() != null
				&& queryMetaData.getSearchTerm() != null) {
			query.setParameter("searchTerm", queryMetaData.getSearchTerm());
		}

		List<Object[]> result = query.getResultList();
		return result;

	}
}
