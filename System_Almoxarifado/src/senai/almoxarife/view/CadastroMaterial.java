package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class CadastroMaterial extends JFrame {

	
	private JPanel contentPane;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JTextField textMaterial;
	private JLabel lblUnidade;
	private JComboBox comboBox;
	private JLabel lblEstoqueMinimo;
	private JTextField textEstoqueMin;
	private JLabel lblEstoqueMximo;
	private JTextField textEstoqueMax;

	

	/**
	 * Create the frame.
	 */
	public CadastroMaterial() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 213);
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
			}
		});
		panelNorte.add(btnGravar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		textMaterial.setBounds(10, 30, 404, 25);
		panel.add(textMaterial);
		textMaterial.setColumns(10);
		
		lblUnidade = new JLabel("Unidade:");
		lblUnidade.setBounds(10, 65, 50, 14);
		panel.add(lblUnidade);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 85, 130, 25);
		panel.add(comboBox);
		
		lblEstoqueMinimo = new JLabel("Estoque Minimo:");
		lblEstoqueMinimo.setBounds(182, 65, 95, 14);
		panel.add(lblEstoqueMinimo);
		
		textEstoqueMin = new JTextField();
		textEstoqueMin.setBounds(182, 85, 86, 25);
		panel.add(textEstoqueMin);
		textEstoqueMin.setColumns(10);
		
		lblEstoqueMximo = new JLabel("Estoque M\u00E1ximo:");
		lblEstoqueMximo.setBounds(300, 65, 100, 14);
		panel.add(lblEstoqueMximo);
		
		textEstoqueMax = new JTextField();
		textEstoqueMax.setBounds(300, 85, 86, 25);
		panel.add(textEstoqueMax);
		textEstoqueMax.setColumns(10);

	}
}
