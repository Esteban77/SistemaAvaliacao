package dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDaoImpl<T, ID> implements BaseDAO<T, ID>{

	private Transaction transaction;
	
	@Override
	public void salvarOuAlterar(T entidade, Session session) throws HibernateException {
		transaction = session.beginTransaction();
		session.saveOrUpdate(entidade);
		transaction.commit();	
	}

	@Override
	public void excluir(T entidade, Session session) throws HibernateException {
		transaction = session.beginTransaction();
		session.delete(entidade);
		transaction.commit();		
	}	
}
