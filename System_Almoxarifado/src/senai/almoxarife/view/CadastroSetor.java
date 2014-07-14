package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Setor;

public class CadastroSetor extends JFrame {

	private JPanel contentPane;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JTextField textSetor;
	private JTable tabelaSetor;
	private List<Setor> listSetor;


	/**
	 * Create the frame.
	 */
	public CadastroSetor() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 1));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		/*-----------------||Buttons||-------------------*/
		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Setor setor = new Setor();
			setor.setNome(textSetor.getText());
			
			HibernateManager.persistirObject(setor);
			int confirm = JOptionPane.showConfirmDialog(null, "Deseja efetuar um novo cadastro?", "Novo Cadastro",
					JOptionPane.YES_NO_OPTION);
			
			if(confirm != 0){
				dispose();
			}else{
				
				textSetor.setText("");
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
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(10, 11, 46, 15);
		panel.add(lblSetor);
		
		textSetor = new JTextField();
		textSetor.setBounds(10, 30, 404, 25);
		panel.add(textSetor);
		textSetor.setColumns(10);
	}

}
