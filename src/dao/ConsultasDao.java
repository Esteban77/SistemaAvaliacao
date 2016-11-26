package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.Consumidor;
import negocio.Consultas;

public interface ConsultasDao extends BaseDAO<Consultas,Long>{
	public List<Object[]> resultadoPorEmpresa(Long idEmpresa, Date dataIni, Date dataFinal, Session session) throws HibernateException;
	public List<Object[]> resultadoPorFormulario(Long idFormulario, Date dataIni, Date dataFinal, Session session) throws HibernateException;
	public List<Object[]> resultadoPorFormularioPergunta(Long idFormulario, Long idPergunta, Date dataIni, Date dataFinal, Session session) throws HibernateException;
	public List<Object[]> resultadoGraficoBarras(Long idEmpresa, Integer ano, Session session) throws HibernateException;

}
