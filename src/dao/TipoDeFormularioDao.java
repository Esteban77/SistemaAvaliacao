package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.TipoDeFormulario;

public interface TipoDeFormularioDao extends BaseDAO<TipoDeFormulario, Long>{
	public List<TipoDeFormulario> pesquisaPorEmpresa(Long idEmpresa, Session session);
	public TipoDeFormulario pesquisaPorFormulario(Long id, Session session) throws HibernateException;
}