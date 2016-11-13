package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Empresa;

public class EmpresaDaoImpl extends BaseDaoImpl<Empresa, Long> implements EmpresaDao, Serializable{

	@Override
	public Empresa pesquisaPorId(Long id, Session session) throws HibernateException {
		Empresa empresa = (Empresa) session.get(Empresa.class, id);
		return empresa;
	}

	@Override
	public List<Empresa> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from empresa");
		return consulta.list();
	}

	@Override
	public List<Empresa> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("from empresa e where e.nome like :nome");
		consulta.setParameter("nome", "%"+filtro+"%");
		return consulta.list();
	}

	public Empresa buscarEmpresa(String login, String senha, Session session) throws HibernateException {
		
		Query consulta = session.createQuery("from pessoa e where e.login like "+login+" and e.senha like "+senha);

		Empresa empresa = (Empresa) consulta.uniqueResult();
		return empresa;
	}
}
