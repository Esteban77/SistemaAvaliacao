package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.TipoDeBeneficio;
import entidade.TipoDeBeneficio;

public class TipoDeBeneficioDaoImpl extends BaseDaoImpl<TipoDeBeneficio, Long> implements TipoDeBeneficioDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public TipoDeBeneficio pesquisaPorId(Long id, Session session) throws HibernateException {
		TipoDeBeneficio tipoDeBeneficio = (TipoDeBeneficio) session.get(TipoDeBeneficio.class, id);
		return tipoDeBeneficio;
	}

	@Override
	public List<TipoDeBeneficio> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from TipoDeBeneficio");
		return consulta.list();
	}

	@Override
	public List<TipoDeBeneficio> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("form TipoDeBeneficio r where r.nome like :nome");
		consulta.setParameter("nome", "%" + filtro + "%");
		return consulta.list();
	}

	@Override
	public List<TipoDeBeneficio> pesquisaPorEmpresa(Long idEmpresa, Session session) {
		Query consulta = session.createQuery("from TipoDeBeneficio tb where tb.empresa.id= :id");
		consulta.setParameter("id", idEmpresa);
		return consulta.list();
	}

}
