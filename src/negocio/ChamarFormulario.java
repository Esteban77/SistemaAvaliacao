package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.HibernateUtil;
import dao.TipoDeFormularioDaoImpl;
import entidade.TipoDeFormulario;

public class ChamarFormulario implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Session session = HibernateUtil.getSession();
		
        TipoDeFormularioDaoImpl tipoDeFormularioDaoImpl = new TipoDeFormularioDaoImpl();
        //Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
        
		//Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);		
		TipoDeFormulario formulario = new TipoDeFormulario();
		
		Long idFormulario = Long.parseLong(request.getParameter("idTipoFormulario"));
		formulario = tipoDeFormularioDaoImpl.pesquisaPorId(idFormulario, session);
	
		session.close();
		
		request.setAttribute("formulario", formulario);
		
		return "/jsp/Formulario.jsp";
	}

}
