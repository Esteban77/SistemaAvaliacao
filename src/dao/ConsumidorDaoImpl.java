package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Consumidor;

public class ConsumidorDaoImpl extends BaseDaoImpl<Consumidor, Long> implements ConsumidorDao, Serializable{

	@Override
	public Consumidor pesquisaPorId(Long id, Session session) throws HibernateException {
		Consumidor consumidor = (Consumidor) session.get(Consumidor.class, id);
		return consumidor;
	}

	@Override
	public List<Consumidor> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from consumidor");
		return consulta.list();
	}

	@Override
	public List<Consumidor> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("form consumidor c where c.nome like :nome");
		consulta.setParameter("nome", "%" + filtro + "%");
		return consulta.list();
	}

}
