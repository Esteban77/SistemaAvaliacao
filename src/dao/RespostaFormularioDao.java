package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.RespostaFormulario;
import entidade.TipoDeFormulario;

public interface RespostaFormularioDao extends BaseDAO<RespostaFormulario, Long>{
	public RespostaFormulario pesquisaPorRespostaFormulario(Long id, Session session) throws HibernateException;
}
