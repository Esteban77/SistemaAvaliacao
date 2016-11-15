package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.TipoDeFormulario;

public class TipoDeFormularioDaoImpl extends BaseDaoImpl<TipoDeFormulario, Long> implements TipoDeFormularioDao,Serializable{


	private static final long serialVersionUID = 1L;

	@Override
	public TipoDeFormulario pesquisaPorId(Long id, Session session) throws HibernateException {
		TipoDeFormulario formulario = (TipoDeFormulario) session.get(TipoDeFormulario.class, id);
		
		return formulario;
	}

	@Override
	public List<TipoDeFormulario> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from TipoDeFormulario");
		return consulta.list();
	}

	@Override
	public List<TipoDeFormulario> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("form TipoDeFormulario r where r.nome like :nome");
		consulta.setParameter("nome", "%" + filtro + "%");
		return consulta.list();
	}

	@Override
	public List<TipoDeFormulario> pesquisaPorEmpresa(Long idEmpresa, Session session) {
		Query consulta = session.createQuery("from TipoDeFormulario tf where tf.empresa.id= :id");
		consulta.setParameter("id", idEmpresa);
		return consulta.list();
	}

}
