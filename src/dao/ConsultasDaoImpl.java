package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
	public List<Object[]> resultadoPorEmpresa(Long idEmpresa, Session session) throws HibernateException {
		Query consulta = session.createQuery("select count(*), r.opcao from Resposta r join r.respostaFormulario rF join rF.tipoDeFormulario tf where tf.empresa.id= :id group by r.opcao order by r.opcao");
		consulta.setParameter("id", idEmpresa);
		return consulta.list();
	}

}
