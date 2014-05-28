package senai.almoxarife.empity;

import java.sql.Date;

public class EntradaSaida {
	
	private Long idEntradaSaida;
	private int quantidade;
	private Date dataInOu;
	private int estado;
	private int idAlmoxarifado;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdAlmoxarifado() {
		return idAlmoxarifado;
	}
	public void setIdAlmoxarifado(int idAlmoxarifado) {
		this.idAlmoxarifado = idAlmoxarifado;
	}
	

}
