package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import dao.TipoDeBeneficioDaoImpl;
import entidade.Empresa;
import entidade.TipoDeBeneficio;

public class RemoverBeneficio implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
		Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);
		Long idBeneficio = Long.valueOf(request.getParameter("idBeneficio"));
	
		TipoDeBeneficioDaoImpl tipoDeBeneficioDaoImpl = new TipoDeBeneficioDaoImpl();
		TipoDeBeneficio tipoReturn = tipoDeBeneficioDaoImpl.pesquisaPorId(idBeneficio, session);
		tipoDeBeneficioDaoImpl.excluir(tipoReturn, session);
		TipoDeBeneficio tipoReturn2 = tipoDeBeneficioDaoImpl.pesquisaPorId(idBeneficio, session);
		session.close();
		request.getSession().setAttribute("empresa", empresa);
		if(tipoReturn2==null){
			try {
				response.getWriter().write("true");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "true";
		}else{
			try {
				response.getWriter().write("false");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "false";
		}
		
	}

}
