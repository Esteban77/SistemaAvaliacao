package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.Consumidor;

public interface ConsumidorDao extends BaseDAO<Consumidor, Long> {
	public Consumidor pesquisaPorCpf(String cpf, Session session) throws HibernateException;
}
