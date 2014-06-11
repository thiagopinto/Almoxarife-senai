package senai.almoxarife;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import senai.almoxarife.empity.Almoxarifado;
import senai.almoxarife.empity.EntradaSaida;
import senai.almoxarife.empity.ItemEntradaSaida;
import senai.almoxarife.empity.Material;
import senai.almoxarife.empity.Setor;
import senai.almoxarife.empity.Solicitacao;
import senai.almoxarife.empity.SolicitacaoMaterial;
import senai.almoxarife.empity.Usuario;
import senai.almoxarife.view.TelaInicioForm;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("System_Almoxarifado");
		EntityManager manager = factory.createEntityManager();
		
		
		manager.getTransaction().begin();
		
		Almoxarifado almoxarifado = new Almoxarifado();
		almoxarifado.setNome("Almoxarifado Informática");
		
		manager.persist(almoxarifado);
		
/*		Material material = new Material();
		material.setNome("Pincel");
		material.setUnidade("Caixa");
		material.setEstoqueMin(5);
		material.setEstoqueMax(10);
		material.setDescricao("Quandro Branco");
		manager.persist(material);*/
		
		Setor setor = new Setor();
		setor.setNome("ti");
		//Collection<Almoxarifado> lista = new ArrayList<Almoxarifado>();
		//lista.add(almoxarifado);
		setor.setAlmoxerifados(almoxarifado);
		manager.persist(setor);
		
/*		Usuario user = new Usuario();
		user.setNome("Clesyo Moreira da Silva");
		user.setMatricula(123923);
		user.setTelefone("(99)9283-2323");
		user.setNivel(1);
		user.setEmail("clesyo@email.com");
		user.setSenha("123456");
		user.getSetores().add(setor);
		manager.persist(user);*/
		
		
		/*Solicitacao solicitacao = new Solicitacao();
		solicitacao.setAlmoxarifados(almoxarifado);
		solicitacao.setStatusSol("Atendido");
		solicitacao.setUsuario(user);
		solicitacao.setDataSoli(Calendar.getInstance());
		manager.persist(solicitacao);
		
		SolicitacaoMaterial solMaterial = new SolicitacaoMaterial();
		solMaterial.setQuantidade(1);
		solMaterial.setSolicitacao(solicitacao);
		solMaterial.setMateriais(material);
		manager.persist(solMaterial);
		
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
		manager.persist(inOut);*/
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
