package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.ConsultasDao;
import dao.ConsultasDaoImpl;
import dao.HibernateUtil;

public class ConsultaGraficoBarras implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        ConsultasDao consultaDao = new ConsultasDaoImpl();
        Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
        
		return null;
	}

}
