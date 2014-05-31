package senai.almoxarife.empity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Setor {
	
	@Id @GeneratedValue
	private Long idSetor;
	private String nome;
	
	@OneToOne
	private Almoxarifado almoxerifado;
		
	
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
	public Almoxarifado getAlmoxerifado() {
		return almoxerifado;
	}
	public void setAlmoxerifado(Almoxarifado almoxerifado) {
		this.almoxerifado = almoxerifado;
	}
	
	

}
