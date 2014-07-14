package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Almoxarifado;
import senai.almoxarife.empity.Material;
import senai.almoxarife.tableModel.MaterialTabelMode;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class CadastroMaterial extends JFrame {

	private JPanel contentPane;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JTextField textMaterial;

	private JComboBox comboUnidade, comboAlmoxarife;

	private JTextField textEstoqueMin;

	private JTextField textEstoqueMax;
	private JTextArea textDescricao;
	private JTable tabelaMaterial;

	private List<Material> materiais;

	/**
	 * Create the frame.
	 */
	public CadastroMaterial() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		/*-----------------||Buttons||-------------------*/
		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Long> idAlmoxa = HibernateManager
						.findAllObject("select a.idAlmoxarifado from Almoxarifado a where nome = '"
								+ comboAlmoxarife.getSelectedItem().toString()
								+ "'");
				
				Almoxarifado almoxarife = HibernateManager.findObject(
						Almoxarifado.class, idAlmoxa.get(0));

				Material material = new Material();
				material.setNome(textMaterial.getText());
				material.setEstoqueMin(Integer.parseInt(textEstoqueMin
						.getText()));
				material.setEstoqueMax(Integer.parseInt(textEstoqueMax
						.getText()));
				material.setUnidade(comboUnidade.getSelectedItem().toString());
				material.setDescricao(textDescricao.getText());
				
				almoxarife.getMateriais().add(material);

				HibernateManager.persistirObject(material);

				int confirm = JOptionPane.showConfirmDialog(null,
						"Deseja efetuar um novo cadastro?", "Novo Cadastro",
						JOptionPane.YES_NO_OPTION);

				if (confirm != 0) {
					dispose();
				} else {

					textMaterial.setText("");
					textEstoqueMax.setText("");
					textEstoqueMin.setText("");
					comboUnidade.setSelectedItem("");
					textDescricao.setText("");
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
		
		/*-----------------||Buttons||-------------------*/
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(1, 2));

		JPanel panelMaterial = new JPanel();
		panelMaterial.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		panelCentral.add(panelMaterial);
		panelMaterial.setLayout(null);

		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(10, 11, 50, 15);
		panelMaterial.add(lblMaterial);

		textMaterial = new JTextField();
		textMaterial.setBounds(10, 30, 353, 25);
		panelMaterial.add(textMaterial);
		textMaterial.setColumns(10);

		JLabel lblUnidade = new JLabel("Unidade:");
		lblUnidade.setBounds(10, 65, 50, 14);
		panelMaterial.add(lblUnidade);

		comboUnidade = new JComboBox();
		comboUnidade.setModel(new DefaultComboBoxModel(new String[] { "",
				"Caixa", "Kg", "Litro", "Metro", "Unidade" }));
		comboUnidade.setBounds(10, 85, 130, 25);
		panelMaterial.add(comboUnidade);

		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo:");
		lblEstoqueMinimo.setBounds(161, 65, 95, 14);
		panelMaterial.add(lblEstoqueMinimo);

		textEstoqueMin = new JTextField();
		textEstoqueMin.setBounds(161, 85, 86, 25);
		panelMaterial.add(textEstoqueMin);
		textEstoqueMin.setColumns(10);

		JLabel lblEstoqueMximo = new JLabel("Estoque M\u00E1ximo:");
		lblEstoqueMximo.setBounds(266, 66, 100, 14);
		panelMaterial.add(lblEstoqueMximo);

		textEstoqueMax = new JTextField();
		textEstoqueMax.setBounds(266, 86, 86, 25);
		panelMaterial.add(textEstoqueMax);
		textEstoqueMax.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 121, 65, 15);
		panelMaterial.add(lblDescrio);

		textDescricao = new JTextArea();
		textDescricao.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textDescricao);
		scrollPane.setBounds(10, 147, 353, 64);
		panelMaterial.add(scrollPane);

		JLabel lblAlmoxarifado = new JLabel("Almoxarifado:");
		lblAlmoxarifado.setBounds(10, 222, 80, 15);
		panelMaterial.add(lblAlmoxarifado);

		comboAlmoxarife = new JComboBox(HibernateManager.findAllObject(
				"select a.nome from Almoxarifado a").toArray());
		comboAlmoxarife.setBounds(10, 244, 258, 25);
		panelMaterial.add(comboAlmoxarife);

		JPanel panelTable = new JPanel();
		panelTable.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelCentral.add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));

		tabelaMaterial = new JTable();
		JScrollPane scrollTable = new JScrollPane(tabelaMaterial);
		panelTable.add(scrollTable);

		refreshTable();

	}

	private void refreshTable() {
		materiais = HibernateManager.findAllObject("select m from Material m");
		if (materiais != null) {
			tabelaMaterial.setModel(new MaterialTabelMode(materiais));
		}
	}

	public static void main(String[] args) {
		new CadastroMaterial().setVisible(true);
	}
}
