package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.TipoDeFormularioDaoImpl;
import entidade.Pergunta;
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
       	JSONObject objetoForm = new JSONObject();
       	JSONArray jsonArray = new JSONArray();
       	for()
			
			objetoForm.put("nomeFormularioVisualizar", formulario.getNomeFormulario());
			objetoForm.put("perguntas", jsonArray);
			jsonArray.put(objetoForm);
			
			 Long idTipoFormulario = Long.parseLong(id);
	        	List<Pergunta>listPerguntas = perguntaDao.pesquisaPorIdFormulario(idTipoFormulario, session);
	        	session.close();
	    		if(!listPerguntas.isEmpty()){
		    		
		    		jsonArray.put(formulario.getNomeFormulario());
		    		
		    		for(Pergunta pergunta : listPerguntas){
		    			  jsonArray.put(pergunta.getNomePergunta());  
		    		}
			
			try {
				response.getWriter().write(jsonArray.toString());
			}catch(IOException e) {
				e.printStackTrace();
			} 		
			return "true";
			
       }else{
       	return "false";
       }       
	}

}
