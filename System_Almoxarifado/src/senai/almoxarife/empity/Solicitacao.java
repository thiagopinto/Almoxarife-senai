package senai.almoxarife.empity;

import java.sql.Date;

public class Solicitacao {
	
	private Long idSolicitacao;
	private Date dataSoli;
	private String statusSol;
	private Long idAlmoxarifado;
	private Long idUsuario;
	
	public Long getIdSolicitacao() {
		return idSolicitacao;
	}
	public void setIdSolicitacao(Long idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
	public Date getDataSoli() {
		return dataSoli;
	}
	public void setDataSoli(Date dataSoli) {
		this.dataSoli = dataSoli;
	}
	public String getStatusSol() {
		return statusSol;
	}
	public void setStatusSol(String statusSol) {
		this.statusSol = statusSol;
	}
	public Long getIdAlmoxarifado() {
		return idAlmoxarifado;
	}
	public void setIdAlmoxarifado(Long idAlmoxarifado) {
		this.idAlmoxarifado = idAlmoxarifado;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
