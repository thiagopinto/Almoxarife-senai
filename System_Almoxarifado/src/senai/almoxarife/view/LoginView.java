package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textSenha;
	private JButton btnCancelar, btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder("Login"));
		panelLogin.setBounds(52, 27, 274, 195);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsurio.setBounds(56, 11, 65, 16);
		panelLogin.add(lblUsurio);

		textUser = new JTextField();
		textUser.setBounds(56, 36, 160, 25);
		panelLogin.add(textUser);
		textUser.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(56, 67, 55, 16);
		panelLogin.add(lblSenha);

		textSenha = new JPasswordField();
		textSenha.setBounds(56, 92, 160, 25);
		panelLogin.add(textSenha);
		textSenha.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				textUser.setText("");
				textSenha.setText("");
			}
		});
		btnCancelar.setBounds(45, 138, 89, 23);
		panelLogin.add(btnCancelar);

		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Usuario usuario = Logar(Integer.parseInt(textUser.getText()),
						textSenha.getText());

				if (usuario != null) {
					
					new TelaInicioForm(usuario).setVisible(true);
					dispose();
					
				} else {
					System.out.println("Usuario nao existe!!!");
				}
			}
		});
		btnEntrar.setBounds(144, 138, 89, 23);
		panelLogin.add(btnEntrar);
	}

	private Usuario Logar(Integer matricula, String senha) {
		Usuario usuario = null;
		try {
			usuario = (Usuario) HibernateManager.findAllObject(
					"select u from Usuario u where u.matricula = " + matricula
							+ "and u.senha = '" + senha + "'").get(0);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Usuario ou senha invalida");
			return null;
		}

		return usuario;

	}
}
