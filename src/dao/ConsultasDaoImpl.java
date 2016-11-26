package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Consumidor;
import negocio.Consultas;

public class ConsultasDaoImpl extends BaseDaoImpl<Consultas, Long> implements ConsultasDao, Serializable{

	@Override
	public Consultas pesquisaPorId(Long id, Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consultas> listaTodos(Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consultas> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
/*		String query = " SELECT f.nome , f. departamento . nome FROM Funcionario f";
		Query query = manager.createQuery ( query );
		List < Object []> lista = query . getResultList ();*/
		return null;
	}

	@Override
	public List<Object[]> resultadoPorEmpresa(Long idEmpresa,  Date dataIni, Date dataFinal,Session session) throws HibernateException {
		Query consulta = session.createQuery("select count(*), r.opcao from Resposta r join r.respostaFormulario rF join rF.tipoDeFormulario tf where (rF.data between :dataI and :dataF) and tf.empresa.id= :id group by r.opcao order by r.opcao");
		consulta.setParameter("id", idEmpresa);
		consulta.setParameter("dataI", dataIni);
		consulta.setParameter("dataF", dataFinal);
		return consulta.list();
	}

	@Override
	public List<Object[]> resultadoPorFormulario(Long idFormulario, Date dataIni, Date dataFinal, Session session)
			throws HibernateException {
		Query consulta = session.createQuery("select count(*), r.opcao from Resposta r join r.respostaFormulario rF where (rF.data between :dataI and :dataF) and rF.tipoDeFormulario.id= :id group by r.opcao order by r.opcao");
		consulta.setParameter("id", idFormulario);
		consulta.setParameter("dataI", dataIni);
		consulta.setParameter("dataF", dataFinal);
		return consulta.list();
	}

	@Override
	public List<Object[]> resultadoPorFormularioPergunta(Long idFormulario, Long idPergunta, Date dataIni,
			Date dataFinal, Session session) throws HibernateException {
		Query consulta = session.createQuery("select count(*), r.opcao from Resposta r join r.respostaFormulario rF where (rF.data between :dataI and :dataF) and rF.tipoDeFormulario.id= :idF and r.pergunta.id= :idP group by r.opcao order by r.opcao");
		consulta.setParameter("idF", idFormulario);
		consulta.setParameter("idP", idPergunta);
		consulta.setParameter("dataI", dataIni);
		consulta.setParameter("dataF", dataFinal);
		return consulta.list();
	}

	@Override
	public List<Object[]> resultadoGraficoBarras(Long idEmpresa, Integer ano, Session session)
			throws HibernateException {
//		Query consulta = session.createSQLQuery("select count(*), r.opcao, month(rF.data) as mes, year(rF.data) as ano from Resposta r join r.respostaFormulario rF join rF.tipoDeFormulario tf where tf.empresa.id= :id group by mes, ano, r.opcao having ano= :ano");
		Query consulta = session.createSQLQuery("select count(*),r.opcao, month(rF.data) as mes, year(rF.data) as ano from resposta r inner join respostaFormulario rF on  (r.idrespostaformulario=rF.id) inner join tipodeformulario on rF.idtipodeformulario=tipodeformulario.id where tipodeformulario.idempresa= :id group by mes,ano,r.opcao having ano = :ano");
		consulta.setParameter("id", idEmpresa);
		consulta.setParameter("ano", ano);
		return consulta.list();
	}


}
