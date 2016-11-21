package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.RespostaFormulario;
import entidade.TipoDeFormulario;

public class RespostaFormularioDaoImpl extends BaseDaoImpl<RespostaFormulario, Long> implements RespostaFormularioDao, Serializable{

	@Override
	public RespostaFormulario pesquisaPorId(Long id, Session session) throws HibernateException {
		RespostaFormulario respostaFormulario = (RespostaFormulario) session.get(RespostaFormulario.class, id);
		return respostaFormulario;
	}

	@Override
	public List<RespostaFormulario> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from RespostaFormulario");
		return consulta.list();
	}

	@Override
	public List<RespostaFormulario> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("from RespostaFormulario r where r.nome like :nome");
		consulta.setParameter("nome", "%" + filtro + "%");
		return consulta.list();
	}

	@Override
	public RespostaFormulario pesquisaPorRespostaFormulario(Long id, Session session) throws HibernateException {
		Query consulta = session.createQuery("from RespostaFormulario rf join fetch rf.respostas where rf.id=:id");
		consulta.setParameter("id",id);
		return (RespostaFormulario) consulta.uniqueResult();
	}

}
