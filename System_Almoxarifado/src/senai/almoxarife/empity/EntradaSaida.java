package senai.almoxarife.empity;

import java.sql.Date;
import java.util.Calendar;

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
	private Calendar dataInOu;
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
	
	public Calendar getDataInOu() {
		return dataInOu;
	}
	public void setDataInOu(Calendar dataInOu) {
		this.dataInOu = dataInOu;
	}
	public int getEstadoEntradaSaida() {
		return estadoEntradaSaida;
	}
	public void setEstadoEntradaSaida(int estadoEntradaSaida) {
		this.estadoEntradaSaida = estadoEntradaSaida;
	}
	
	
	
}
