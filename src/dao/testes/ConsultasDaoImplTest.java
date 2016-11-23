package dao.testes;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import dao.ConsultasDao;
import dao.ConsultasDaoImpl;
import dao.HibernateUtil;
import entidade.Opcao;

public class ConsultasDaoImplTest {

	private Session session;
	private ConsultasDao consultaDao;
	
	@Test
	public final void testResultadoPorEmpresa() {
		System.out.println("resultado por Empresa...");
		session = HibernateUtil.getSession();
		consultaDao = new ConsultasDaoImpl();
		List<Object[]> resultPorEmpresa = consultaDao.resultadoPorEmpresa(10L, session);
		for(Object[] obj : resultPorEmpresa){
			Long qtd = (Long) obj[0];
			Opcao opcao =  (Opcao) obj[1];
			String op = opcao.name();
			int i =0;
		}
		assertFalse(resultPorEmpresa.isEmpty());
		session.close();
	}

}
