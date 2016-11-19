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

import dao.ConsumidorDao;
import dao.ConsumidorDaoImpl;
import dao.HibernateUtil;
import entidade.Consumidor;
import entidade.Empresa;
import util.GeradorLetrasNumeros;

public class ConsumidorDaoImplTest {
	
	private Consumidor consumidor;
	private ConsumidorDao consumidorDao;
	private Session session;

	@Test
	public final void testPesquisaPorId() {
		System.out.println("pesquisarPorId");
		getConsumidor();
		session = HibernateUtil.getSession();
		Consumidor consumidorId = consumidorDao.pesquisaPorId(consumidor.getId(), session);
		assertNotNull(consumidorId);
		session.close();
	}

	@Test
	public final void testListaTodos() {
		System.out.println("listar todos...");
		getConsumidor();
		session = HibernateUtil.getSession();
		List<Consumidor> consumidor = consumidorDao.listaTodos(session);
		assertFalse(consumidor.isEmpty());
		session.close();
	}

	@Test
	public final void testPesquisaPorFiltro() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSalvar() {
		System.out.println("Salva consumidor...");
		consumidor = new Consumidor(null, GeradorLetrasNumeros.geradorLetrasNumeros(5), "48-93473645",GeradorLetrasNumeros.geradorLetrasNumeros(5),
				"12345", "consumidor@gmail.com", "345.344.213.123");
		session = HibernateUtil.getSession();
		consumidorDao = new ConsumidorDaoImpl();
		try{
			consumidorDao.salvarOuAlterar(consumidor, session); 
		}catch(Exception e){
			System.out.println("erro salvar" + e.getMessage());
		}
		assertNotNull(consumidor.getId());
		session.close();
	}
	
	@Test
	public final void testAlterar() {
		System.out.println("teste alterar...");
		getConsumidor();
		consumidor.setCpf("novoCPF"); 
		session = HibernateUtil.getSession();
		consumidorDao.salvarOuAlterar(consumidor, session);
		
		Consumidor consumidorAlterado = consumidorDao.pesquisaPorId(consumidor.getId(), session);
		assertEquals(consumidor.getNome(), consumidorAlterado.getNome());
		assertEquals(consumidorAlterado.getCpf(),consumidor.getCpf());
		session.close();
	}

	@Test
	public final void testExcluir() {
		System.out.println("Alterar excluir...");
		session = HibernateUtil.getSession();
		getConsumidor();
		consumidorDao.excluir(consumidor, session);
		Consumidor consumidorExcluido = consumidorDao.pesquisaPorId(consumidor.getId(), session);
		assertNull(consumidorExcluido);
		session.close();
	}
	
	public Consumidor getConsumidor(){
		session = HibernateUtil.getSession();
		Long id;
		Query consulta = session.createQuery("Select max(c.id) from Consumidor c");
		id = (Long) consulta.uniqueResult();
		if(id == null){
			testSalvar();
		}else{
			consumidorDao = new ConsumidorDaoImpl();
			consumidor = consumidorDao.pesquisaPorId(id, session);
		}
		session.close();
		return consumidor;		
	}

}
