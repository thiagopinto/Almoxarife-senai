package senai.almoxarife.empity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntradaSaida {
	
	@Id
	@GeneratedValue
	private Long idEntradaSaida;
	private int quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInOu;
	private int estadoEntradaSaida;
	
	
	public Long getIdEntradaSaida() {
		return idEntradaSaida;
	}
	public void setIdEntradaSaida(Long idEntradaSaida) {
		this.idEntradaSaida = idEntradaSaida;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getDataInOu() {
		return dataInOu;
	}
	public void setDataInOu(Date dataInOu) {
		this.dataInOu = dataInOu;
	}
	public int getEstadoEntradaSaida() {
		return estadoEntradaSaida;
	}
	public void setEstadoEntradaSaida(int estadoEntradaSaida) {
		this.estadoEntradaSaida = estadoEntradaSaida;
	}
	
	
	
}
