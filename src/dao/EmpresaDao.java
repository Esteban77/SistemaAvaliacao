package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.Empresa;

public interface EmpresaDao extends BaseDAO<Empresa, Long> {
	public Empresa buscarEmpresa(String login, String senha, Session session) throws HibernateException;
}
