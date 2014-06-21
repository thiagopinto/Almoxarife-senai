package senai.almoxarife;


import java.util.Calendar;
import javax.persistence.EntityManager;
import senai.almoxarife.empity.Almoxarifado;
import senai.almoxarife.empity.EntradaSaida;
import senai.almoxarife.empity.ItemEntradaSaida;
import senai.almoxarife.empity.Material;
import senai.almoxarife.empity.Setor;
import senai.almoxarife.empity.Solicitacao;
import senai.almoxarife.empity.SolicitacaoMaterial;
import senai.almoxarife.empity.Usuario;
import senai.almoxarife.view.LoginView;
import senai.almoxarife.view.TelaInicioForm;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		EntityManager manager = senai.almoxarife.dao.HibernateManager.getManager();
		
		manager.getTransaction().begin();
		
		Almoxarifado almoxarifado = new Almoxarifado();
		almoxarifado.setNome("Almoxarifado Eletrica");
		
		manager.persist(almoxarifado);
		
		Material material = new Material();
		material.setNome("Fios");
		material.setUnidade("metro");
		material.setEstoqueMin(5);
		material.setEstoqueMax(10);
		material.setDescricao("alta tens�o");
		manager.persist(material);
		
		Setor setor = new Setor();
		setor.setNome("Eletrica");
		//Collection<Almoxarifado> lista = new ArrayList<Almoxarifado>();
		//lista.add(almoxarifado);
		setor.setAlmoxerifados(almoxarifado);
		manager.persist(setor);
		
		Usuario user = new Usuario();
		user.setNome("Clesyo Moreira da Silva");
		user.setMatricula(123923);
		user.setTelefone("(99)9283-2323");
		user.setNivel(1);
		user.setEmail("clesyo@email.com");
		user.setSenha("123456");
		user.getSetores().add(setor);
		manager.persist(user);
		
		
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setAlmoxarifados(almoxarifado);
		solicitacao.setStatusSol("Atendido");
		solicitacao.setUsuario(user);
		solicitacao.setDataSoli(Calendar.getInstance());
		manager.persist(solicitacao);
		
		SolicitacaoMaterial solMaterial = new SolicitacaoMaterial();
		solMaterial.setQuantidade(1);
		solMaterial.setSolicitacao(solicitacao);
		solMaterial.setMateriais(material);
		manager.merge(solMaterial);
		
		ItemEntradaSaida itemInOut = new ItemEntradaSaida();
		itemInOut.setMaterial(material);
		itemInOut.setQuantidade(1);
		manager.persist(itemInOut);
		
		
		EntradaSaida inOut = new EntradaSaida();
		inOut.setAlmoxarifado(almoxarifado);
		inOut.setDataInOu(Calendar.getInstance());
		inOut.setResponsavel(user);
		inOut.setTipo(false);
		inOut.setItens(itemInOut);
		manager.merge(inOut);
		
		manager.getTransaction().commit();
		
		manager.close();
		*/
		
		new LoginView().setVisible(true);
	}

}
