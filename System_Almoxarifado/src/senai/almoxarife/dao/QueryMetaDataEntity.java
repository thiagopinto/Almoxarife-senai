package senai.almoxarife.dao;

import java.io.Serializable;

public class QueryMetaDataEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4133218436629394490L;
	private boolean[] ascending;
	private String[] orderBy;
	private String searchTerm;
	private String propertyName;

	public QueryMetaDataEntity(String propertyName, String searchTerm,
			String[] orderBy, boolean[] ascending) {
		this.propertyName = propertyName;
		this.searchTerm = searchTerm;
		this.ascending = ascending;
		this.orderBy = orderBy;
	}

	public QueryMetaDataEntity(String[] orderBy, boolean[] ascending) {
		this(null, null, orderBy, ascending);
	}

	public boolean[] getAscending() {
		return ascending;
	}

	public String[] getOrderBy() {
		return orderBy;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public String getPropertyName() {
		return propertyName;
	}
}