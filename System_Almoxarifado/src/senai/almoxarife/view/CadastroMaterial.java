package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Material;
import javax.swing.DefaultComboBoxModel;

public class CadastroMaterial extends JFrame {

	
	private JPanel contentPane;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JTextField textMaterial;
	
	private JComboBox comboUnidade;
	
	private JTextField textEstoqueMin;
	
	private JTextField textEstoqueMax;
	private JTextArea textDescricao;

	

	/**
	 * Create the frame.
	 */
	public CadastroMaterial() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
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
				Material material = new Material();
				material.setNome(textMaterial.getText());
				material.setEstoqueMin(Integer.parseInt(textEstoqueMin.getText()));
				material.setEstoqueMax(Integer.parseInt(textEstoqueMax.getText()));
				material.setUnidade(comboUnidade.getSelectedItem().toString());
				material.setDescricao(textDescricao.getText());
				
				HibernateManager.persistirObject(material);
				
				int confirm = JOptionPane.showConfirmDialog(null, "Deseja efetuar um novo cadastro?", "Novo Cadastro",
						JOptionPane.YES_NO_OPTION);
				
				if(confirm != 0){
					dispose();
				}else{
					
					textMaterial.setText("");
					textEstoqueMax.setText("");
					textEstoqueMin.setText("");
					comboUnidade.setSelectedItem("");
					textDescricao.setText("");
					return;
				}
			}
		});
		panelNorte.add(btnGravar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Cancelar cadastro?", "Cancelar",
						JOptionPane.YES_NO_OPTION);
				
				if(confirm != 0){
					return;
				}else{
					dispose();
				}
			}
		});
		panelNorte.add(btnCancelar);
		/*-----------------||Buttons||-------------------*/
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(10, 11, 50, 15);
		panel.add(lblMaterial);
		
		textMaterial = new JTextField();
		textMaterial.setBounds(10, 30, 400, 25);
		panel.add(textMaterial);
		textMaterial.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade:");
		lblUnidade.setBounds(10, 65, 50, 14);
		panel.add(lblUnidade);
		
		comboUnidade = new JComboBox();
		comboUnidade.setModel(new DefaultComboBoxModel(
				new String[] {"", "Caixa", "Kg", "Litro", "Metro", "Unidade"}));
		comboUnidade.setBounds(10, 85, 130, 25);
		panel.add(comboUnidade);
		
		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo:");
		lblEstoqueMinimo.setBounds(182, 65, 95, 14);
		panel.add(lblEstoqueMinimo);
		
		textEstoqueMin = new JTextField();
		textEstoqueMin.setBounds(182, 85, 86, 25);
		panel.add(textEstoqueMin);
		textEstoqueMin.setColumns(10);
		
		JLabel lblEstoqueMximo = new JLabel("Estoque M\u00E1ximo:");
		lblEstoqueMximo.setBounds(300, 65, 100, 14);
		panel.add(lblEstoqueMximo);
		
		textEstoqueMax = new JTextField();
		textEstoqueMax.setBounds(300, 85, 86, 25);
		panel.add(textEstoqueMax);
		textEstoqueMax.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 121, 58, 15);
		panel.add(lblDescrio);
		
		textDescricao = new JTextArea();
		textDescricao.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textDescricao);
		scrollPane.setBounds(10, 147, 400, 64);
		panel.add(scrollPane);

	}
}
