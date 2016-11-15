package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDeFormulario> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
