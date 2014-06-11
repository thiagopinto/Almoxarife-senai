package senai.almoxarife.empity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Solicitacao {
	
	@Id
	@GeneratedValue
	private Long idSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataSoli;
	
	private String statusSol;
	
	@OneToMany
	private Collection<Almoxarifado> almoxarifados;
	
	@ManyToOne
	private Usuario usuario;
	
	public Solicitacao() {
		almoxarifados = new ArrayList<Almoxarifado>();
	}
	
	
	public Long getIdSolicitacao() {
		return idSolicitacao;
	}
	public void setIdSolicitacao(Long idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
	
	public Calendar getDataSoli() {
		return dataSoli;
	}
	public void setDataSoli(Calendar dataSoli) {
		this.dataSoli = dataSoli;
	}
	public String getStatusSol() {
		return statusSol;
	}
	public void setStatusSol(String statusSol) {
		this.statusSol = statusSol;
	}
	
	public Collection<Almoxarifado> getAlmoxarifados() {
		return almoxarifados;
	}
	public void setAlmoxarifados(Almoxarifado almoxarifados) {
		this.almoxarifados.add(almoxarifados);
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
