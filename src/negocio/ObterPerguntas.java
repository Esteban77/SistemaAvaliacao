package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.PerguntaDaoImpl;
import entidade.Pergunta;

public class ObterPerguntas implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");
        Session session = HibernateUtil.getSession();
        Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
        PerguntaDaoImpl perguntaDao = new PerguntaDaoImpl();
        String id = request.getParameter("idTipoFormulario");
               
        List<Pergunta> listPerguntas = new ArrayList<>();
        if(id.equals("Todos")){
           	try {
           		JSONObject jsonObject = new JSONObject();  
                jsonObject.put("id", "Todos");  
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           	return "true";
        }else{
        	
        	 Long idTipoFormulario = Long.parseLong(id);
        	listPerguntas = perguntaDao.pesquisaPorIdFormulario(idTipoFormulario, session);
        	session.close();
    		if(!listPerguntas.isEmpty()){
	    		JSONArray jsonArray = new JSONArray();
	    		for(Pergunta pergunta : listPerguntas){
	    			   JSONObject jsonObject = new JSONObject();  
	                   jsonObject.put("id", pergunta.getId());  
	                   jsonObject.put("nome", pergunta.getNomePergunta());  
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

}
