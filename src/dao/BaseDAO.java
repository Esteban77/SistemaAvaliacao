package dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDAO<T, ID> {
	
	//Transacoes
	void salvarOuAlterar(T entidade, Session session) throws HibernateException;

	void excluir(T entidade, Session session) throws HibernateException;
	
	//Solicitacoes
	T pesquisaPorId(ID id, Session session) throws HibernateException;	

	List<T> listaTodos(Session session) throws HibernateException;
	
	List<T> pesquisaPorFiltro(String filtro, Session session) throws HibernateException;
}
