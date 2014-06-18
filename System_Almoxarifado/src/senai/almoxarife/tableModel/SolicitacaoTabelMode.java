package senai.almoxarife.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Material;

public class SolicitacaoTabelMode extends AbstractTableModel {
	
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_MIN = 2;
	private static final int COL_MAX = 3;
	private static final int COL_UNID = 4;
	private static final int COL_DESC = 5;
			
	
	List<Material> material;
	
	public SolicitacaoTabelMode(List<Material> material) {
		this.material = material;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return material.size();
	}

	@Override
	public Object getValueAt(int row, int colunm) {
		Material mat = material.get(row);
		
		if(colunm == COL_ID){
			return mat.getIdMaterial();
		}else if(colunm == COL_NOME){
			return mat.getNome();
		}else if(colunm == COL_MIN){
			return mat.getEstoqueMin();
		}else if(colunm == COL_MAX){
			return mat.getEstoqueMax();
		}else if(colunm == COL_UNID){
			return mat.getUnidade();
		}else if(colunm == COL_DESC){
			return mat.getDescricao();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int colunm) {
		String coluna = "";
		switch (colunm) {
		case COL_ID:
			coluna = "Codigo";
			break;
		case COL_NOME:
			coluna = "Material";
			break;
		case COL_UNID:
			coluna = "Unid.Medida";
			break;
		case COL_MIN:
			coluna = "Estoque Minimo";
			break;
		case COL_MAX:
			coluna = "Estoque Maximo";
			break;
		case COL_DESC:
			coluna = "Descrição";
			break;

		default:
			throw new IllegalArgumentException("Coluno Invalida");			
		}
		return coluna;
	}
	
	public Material get(int row){
		return material.get(row);
	}

}
