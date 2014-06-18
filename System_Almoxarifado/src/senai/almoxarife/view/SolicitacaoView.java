/*
 * Nome: Sistema de almoxarifado(SESI/SENAI),
 * Autor: Empresa Jr,
 * data: 22/05/2014.
 * */

package senai.almoxarife.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JLabel;

import senai.almoxarife.tableModel.SolicitacaoTabelMode;
import senai.almoxarife.dao.HibernateManager;
import senai.almoxarife.empity.Material;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoView extends JFrame {

	// COMPONENTES....
	private JButton btnPesquisa, btnAtualizar, btnInserir, btnConfirmar,
			btncancelar, btnRemover;

	private JPanel contentPane, panelEsquerdo, panelDireito,
			panelInserirMateriais;

	private JTable tblMateriais, tblMateriaisSolicitados;

	private JTextField textPesquisaMaterial, textQnt, textData;

	private JScrollPane scrollPaneTableMaterial,
			scrollPaneTableMateriaisSolicitados;

	private JLabel lblQuantidade, lblData;

	private JComboBox comboBoxSetores;

	private List<Material> listMateriais,
			lisMaterialSolicitado = new ArrayList<Material>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitacaoView frame = new SolicitacaoView();
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
	public SolicitacaoView() {
		// CARACTERISTICAS DA JANELA....
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		/*
		 * instanciando painel esquerdo:com tabela materiais em estoque,com
		 * campo para indicar materia a ser pesquisado,com botão para confirmar
		 * pesquisa,com lista de setores,com botao para atualizar tabela de
		 * mareteriais em estoque,com painel que organizara campos e botões para
		 * incluir material na tabela de materiais a serem solicitados,com campo
		 * para indicar a quantidade do material a ser incluido na tabela de
		 * materiais a serem solicitados,com botão para confirmar inclusão de
		 * material na tabela de materiais a serem solicitados.
		 */
		panelEsquerdo = new JPanel();
		panelEsquerdo.setBorder(new TitledBorder(null, "Materiais",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEsquerdo.setLayout(null);

		// TABELA(LISTA DE MATERIAIS).
		tblMateriais = new JTable();

		// SCROLLPANE(AMAZENARA A TABELA DE MATERIAIS).
		scrollPaneTableMaterial = new JScrollPane(tblMateriais);
		scrollPaneTableMaterial.setBounds(10, 65, 522, 402);
		// ADD AO PAINEL ESQUERDO
		panelEsquerdo.add(scrollPaneTableMaterial);

		// CAMPO(PARA INSERIR NOME DO MATERIAL A SER PESQUISADO).
		textPesquisaMaterial = new JTextField();
		textPesquisaMaterial.setBounds(10, 29, 163, 25);
		// ADD AO PAINEL ESQUERDO
		panelEsquerdo.add(textPesquisaMaterial);

		// BOTÕES(PESQUISAR, ATUALIZAR TABELA).
		btnPesquisa = new JButton("Buscar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPesquisa.setBounds(194, 29, 75, 25);
		btnAtualizar = new JButton("Refresh");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setBounds(442, 478, 90, 25);
		// ADD AO PAINEL ESQUERDO
		panelEsquerdo.add(btnPesquisa);
		panelEsquerdo.add(btnAtualizar);

		// COMBOBOX(LISTA DE SETORES).
		comboBoxSetores = new JComboBox(HibernateManager.findAllObject(
				"select a.nome from Almoxarifado a").toArray());
		comboBoxSetores.setBounds(314, 29, 218, 25);
		// ADD AO PAINEL ESQUERDO
		panelEsquerdo.add(comboBoxSetores);

		/*
		 * Painel de funcionalidades ao inserir materiais: com label indicando
		 * "quantidade", com campo para quantidade de material a ser inserido na
		 * tabela de materiais a serem solicitados, com botão para confirmar
		 * inclusão de material na tabela de materiais solicitados
		 */
		panelInserirMateriais = new JPanel();
		panelInserirMateriais.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInserirMateriais.setBounds(10, 527, 522, 85);
		panelInserirMateriais.setLayout(null);

		// LABEL(INDICANDO "Quantidade").
		lblQuantidade = new JLabel("Quantidade:*");
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 13));
		lblQuantidade.setBounds(10, 11, 99, 25);
		// ADD AO PAINEL DE INSERIR MATERIAIS.
		panelInserirMateriais.add(lblQuantidade);

		// CAMPO(PARA INDICAR A QUANTIDADE DE MATERIAIS A SEREM INCLUIDOS).
		textQnt = new JTextField();
		textQnt.setFont(new Font("Tahoma", Font.BOLD, 13));
		textQnt.setBounds(10, 37, 99, 25);
		// ADD AO PAINEL DE INSERIR MATERIAIS.
		panelInserirMateriais.add(textQnt);

		// BOTÃO(CONFIRMA INSERÇÃO DE MATERIAL À TABELA DE MATERIAIS A SEREM
		// SOLICITADOS).
		btnInserir = new JButton("Incluir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				incluirMaterialSolicitacao();
			}
		});
		btnInserir.setBounds(428, 35, 84, 31);
		// ADD AO PAINEL DE INSERIR MATERIAIS.
		panelInserirMateriais.add(btnInserir);

		// ADD O PAINEL DE INSERIR MATEIRIAIS AO PAINEL ESQUERDO.
		panelEsquerdo.add(panelInserirMateriais);

		/*
		 * Instanciando painel direito:com tabela de materiais que estão sendo
		 * solicitados,com label indicando "data",com campo para data da
		 * solicitação,com botões para confirmar e cancelar solicitação.
		 */
		panelDireito = new JPanel();
		panelDireito.setBorder(new TitledBorder(null,
				"Finalizar Solicita\u00E7\u00E3o", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelDireito.setLayout(null);

		// TABELA(ARMAZENARA OS ITENS PRE-SOLICITADOS).
		tblMateriaisSolicitados = new JTable();

		// SCROLLPANE(ARMAZENARA A TABELA DE MATERIAIS A SEREM SOLICITADOS).
		scrollPaneTableMateriaisSolicitados = new JScrollPane(
				tblMateriaisSolicitados);
		scrollPaneTableMateriaisSolicitados.setBounds(10, 27, 522, 185);
		// ADD AO PAINEL DIREITO.
		panelDireito.add(scrollPaneTableMateriaisSolicitados);

		// CAMPO(ONDE SERA INSERIDA A DATA EM QUE ESTARA SENDO FEITA A
		// SOLICITAÇÃO).
		textData = new JTextField();
		textData.setBounds(10, 248, 112, 25);
		// ADD AO PAINEL DIREITO.
		panelDireito.add(textData);

		// LABEL(INDICANDO "DATA").
		lblData = new JLabel("Data:*");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(10, 223, 58, 25);
		// ADD AO PAINEL DIREITO.
		panelDireito.add(lblData);

		// BOTÕES(CONFIRMAR E CANCELAR)
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnConfirmar.setBounds(260, 558, 95, 37);

		btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btncancelar.setBounds(390, 558, 95, 37);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tblMateriaisSolicitados.getSelectedRow();

				if (row == -1) {
					JOptionPane
							.showMessageDialog(null, "Selecione um Material");
					return;
				}

				if (lisMaterialSolicitado.isEmpty()) {
					System.out.println("Lista vazia...");
				} else {
					lisMaterialSolicitado.remove(tblMateriaisSolicitados
							.getSelectedRow());

					tblMateriaisSolicitados.setModel(new SolicitacaoTabelMode(
							lisMaterialSolicitado));
				}

			}
		});
		btnRemover.setBounds(427, 225, 89, 25);
		// ADD AO PAINEL DIREITO.
		panelDireito.add(btnConfirmar);
		panelDireito.add(btncancelar);
		panelDireito.add(btnRemover);

		/*
		 * //////////////////////////////////////////////ADD PAINEIS AO
		 * CONTAINER PRINCIPAL DA
		 * JANELA\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		 */
		// PAINEL ESQUERDO.
		contentPane.add(panelEsquerdo);
		// PAINEL DIREITO.
		contentPane.add(panelDireito);

		// Lista todos oa materiais na Tabela
		refreshTable();
	}

	private void refreshTable() {
		listMateriais = HibernateManager
				.findAllObject("select m from Material m");
		if (listMateriais != null) {
			tblMateriais.setModel(new SolicitacaoTabelMode(listMateriais));
		}
	}

	private void incluirMaterialSolicitacao() {
		int row = tblMateriais.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Selecione um Material");
			return;
		}
		// List<Material> lisMat = new ArrayList<>();
		Material material = new SolicitacaoTabelMode(listMateriais).get(row);
		lisMaterialSolicitado.add(material);

		if (lisMaterialSolicitado != null) {
			tblMateriaisSolicitados.setModel(new SolicitacaoTabelMode(
					lisMaterialSolicitado));
		}
	}
}
