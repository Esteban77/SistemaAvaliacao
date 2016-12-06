package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.TipoDeFormularioDaoImpl;
import entidade.TipoDeFormulario;

public class VisualizarFormulario implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        
        TipoDeFormularioDaoImpl tipoDeFormularioDaoImpl = new TipoDeFormularioDaoImpl();
        Long idFormulario = Long.parseLong(request.getParameter("idFormulario"));
        
       TipoDeFormulario formulario = tipoDeFormularioDaoImpl.pesquisaPorId(idFormulario, session);
        
       if(formulario!=null){
       	JSONObject objeto = new JSONObject();
       	
			objeto.put("id", formulario.getId());
			objeto.put("nomeFormularioVisualizar", formulario.getNomeFormulario());
			//objeto.put("perguntas", formulario.getPerguntas());
			
			try {
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
