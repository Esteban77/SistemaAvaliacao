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

import dao.EmpresaDao;
import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import entidade.Empresa;
import util.GeradorLetrasNumeros;

public class EmpresaDaoImplTest {
	
	private Empresa empresa;
	private EmpresaDao empresaDao;
	private Session session;

	@Test
	public final void testPesquisaPorId() {
		System.out.println("pesquisarPorId");
		getEmpresa();
		session = HibernateUtil.getSession();
		Empresa empresaId = empresaDao.pesquisaPorId(empresa.getId(), session);
		assertNotNull(empresaId);
		session.close();
	}

	@Test
	public final void testListaTodos() {
		System.out.println("listar todos...");
		getEmpresa();
		session = HibernateUtil.getSession();
		List<Empresa> empresas = empresaDao.listaTodos(session);
		assertFalse(empresas.isEmpty());
		session.close();
	}

	@Test
	public final void testPesquisaPorFiltro() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testBuscarEmpresa() {
		System.out.println("buscar empresa...");
		getEmpresa();
		session = HibernateUtil.getSession();
		String login = empresa.getLogin();
		String senha = empresa.getSenha();
		Empresa empresaBuscada = empresaDao.buscarEmpresa(login, senha, session);
		assertNotNull(empresaBuscada);
		session.close();		
	}

	@Test
	public final void testSalvar() {
		System.out.println("Salva empresa...");
		empresa = new Empresa(null, GeradorLetrasNumeros.geradorLetrasNumeros(5), "48-93473645",GeradorLetrasNumeros.geradorLetrasNumeros(5),
				"12345", "345.344.213.123");
		session = HibernateUtil.getSession();
		empresaDao = new EmpresaDaoImpl();
		try{
			empresaDao.salvarOuAlterar(empresa, session); 
		}catch(Exception e){
			System.out.println("erro salvar" + e.getMessage());
		}
		assertNotNull(empresa.getId());
		session.close();
	}
	
	@Test
	public final void testAlterar() {
		System.out.println("teste alterar...");
		getEmpresa();
		empresa.setCnpj("novoCNPJ"); 
		session = HibernateUtil.getSession();
		empresaDao.salvarOuAlterar(empresa, session);
		
		Empresa empresaAlterado = empresaDao.pesquisaPorId(empresa.getId(), session);
		assertEquals(empresa.getNome(), empresaAlterado.getNome());
		assertEquals(empresaAlterado.getCnpj(), empresa.getCnpj());
		session.close();
	}

	@Test
	public final void testExcluir() {
		System.out.println("Alterar excluir...");
		session = HibernateUtil.getSession();
		getEmpresa();
		empresaDao.excluir(empresa, session);
		Empresa empresaExcluido = empresaDao.pesquisaPorId(empresa.getId(), session);
		assertNull(empresaExcluido);
		session.close();
	}
	
	public Empresa getEmpresa(){
		session = HibernateUtil.getSession();
		Long id;
		Query consulta = session.createQuery("Select max(e.id) from Empresa e");
		id = (Long) consulta.uniqueResult();
		if(id == null){
			testSalvar();
		}else{
			empresaDao = new EmpresaDaoImpl();
			empresa = empresaDao.pesquisaPorId(id, session);
		}
		session.close();
		return empresa;		
	}

}
