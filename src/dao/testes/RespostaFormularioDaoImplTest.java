package dao.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import dao.HibernateUtil;
import dao.RespostaFormularioDaoImpl;
import entidade.Opcao;
import entidade.Resposta;
import entidade.RespostaFormulario;

public class RespostaFormularioDaoImplTest {

	private RespostaFormulario respostaFormulario;
	private RespostaFormularioDaoImpl respostaFormularioDao;
	private Session session;
	
//	@Test
	public void testPesquisaPorId() {
		System.out.println("teste pesquisar por id");
		session = HibernateUtil.getSession();
		respostaFormulario = new RespostaFormulario();
		respostaFormulario = getRespostaFormulario();
		RespostaFormulario respostaPesquisada = new RespostaFormulario();
		respostaPesquisada = respostaFormularioDao.pesquisaPorId(respostaFormulario.getId(), session); 
		assertNotNull(respostaPesquisada);
		session.close();
	}

//	@Test
	public void testListaTodos() {
		System.out.println("listar todos...");
		session = HibernateUtil.getSession();
		List<RespostaFormulario> list = respostaFormularioDao.listaTodos(session);
		assertFalse(list.isEmpty());
		session.close();
	}

//	@Test
	public void testPesquisaPorFiltro() {
		System.out.println("teste Pequisar por id formulario");
		session = HibernateUtil.getSession();
		respostaFormulario = getRespostaFormulario();
		List<RespostaFormulario> respostaPesquisada = respostaFormularioDao.pesquisaPorFiltro(respostaFormulario.getComentario(), session);
		assertNotNull(respostaPesquisada);
		session.close();
	}

//	@Test
	public void testPesquisaPorRespostaFormulario() {
		System.out.println("teste Pequisar por id formulario");
		session = HibernateUtil.getSession();
		respostaFormulario = getRespostaFormulario();
		RespostaFormulario respostaPesquisada = respostaFormularioDao.pesquisaPorRespostaFormulario(respostaFormulario.getId(), session);
		assertNotNull(respostaPesquisada);
		session.close();
	}
	

//	@Test
	public void testSalvar() {
		System.out.println("Teste salvar");
		session = HibernateUtil.getSession();
		PerguntaDaoImplTest pergunta = new PerguntaDaoImplTest();
		TipoDeFormularioDaoImplTest tipoDeFormulario = new TipoDeFormularioDaoImplTest();
		ConsumidorDaoImplTest consumidor = new ConsumidorDaoImplTest();
		Resposta resposta1 = new Resposta(null, Opcao.BOM, pergunta.getPergunta(), respostaFormulario);
//		Resposta resposta2 = new Resposta(null, Opcao.BOM, pergunta.getPergunta(), respostaFormulario);
		List<Resposta> respostas = new ArrayList<>();
		respostas.add(resposta1);
//		respostas.add(resposta2);
		respostaFormulario = new RespostaFormulario(null, respostas, null , "bal bal bal", tipoDeFormulario.getTipoDeFormulario(), 25, true, consumidor.getConsumidor());
		respostaFormularioDao = new RespostaFormularioDaoImpl();
		respostaFormularioDao.salvarOuAlterar(respostaFormulario, session);
		assertNotNull(respostaFormulario.getId());
		session.close();
	}
	
	@Test
	public void testAlterar() {
		
	}

//	@Test
	public void testExcluir() {
		System.out.println("teste excluir...");
		session = HibernateUtil.getSession();
		respostaFormulario = new RespostaFormulario();
		respostaFormulario = getRespostaFormulario();
		respostaFormularioDao.excluir(respostaFormulario, session);
		RespostaFormulario respostaExcluida = respostaFormularioDao.pesquisaPorId(respostaFormulario.getId(), session);
		assertNull(respostaExcluida);
		session.close();
	}
	
	public RespostaFormulario getRespostaFormulario(){
		session = HibernateUtil.getSession();
		Long id;
		Query consulta = session.createQuery("Select max(r.id) from RespostaFormulario r");
		id = (Long) consulta.uniqueResult();
		if(id == null){
			testSalvar();
		}else{
			respostaFormularioDao = new RespostaFormularioDaoImpl();
			respostaFormulario = respostaFormularioDao.pesquisaPorId(id, session);
			session.close();
		}
		
		return respostaFormulario;		
	}

}
