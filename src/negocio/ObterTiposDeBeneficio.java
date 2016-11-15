package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import dao.TipoDeBeneficioDaoImpl;
import entidade.Empresa;
import entidade.TipoDeBeneficio;

public class ObterTiposDeBeneficio implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        TipoDeBeneficioDaoImpl tipoDeBeneficioDaoImpl = new TipoDeBeneficioDaoImpl();
        Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
		Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);		
		List<TipoDeBeneficio> listBeneficio = tipoDeBeneficioDaoImpl.pesquisaPorEmpresa(idEmpresa, session);
		session.close();
		if(!listBeneficio.isEmpty()){
		JSONArray jsonArray = new JSONArray();
		for(TipoDeBeneficio beneficio : listBeneficio ){
			   JSONObject jsonObject = new JSONObject();  
               jsonObject.put("id", beneficio.getId());  
               jsonObject.put("nome", beneficio.getNomeBeneficio());  
               jsonArray.put(jsonObject);  
		}
		
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "true";
		}else{
			return "false";
		}
		
	}

}
