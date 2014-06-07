package senai.almoxarife.empity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemEntradaSaida {

	@Id
	@GeneratedValue
	private int idItemEntradaSaida;
	
	private int quantidade;
	
	@OneToOne
	private Material material;

	
	public int getIdItemEntradaSaida() {
		return idItemEntradaSaida;
	}

	public void setIdItemEntradaSaida(int idItemEntradaSaida) {
		this.idItemEntradaSaida = idItemEntradaSaida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
}
