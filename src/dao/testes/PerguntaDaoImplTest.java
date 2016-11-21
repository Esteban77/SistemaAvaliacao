package dao.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import dao.HibernateUtil;
import dao.PerguntaDaoImpl;
import entidade.Opcao;
import entidade.Pergunta;
import entidade.TipoDeFormulario;
import util.GeradorLetrasNumeros;

public class PerguntaDaoImplTest {
	
	private Session session;
	private Pergunta pergunta;
	private PerguntaDaoImpl perguntaDao;
	private TipoDeFormulario tipoDeFormulario;
	
	public PerguntaDaoImplTest() {
		perguntaDao = new PerguntaDaoImpl();
		
	}

//	@Test
	public void testPesquisaPorId() {
		System.out.println("teste pesquisar por id");
		session = HibernateUtil.getSession();
		pergunta = new Pergunta();
		pergunta = getPergunta();
		Pergunta perguntapesquisada = new Pergunta();
		perguntapesquisada = perguntaDao.pesquisaPorId(pergunta.getId(), session); 
		assertNotNull(perguntapesquisada);
		session.close();
	}

//	@Test
	public void testListaTodos() {
		System.out.println("listar todos...");
		session = HibernateUtil.getSession();
		List<Pergunta> listPerguntas = perguntaDao.listaTodos(session);
		assertFalse(listPerguntas.isEmpty());
		session.close();
	}

//	@Test
	public void testPesquisaPorIdFormulario() {
		System.out.println("teste Pequisar por id formulario");
		session = HibernateUtil.getSession();
		TipoDeFormularioDaoImplTest tipoFormularioTeste = new TipoDeFormularioDaoImplTest();
		tipoDeFormulario = tipoFormularioTeste.getTipoDeFormulario();
		List<Pergunta> listPerguntas = perguntaDao.pesquisaPorIdFormulario(tipoDeFormulario.getId(), session);
		assertFalse(listPerguntas.isEmpty());
		session.close();
	}
	
	@Test
	public void testPesquisaPorIdEmpresa() {
		System.out.println("teste Pequisar por id empresa");
		session = HibernateUtil.getSession();
		TipoDeFormularioDaoImplTest tipoFormularioTeste = new TipoDeFormularioDaoImplTest();
		tipoDeFormulario = tipoFormularioTeste.getTipoDeFormulario();
		List<Pergunta> listPerguntas = perguntaDao.pesquisaPorIdEmpresa(tipoDeFormulario.getEmpresa().getId(), session);
		assertFalse(listPerguntas.isEmpty());
		session.close();
	}

//	@Test
	public void testPesquisaPorFiltro() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSalvar() {
		System.out.println("teste salvar");
		session = HibernateUtil.getSession();
		TipoDeFormularioDaoImplTest tipoFormularioTeste = new TipoDeFormularioDaoImplTest();
		tipoDeFormulario = tipoFormularioTeste.getTipoDeFormulario();
		pergunta = new Pergunta(null,Opcao.OTIMO,GeradorLetrasNumeros.geradorLetrasNumeros(10),tipoDeFormulario);
		perguntaDao.salvarOuAlterar(pergunta, session);
		assertNotNull(pergunta.getId());
		session.close();
	}
	
//	@Test
	public void testAlterar() {
		System.out.println("teste Alterar...");
		session = HibernateUtil.getSession();
		getPergunta();
		pergunta.setNomePergunta(GeradorLetrasNumeros.geradorLetrasNumeros(3)+" alterado");
		Pergunta perguntaAlterada = perguntaDao.pesquisaPorId(pergunta.getId(), session);
		assertEquals(pergunta.getNomePergunta(),perguntaAlterada.getNomePergunta());
		session.close();
	}

//	@Test
	public void testExcluir() {
		System.out.println("teste excluir...");
		session = HibernateUtil.getSession();
		pergunta = new Pergunta();
		pergunta = getPergunta();
		perguntaDao.excluir(pergunta, session);
		Pergunta perguntaExcluida = perguntaDao.pesquisaPorId(pergunta.getId(), session);
		assertNull(perguntaExcluida);
		session.close();
	}

	public Pergunta getPergunta(){
		session = HibernateUtil.getSession();
		Long id;
		Query consulta = session.createQuery("Select max(p.id) from Pergunta p");
		id = (Long) consulta.uniqueResult();
		if(id == null){
			testSalvar();
		}else{
			perguntaDao = new PerguntaDaoImpl();
			pergunta = perguntaDao.pesquisaPorId(id, session);
			session.close();
		}
		
		return pergunta;		
	}
}
