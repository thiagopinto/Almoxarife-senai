package senai.almoxarife.empity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Almoxarifado {
	
	@Id
	@GeneratedValue
	private Long idAlmoxarifado;
	private String nome;
	
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

}
