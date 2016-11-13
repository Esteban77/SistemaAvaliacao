package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.Pergunta;

public class PerguntaDaoImpl extends BaseDaoImpl<Pergunta, Long> implements PerguntaDao,Serializable{

	@Override
	public Pergunta pesquisaPorId(Long id, Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pergunta> listaTodos(Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pergunta> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
