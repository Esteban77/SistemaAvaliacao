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

import dao.ConsultasDao;
import dao.ConsultasDaoImpl;
import dao.HibernateUtil;
import entidade.Opcao;

public class Consultas implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        ConsultasDao consultaDao = new ConsultasDaoImpl();
        Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
        
        String dataInicial = request.getParameter("dataInicio");
        String dataFinal = request.getParameter("dataFinal");
        String formulario = request.getParameter("Formularios");
        String pergunta = request.getParameter("selectPerguntas");
        
        if(formulario.equals("Todos")){
        	List<Object[]> listObject = consultaDao.resultadoPorEmpresa(idEmpresa, session);
        	JSONArray jsonArray = gerarArray(listObject);
        	
        	try {
    			response.getWriter().write(jsonArray.toString());
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        }else{
        	
        }   
        
        
		return "true";
	}
	
	private JSONArray gerarArray (List<Object[]> listObject){
		JSONArray jsonArray = new JSONArray();
		Integer numBom =0;
		Integer numOtimo =0;
		Integer numPessimo=0;
		Integer numRuim=0;
		JSONObject jobBom = new JSONObject();
		JSONObject jobOtimo = new JSONObject();
		JSONObject jobPessimo = new JSONObject();
		JSONObject jobRuim = new JSONObject();
		
		for(Object[] obj : listObject){			
			Long qtd = (Long) obj[0];
			Opcao opcao =  (Opcao) obj[1];
			String op = opcao.name();
			
			switch (op) {
			case "BOM":
				numBom = (Integer) obj[0];				
				break;
			case "OTIMO":
				numOtimo = (Integer) obj[0];			
			break;
			case "PESSIMO":
				numPessimo = (Integer) obj[0];			
			break;
			case "RUIM":
				numRuim = (Integer) obj[0];			
			break;
			}
			
		}
		jobBom.put("qtd", numBom);
		jobOtimo.put("qtd", numOtimo);
		jobPessimo.put("qtd", numPessimo);
		jobRuim.put("qtd", numRuim);
		
		jsonArray.put(jobBom);
		jsonArray.put(jobOtimo);
		jsonArray.put(jobPessimo);
		jsonArray.put(jobRuim);
		
		
		return jsonArray;
	}

}
