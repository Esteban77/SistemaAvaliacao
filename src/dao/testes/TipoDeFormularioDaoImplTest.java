package dao.testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.junit.Test;

import dao.HibernateUtil;
import dao.TipoDeFormularioDao;
import dao.TipoDeFormularioDaoImpl;
import entidade.TipoDeFormulario;

public class TipoDeFormularioDaoImplTest {

	private Session session;
	private TipoDeFormulario tipoDeFormulario;
	private TipoDeFormularioDao tipoDeFormularioDao;
	
//	@Test
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

//	@Test
	public final void testListaTodos() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	public final void testPesquisaPorFiltro() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	public final void testPesquisaPorEmpresa() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	public final void testSalvarOuAlterar() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	public final void testExcluir() {
		fail("Not yet implemented"); // TODO
	}
	
/*	public TipoDeFormulario getTipoDeFormulario(){
		session = HibernateUtil.getSession();
		Long id;
		Query consulta = session.createQuery("Select max(f.id) from TipoDeFormulario f");
		id = (Long) consulta.uniqueResult();
		if(id == null){
			testSalvar();
		}else{
			tipoDeFormularioDao = new TipoDeFormularioDaoImpl();
			tipoDeFormulario = tipoDeFormularioDao.pesquisaPorId(id, session);
		}
		session.close();
		return tipoDeFormulario;		
	}*/

}
