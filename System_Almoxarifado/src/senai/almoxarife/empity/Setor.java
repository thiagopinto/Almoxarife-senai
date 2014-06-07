package senai.almoxarife.empity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Setor {
	
	@Id @GeneratedValue
	private Long idSetor;
	private String nome;
	
	@OneToMany
	private Collection<Almoxarifado> almoxerifados;
		
	
	public Long getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Collection<Almoxarifado> getAlmoxerifados() {
		return almoxerifados;
	}
	public void setAlmoxerifados(Almoxarifado almoxerifados) {
		this.almoxerifados.add(almoxerifados);
	}

	
	

}
