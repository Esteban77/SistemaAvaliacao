package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.CupomBeneficio;

public class CupomBeneficioDaoImpl extends BaseDaoImpl<CupomBeneficio, Long> implements CupomBeneficioDao, Serializable{

	@Override
	public CupomBeneficio pesquisaPorId(Long id, Session session) throws HibernateException {
		CupomBeneficio cupomBeneficio = (CupomBeneficio) session.get(CupomBeneficio.class, id);
		return cupomBeneficio;
	}

	@Override
	public List<CupomBeneficio> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from CupomBeneficio");
		return consulta.list();
	}

	@Override
	public List<CupomBeneficio> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("form CupomBeneficio c where c.nome like :nome");
		consulta.setParameter("nome", "%" + filtro + "%");
		return consulta.list();
	}

}
