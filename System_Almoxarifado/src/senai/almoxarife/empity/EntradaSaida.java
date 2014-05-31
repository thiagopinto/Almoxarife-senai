package senai.almoxarife.empity;

import java.sql.Date;

public class EntradaSaida {
	
	private Long idEntradaSaida;
	private int quantidade;
	private Date dataInOu;
	private int estadoEntradaSaida;
	private Long idAlmoxarifado;
	
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
	public Long getIdAlmoxarifado() {
		return idAlmoxarifado;
	}
	public void setIdAlmoxarifado(Long idAlmoxarifado) {
		this.idAlmoxarifado = idAlmoxarifado;
	}
	
	
}
