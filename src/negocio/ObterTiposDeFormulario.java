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
import dao.TipoDeFormularioDaoImpl;
import entidade.Empresa;
import entidade.TipoDeFormulario;

public class ObterTiposDeFormulario implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        TipoDeFormularioDaoImpl tipoDeFormularioDaoImpl = new TipoDeFormularioDaoImpl();
        Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
		Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);		
		List<TipoDeFormulario> listFormulario = tipoDeFormularioDaoImpl.pesquisaPorEmpresa(idEmpresa, session);
		session.close();
		if(!listFormulario.isEmpty()){
		JSONArray jsonArray = new JSONArray();
		for(TipoDeFormulario formulario : listFormulario ){
			   JSONObject jsonObject = new JSONObject();  
               jsonObject.put("id", formulario.getId());  
               jsonObject.put("nome", formulario.getNomeFormulario()
            		   );  
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
