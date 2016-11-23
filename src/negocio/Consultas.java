package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        
        Date dataIni = java.sql.Date.valueOf(dataInicial);
        Date dataFin = java.sql.Date.valueOf(dataFinal);
        
        if(formulario.equals("Todos")){
        	List<Object[]> listObject = consultaDao.resultadoPorEmpresa(idEmpresa,dataIni, dataFin, session);
        	JSONArray jsonArray = gerarArray(listObject);
        	
        	try {
    			response.getWriter().write(jsonArray.toString());
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	return "true";
        }else if(pergunta.equals("Todos")){
        	Long idFormulario = Long.parseLong(formulario);
        	List<Object[]> listObject = consultaDao.resultadoPorFormulario(idFormulario, dataIni, dataFin, session);
        	JSONArray jsonArray = gerarArray(listObject);
        	
        	try {
    			response.getWriter().write(jsonArray.toString());
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	return "true";
        }else{
        	Long idFormulario = Long.parseLong(formulario);
        	Long idPergunta = Long.parseLong(pergunta);
        	List<Object[]> listObject = consultaDao.resultadoPorFormularioPergunta(idFormulario, idPergunta, dataIni, dataFin, session);
        	JSONArray jsonArray = gerarArray(listObject);
        	
        	try {
    			response.getWriter().write(jsonArray.toString());
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	return "true";
        }
        
        
		
	}
	
	private JSONArray gerarArray (List<Object[]> listObject){
		JSONArray jsonArray = new JSONArray();
		Long numBom =0L;
		Long numOtimo =0L;
		Long numPessimo=0L;
		Long numRuim=0L;
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
				numBom = (Long) obj[0];				
				break;
			case "OTIMO":
				numOtimo = (Long) obj[0];			
			break;
			case "PESSIMO":
				numPessimo = (Long) obj[0];			
			break;
			case "RUIM":
				numRuim = (Long) obj[0];			
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
