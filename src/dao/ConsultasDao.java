package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import negocio.Consultas;

public interface ConsultasDao extends BaseDAO<Consultas,Long>{
	public List<Object[]> resultadoPorEmpresa(Long idEmpresa, Session session) throws HibernateException;
}
