package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.TipoDeBeneficio;

public interface TipoDeBeneficioDao extends BaseDAO<TipoDeBeneficio, Long> {
	public List<TipoDeBeneficio> pesquisaPorEmpresa(Long idEmpresa, Session session);
}
