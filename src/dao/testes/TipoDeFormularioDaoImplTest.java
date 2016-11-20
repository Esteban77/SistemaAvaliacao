package dao.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import dao.HibernateUtil;
import dao.TipoDeFormularioDao;
import dao.TipoDeFormularioDaoImpl;
import entidade.Empresa;
import entidade.Opcao;
import entidade.Pergunta;
import entidade.TipoDeFormulario;
import util.GeradorLetrasNumeros;

public class TipoDeFormularioDaoImplTest {

	private Session session;
	private TipoDeFormulario tipoDeFormulario;
	private TipoDeFormularioDao tipoDeFormularioDao;
	private Empresa empresa;
	
	@Test
	public final void testPesquisaPorId() {
		System.out.println("teste pesquisar por id");
		session = HibernateUtil.getSession();
		tipoDeFormularioDao = new TipoDeFormularioDaoImpl();
		tipoDeFormulario = tipoDeFormularioDao.pesquisaPorId(3L, session);
		assertNotNull(tipoDeFormulario);	
		session.close();
	}
	
	@Test
	public final void testPesquisaPorFormulario() {
		System.out.println("teste pesquisar por formulario");
		session = HibernateUtil.getSession();
		tipoDeFormularioDao = new TipoDeFormularioDaoImpl();
		tipoDeFormulario = tipoDeFormularioDao.pesquisaPorFormulario(3L, session);
		assertNotNull(tipoDeFormulario);	
		session.close();
	}

	@Test
	public final void testListaTodos() {
		System.out.println("listar todos...");
		session = HibernateUtil.getSession();
		List<TipoDeFormulario> listTipoDeFormulario = tipoDeFormularioDao.listaTodos(session);
		assertFalse(listTipoDeFormulario.isEmpty());
		session.close();
	}

	@Test
	public final void testPesquisaPorFiltro() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPesquisaPorEmpresa() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSalvar() {
		System.out.println("teste salvar...");
		EmpresaDaoImplTest empresaDaoImpl = new EmpresaDaoImplTest();
		Empresa empresa = empresaDaoImpl.getEmpresa();
		Pergunta pergunta1 = new Pergunta(null, Opcao.BOM, GeradorLetrasNumeros.geradorLetrasNumeros(10)+"?", tipoDeFormulario);
		Pergunta pergunta2 = new Pergunta(null, Opcao.RUIM, GeradorLetrasNumeros.geradorLetrasNumeros(10)+"?", tipoDeFormulario);
		List<Pergunta> perguntas = new ArrayList<>();
		perguntas.add(pergunta1);
		perguntas.add(pergunta2);
		tipoDeFormulario = new TipoDeFormulario(null,"nomeFormulario ", perguntas, empresa);	
		session = HibernateUtil.getSession();
		tipoDeFormularioDao.salvarOuAlterar(tipoDeFormulario, session);
		assertNotNull(tipoDeFormulario.getId());
		session.close();
	}
	@Test
	public final void testAlterar() {
		
	}

	@Test
	public final void testExcluir() {
		System.out.println("Alterar excluir...");
		session = HibernateUtil.getSession();
		getTipoDeFormulario();
		tipoDeFormularioDao.excluir(tipoDeFormulario, session);
		TipoDeFormulario tipoDeFormularioExcluido = tipoDeFormularioDao.pesquisaPorId(tipoDeFormulario.getId(), session);
		assertNull(tipoDeFormularioExcluido);
		session.close();
	}
	
	public TipoDeFormulario getTipoDeFormulario(){
		session = HibernateUtil.getSession();
		Long id;
		Query consulta = session.createQuery("Select max(f.id) from TipoDeFormulario f");
		id =  (Long) consulta.uniqueResult();
		if(id == null){
			testSalvar();
		}else{
			tipoDeFormularioDao = new TipoDeFormularioDaoImpl();
			tipoDeFormulario = tipoDeFormularioDao.pesquisaPorId(id, session);
			session.close();
		}
		
		return tipoDeFormulario;		
	}
	
}
