package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class CadastroAlmoxatife extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JComboBox comboSetor;


	/**
	 * Create the frame.
	 */
	public CadastroAlmoxatife() {
		setTitle("Cadastro de Almaxarifado");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 1));
		setContentPane(contentPane);
		
		/*-----------//painel norte\\-------------*/
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		/*-----------//Botões gravar e cancelar\\-------------*/
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
		/*-----------//Botões\\-------------*/
		
		
		/*-----------//painel center\\-------------*/
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(null);
		
		JLabel lblAlmoxarifado = new JLabel("Almoxarifado:");
		lblAlmoxarifado.setBounds(10, 10, 84, 14);
		panelCenter.add(lblAlmoxarifado);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 219, 25);
		panelCenter.add(textField);
		textField.setColumns(10);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(250, 10, 46, 15);
		panelCenter.add(lblSetor);
		
		comboSetor = new JComboBox();
		comboSetor.setBounds(250, 30, 164, 25);
		panelCenter.add(comboSetor);
	}
}
