package senai.almoxarife.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import senai.almoxarife.empity.Usuario;

public class UsuarioTableModel extends AbstractTableModel{
	
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_MATRIC = 2;
	private static final int COL_TEL = 3;
	private static final int COL_EMAIL = 4;
	private static final int COL_NIVEL = 5;
	
	private List<Usuario> user;
	
	public UsuarioTableModel(List<Usuario> user) {
		this.user = user;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return user.size();
	}

	@Override
	public Object getValueAt(int row, int colunm) {
		// TODO Auto-generated method stub
		Usuario usuario = user.get(row);
		
		if(colunm == COL_ID){
			return usuario.getIdUsuario();
		}else if(colunm == COL_NOME){
			return usuario.getNome();
		}else if(colunm == COL_MATRIC){
			return usuario.getMatricula();
		}else if(colunm == COL_EMAIL){
			return usuario.getEmail();
		}else if(colunm == COL_TEL){
			return usuario.getTelefone();
		}else if(colunm == COL_NIVEL){
			return usuario.getNivel();
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
		case COL_MATRIC:
			coluna = "Matricula";
		case COL_EMAIL:
			coluna = "E-Mail";
			break;
		case COL_TEL:
			coluna = "Telefone";
			break;
		case COL_NIVEL:
			coluna = "Nivel";
			break;

		default:
			throw new IllegalArgumentException("Coluna invalida!!!");
		}
		return coluna;
	}

}
