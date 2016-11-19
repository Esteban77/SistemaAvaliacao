package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Pergunta;
import entidade.TipoDeFormulario;

public class PerguntaDaoImpl extends BaseDaoImpl<Pergunta, Long> implements PerguntaDao,Serializable{

	@Override
	public Pergunta pesquisaPorId(Long id, Session session) throws HibernateException {
		Pergunta pergunta = (Pergunta) session.get(Pergunta.class, id);
		return pergunta;
		
	}

	@Override
	public List<Pergunta> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Pergunta");
		return consulta.list();
	}

	@Override
	public List<Pergunta> pesquisaPorIdFormulario(Long idFormulario, Session session) throws HibernateException {		
		Query consulta = session.createQuery("from Pergunta p where p.tipoDeFormulario.id= :id");
		consulta.setParameter("id", idFormulario);
		return consulta.list();
	}

	@Override
	public List<Pergunta> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
