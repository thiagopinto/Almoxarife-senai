package senai.almoxarife.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import senai.almoxarife.empity.Almoxarifado;

public class AlmoxarifadoTabelModel extends AbstractTableModel{
	
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private List<Almoxarifado> almoxarifado;
	
	public AlmoxarifadoTabelModel(List<Almoxarifado> almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return almoxarifado.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Almoxarifado almoxarife = almoxarifado.get(row);
		
		if(column == COL_ID){
			return almoxarife.getIdAlmoxarifado();
		}else if(column == COL_NOME){
			return almoxarife.getNome();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		String coluna = "";
		switch (column) {
		case COL_ID:
			coluna = "Codigo";
			break;
		case COL_NOME:
			coluna = "Nome";
			break;
		default:
			throw new IllegalArgumentException("Coluna invalida!!!");			
		}
		return coluna;
	}

}
