package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import dao.TipoDeBeneficioDaoImpl;
import entidade.Empresa;
import entidade.TipoDeBeneficio;

public class IncluirTipoDeBeneficio implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Session session = HibernateUtil.getSession();
		Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
		Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);
		
		TipoDeBeneficio tipoDeBeneficio = new TipoDeBeneficio();
		TipoDeBeneficioDaoImpl tipoDeBeneficioDaoImpl = new TipoDeBeneficioDaoImpl();
		
		tipoDeBeneficio.setId(null);
		tipoDeBeneficio.setNomeBeneficio(request.getParameter("beneficio"));
		tipoDeBeneficio.setEmpresa(empresa);
		tipoDeBeneficioDaoImpl.salvarOuAlterar(tipoDeBeneficio, session);
		TipoDeBeneficio tipoReturn = tipoDeBeneficioDaoImpl.pesquisaPorId(tipoDeBeneficio.getId(), session);
		session.close();
		
		request.getSession().setAttribute("empresa", empresa);
		if(tipoReturn!=null){
			JSONObject objeto = new JSONObject();
			objeto.put("id", tipoReturn.getId());
			objeto.put("nome", tipoReturn.getNomeBeneficio());
			try {
				response.setCharacterEncoding("UTF-8");  
		        response.setContentType("application/json");   
				response.getWriter().write(objeto.toString());
			}catch(IOException e) {
				e.printStackTrace();
			} 		
			return "true";
		}else{
			return "false";
		}
			}

}
