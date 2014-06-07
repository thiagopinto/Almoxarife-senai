package senai.almoxarife.empity;

import java.sql.Date;
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
public class EntradaSaida {
	
	@Id
	@GeneratedValue
	private Long idEntradaSaida;
	
	@ManyToOne
	private Usuario responsavel;
	
	@OneToMany
	private Collection<ItemEntradaSaida> itens;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInOu;
	
	private boolean tipo;
	

	public Long getIdEntradaSaida() {
		return idEntradaSaida;
	}

	public void setIdEntradaSaida(Long idEntradaSaida) {
		this.idEntradaSaida = idEntradaSaida;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Collection<ItemEntradaSaida> getItens() {
		return itens;
	}

	public void setItens(Collection<ItemEntradaSaida> itens) {
		this.itens = itens;
	}

	public Calendar getDataInOu() {
		return dataInOu;
	}

	public void setDataInOu(Calendar dataInOu) {
		this.dataInOu = dataInOu;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	
	
}
