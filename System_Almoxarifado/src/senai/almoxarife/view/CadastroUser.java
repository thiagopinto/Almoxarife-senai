package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Setor;
import senai.almoxarife.empity.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUser extends JFrame implements ActionListener {

	private static final int USER_ADM = 1;
	private static final int USER_SIMPLES = 2;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textMatricula;
	private JComboBox textSetor;
	private JTextField textTelefon;
	private JTextField textEmail;
	private JTextField textSenha;
	private JRadioButton itemSimples;
	private JRadioButton itemAdministrador;
	private JButton btnGravar;
	private JButton btnCancelar;
	private int nivelUser;

	/**
	 * Create the frame.
	 */
	public CadastroUser() {
		super("Cadastro de Usuário");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 281);
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
				onSalvar();
			}
		});
		panelNorte.add(btnGravar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {

			@Override
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

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 10, 46, 15);
		panel.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(10, 25, 255, 25);
		panel.add(textNome);
		textNome.setColumns(100);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(275, 11, 61, 15);
		panel.add(lblMatricula);

		textMatricula = new JTextField();
		textMatricula.setBounds(275, 25, 86, 25);
		panel.add(textMatricula);
		textMatricula.setColumns(10);

		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(10, 55, 46, 15);
		panel.add(lblSetor);

		textSetor = new JComboBox(HibernateManager.findAllObject(
				"select nome from Setor s").toArray());
		textSetor.setBounds(10, 70, 214, 25);
		panel.add(textSetor);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(275, 55, 61, 15);
		panel.add(lblTelefone);

		textTelefon = new JTextField();
		textTelefon.setBounds(275, 70, 111, 25);
		panel.add(textTelefon);
		textTelefon.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 100, 46, 14);
		panel.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(10, 115, 255, 25);
		panel.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(275, 100, 46, 15);
		panel.add(lblSenha);

		textSenha = new JPasswordField();
		textSenha.setBounds(275, 115, 111, 25);
		panel.add(textSenha);

		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(10, 145, 34, 15);
		panel.add(lblNivel);

		/*-----------------||Grupo de RadiosButtons||-------------------*/
		ButtonGroup grupoRadio = new ButtonGroup();
		itemSimples = new JRadioButton("Simples");
		itemSimples.addActionListener(this);
		itemSimples.setBounds(10, 160, 71, 23);
		panel.add(itemSimples);

		itemAdministrador = new JRadioButton("Administrador");
		itemAdministrador.addActionListener(this);
		itemAdministrador.setBounds(83, 160, 110, 23);
		panel.add(itemAdministrador);

		grupoRadio.add(itemSimples);
		grupoRadio.add(itemAdministrador);
		/*-----------------||Grupo de RadiosButtons||-------------------*/

	}

	/*------------||Tratamento dos RadiosButtons||-------------*
	 * --------------||Metodo actionPerformed||-------------*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (itemSimples.isSelected()) {
			nivelUser = USER_SIMPLES;
			// System.out.println(USER_SIMPLES);
		} else if (itemAdministrador.isSelected()) {
			nivelUser = USER_ADM;
			// System.out.println(USER_ADM);
		}

	}

	private void onSalvar() {
		Setor setor = (Setor) HibernateManager.findAllObject(
				"select s from Setor s where nome = '"
						+ textSetor.getSelectedItem() + "'").get(0);
		Usuario usuario = new Usuario();
		usuario.setNome(textNome.getText());
		usuario.setMatricula(Integer.parseInt(textMatricula.getText()));
		usuario.setEmail(textEmail.getText());
		usuario.setTelefone(textTelefon.getText());
		usuario.setNivel(nivelUser);
		usuario.setSenha(textSenha.getText());
		usuario.setSetor(setor);

		HibernateManager.persistirObject(usuario);

		int confirm = JOptionPane.showConfirmDialog(null,
				"Deseja efetuar um novo cadastro?", "Novo Cadastro",
				JOptionPane.YES_NO_OPTION);

		if (confirm != 0) {
			dispose();
		} else {

			textNome.setText("");
			textMatricula.setText("");
			textEmail.setText("");
			textTelefon.setText("");
			nivelUser = 0;
			textSenha.setText("");
			textSetor.setSelectedItem("");
			return;

		}

	}

}
