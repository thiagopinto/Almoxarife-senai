package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Almoxarifado;
import senai.almoxarife.empity.Setor;
import senai.almoxarife.tableModel.AlmoxarifadoTabelModel;

import javax.swing.JScrollPane;

public class CadastroAlmoxatife extends JFrame {

	private JPanel contentPane;
	private JTextField textAlmoxarife;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JComboBox comboSetor;
	private JTable tabelaAlmoxarife;
	private List<Almoxarifado> listAlmoxarife;

	/**
	 * Create the frame.
	 */
	public CadastroAlmoxatife() {
		setTitle("Cadastro de Almaxarifado");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 1));
		setContentPane(contentPane);

		/*-----------//painel norte\\-------------*/
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		/*-----------//Bot�es gravar e cancelar\\-------------*/
		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				List<Long> idSetor = HibernateManager
						.findAllObject("select s.idSetor from Setor s where nome = '"
								+ comboSetor.getSelectedItem() + "'");

				Almoxarifado almoxarifado = new Almoxarifado();
				almoxarifado.setNome(textAlmoxarife.getText());

				Setor setor = HibernateManager.findObject(Setor.class,
						idSetor.get(0));
				setor.setAlmoxerifados(almoxarifado);

				HibernateManager.persistirObject(almoxarifado);

				int confirm = JOptionPane.showConfirmDialog(null,
						"Deseja efetuar um novo cadastro?", "Novo Cadastro",
						JOptionPane.YES_NO_OPTION);

				if (confirm != 0) {
					dispose();					
				} else {
					textAlmoxarife.setText("");
					refreshTable();
					return;
				}
			}
		});
		panelNorte.add(btnGravar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null,
						"Cancelar cadastro?", "Cancelar",
						JOptionPane.YES_NO_OPTION);

				if (confirm != 0) {
					return;
				} else {
					dispose();
				}

			}
		});
		panelNorte.add(btnCancelar);
		/*-----------//Bot�es\\-------------*/

		/*-----------//painel center\\-------------*/
		JPanel panelCenter = new JPanel();
		panelCenter
				.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(null);

		JLabel lblAlmoxarifado = new JLabel("Almoxarifado:");
		lblAlmoxarifado.setBounds(10, 11, 84, 14);
		panelCenter.add(lblAlmoxarifado);

		textAlmoxarife = new JTextField();
		textAlmoxarife.setBounds(10, 31, 219, 25);
		panelCenter.add(textAlmoxarife);
		textAlmoxarife.setColumns(10);

		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(254, 11, 46, 14);
		panelCenter.add(lblSetor);

		comboSetor = new JComboBox(HibernateManager.findAllObject(
				"select s.nome from Setor s").toArray());
		comboSetor.setBounds(254, 31, 160, 25);
		panelCenter.add(comboSetor);
		
		tabelaAlmoxarife = new JTable();
		JScrollPane scrollTable = new JScrollPane(tabelaAlmoxarife);
		scrollTable.setBounds(10, 75, 404, 167);
		panelCenter.add(scrollTable);
		
		refreshTable();
	}
	
	private void refreshTable(){
		listAlmoxarife = HibernateManager.findAllObject("select a from Almoxarifado a");
		if(listAlmoxarife != null){
			tabelaAlmoxarife.setModel(new AlmoxarifadoTabelModel(listAlmoxarife));
		}
	}
	public static void main(String[] args) {
		new CadastroAlmoxatife().setVisible(true);
	}
}
