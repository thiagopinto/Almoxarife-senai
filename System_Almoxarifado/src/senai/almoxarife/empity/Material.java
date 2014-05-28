package senai.almoxarife.empity;

public class Material {

	private Long idMaterial;
	private String nome;
	private String unidade;
	private int estoqueMax;
	private int estoqueMin;
	
	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public int getEstoqueMax() {
		return estoqueMax;
	}
	public void setEstoqueMax(int estoqueMax) {
		this.estoqueMax = estoqueMax;
	}
	public int getEstoqueMin() {
		return estoqueMin;
	}
	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

}
