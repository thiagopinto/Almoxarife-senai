package senai.almoxarife.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import senai.almoxarife.empity.Setor;

public class SetorTableModel extends AbstractTableModel{
	
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;	
	private List<Setor> listSetor;

	public SetorTableModel(List<Setor> listSetor) {
		this.listSetor = listSetor;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listSetor.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Setor setor = listSetor.get(row);
		if(column == COL_ID){
			return setor.getIdSetor();
		}else if(column == COL_NOME){
			return setor.getNome();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
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
