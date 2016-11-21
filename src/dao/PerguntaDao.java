package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.Pergunta;

public interface PerguntaDao extends BaseDAO<Pergunta, Long>{
	List<Pergunta> pesquisaPorIdFormulario(Long idFormulario, Session session) throws HibernateException;
	List<Pergunta> pesquisaPorIdEmpresa(Long idEmpresa, Session session) throws HibernateException;

}
