package senai.almoxarife.empity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Almoxarifado {
	
	@Id
	@GeneratedValue
	private Long idAlmoxarifado;
	private String nome;
	
	@ManyToMany
	private Collection<Material> materiais;
	
	public Long getIdAlmoxarifado() {
		return idAlmoxarifado;
	}
	public void setIdAlmoxarifado(Long idAlmoxarifado) {
		this.idAlmoxarifado = idAlmoxarifado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	public Collection<Material> getMateriais() {
		return materiais;
	}
	public void setMateriais(Collection<Material> materiais) {
		this.materiais = materiais;
	}
	

}
