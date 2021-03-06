package dao.testes;

import static org.junit.Assert.assertFalse;

import java.math.BigInteger;
import java.util.Date;
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
	
//	@Test
	public final void testResultadoPorEmpresa() {
		System.out.println("resultado por Empresa...");
		session = HibernateUtil.getSession();
		consultaDao = new ConsultasDaoImpl();
		String dataInicial = "2016-11-03";
	    String dataFinal = "2016-11-23";	      
	    Date dataIni = java.sql.Date.valueOf(dataInicial);
	    Date dataFin = java.sql.Date.valueOf(dataFinal);
		List<Object[]> resultPorEmpresa = consultaDao.resultadoPorEmpresa(10L,dataIni,dataFin, session);
		for(Object[] obj : resultPorEmpresa){
			Long qtd = (Long) obj[0];
			Opcao opcao =  (Opcao) obj[1];
			String op = opcao.name();
			int i =0;
		}
		assertFalse(resultPorEmpresa.isEmpty());
		session.close();
	}
	
//	@Test
	public final void testResultadoPorFormulario() {
		System.out.println("resultado por Empresa...");
		session = HibernateUtil.getSession();
		consultaDao = new ConsultasDaoImpl();
		String dataInicial = "2016-11-03";
	    String dataFinal = "2016-11-23";	      
	    Date dataIni = java.sql.Date.valueOf(dataInicial);
	    Date dataFin = java.sql.Date.valueOf(dataFinal);
		List<Object[]> resultPorEmpresa = consultaDao.resultadoPorFormulario(3L,dataIni,dataFin, session);
		for(Object[] obj : resultPorEmpresa){
			Long qtd = (Long) obj[0];
			Opcao opcao =  (Opcao) obj[1];
			String op = opcao.name();
			int i =0;
		}
		assertFalse(resultPorEmpresa.isEmpty());
		session.close();
	}
	
//	@Test
	public final void testResultadoPorFormularioPergunta() {
		System.out.println("resultado por Empresa...");
		session = HibernateUtil.getSession();
		consultaDao = new ConsultasDaoImpl();
		String dataInicial = "2016-11-03";
	    String dataFinal = "2016-11-23";	      
	    Date dataIni = java.sql.Date.valueOf(dataInicial);
	    Date dataFin = java.sql.Date.valueOf(dataFinal);
		List<Object[]> resultPorEmpresa = consultaDao.resultadoPorFormularioPergunta(3L,5L,dataIni,dataFin, session);
		for(Object[] obj : resultPorEmpresa){
			Long qtd = (Long) obj[0];
			Opcao opcao =  (Opcao) obj[1];
			String op = opcao.name();
			int i =0;
		}
		assertFalse(resultPorEmpresa.isEmpty());
		session.close();
	}
	
	@Test
	public final void testResultadoGraficoBarras() {
		System.out.println("resultado para grafico barras...");
		session = HibernateUtil.getSession();
		consultaDao = new ConsultasDaoImpl();
		Integer ano = 2016;
		Long idEmpresa = 1L;
		List<Object[]> resultPorEmpresa = consultaDao.resultadoGraficoBarras(idEmpresa,ano, session);
		for(Object[] obj : resultPorEmpresa){
			BigInteger qtd = (BigInteger) obj[0];
			Integer qtdInt = qtd.intValue();
			String opcao =  (String) obj[1];
			Integer mes = (Integer) obj[2];
			Integer ano1 = (Integer) obj[3];
			int i =0;
		}
		assertFalse(resultPorEmpresa.isEmpty());
		session.close();
	}

}
