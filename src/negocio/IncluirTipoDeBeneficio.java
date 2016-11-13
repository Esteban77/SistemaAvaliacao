package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import dao.TipoDeBeneficioDaoImpl;
import entidade.Empresa;
import entidade.TipoDeBeneficio;

public class IncluirTipoDeBeneficio implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Session session = HibernateUtil.getSession();
		Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
		Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);
		
		TipoDeBeneficio tipoDeBeneficio = new TipoDeBeneficio();
		TipoDeBeneficioDaoImpl tipoDeBeneficioDaoImpl = new TipoDeBeneficioDaoImpl();
		
		tipoDeBeneficio.setId(null);
		tipoDeBeneficio.setNomeBeneficio(request.getParameter("beneficio"));
		tipoDeBeneficio.setEmpresa(empresa);
		tipoDeBeneficioDaoImpl.salvarOuAlterar(tipoDeBeneficio, session);
		
		session.close();
		
		return "/jsp/menuEmpresa.jsp";
	}

}
