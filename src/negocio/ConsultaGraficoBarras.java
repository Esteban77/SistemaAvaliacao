package negocio;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;

import dao.ConsultasDao;
import dao.ConsultasDaoImpl;
import dao.HibernateUtil;

public class ConsultaGraficoBarras implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        ConsultasDao consultaDao = new ConsultasDaoImpl();
        Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
        Date date = new Date();
        Integer ano = date.getYear()+1900;
        List<Object[]> listObject = consultaDao.resultadoGraficoBarras(idEmpresa,ano, session);
        
        if(listObject != null && !listObject.isEmpty()){        	
        	JSONArray jsonArray = gerarArray(listObject);
        	try {
        		System.out.println(jsonArray.toString());
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

	private JSONArray gerarArray (List<Object[]> listObject){
		JSONArray jsonArray = new JSONArray();
		Integer numBomJaneiro =0;
		Integer numBomFevereiro =0;
		Integer numBomMarco =0;
		Integer numBomAbril =0;
		Integer numBomMaio =0;
		Integer numBomJunho =0;
		Integer numBomJulho =0;
		Integer numBomAgosto =0;
		Integer numBomSetembro =0;
		Integer numBomOutubro =0;
		Integer numBomNovembro =0;
		Integer numBomDezembro =0;
		Integer numOtimoJaneiro =0;
		Integer numOtimoFevereiro =0;
		Integer numOtimoMarco =0;
		Integer numOtimoAbril =0;
		Integer numOtimoMaio =0;
		Integer numOtimoJunho =0;
		Integer numOtimoJulho =0;
		Integer numOtimoAgosto =0;
		Integer numOtimoSetembro =0;
		Integer numOtimoOutubro =0;
		Integer numOtimoNovembro =0;
		Integer numOtimoDezembro =0;		
		Integer numPessimoJaneiro=0;
		Integer numPessimoFevereiro=0;
		Integer numPessimoMarco=0;
		Integer numPessimoAbril=0;
		Integer numPessimoMaio=0;
		Integer numPessimoJunho=0;
		Integer numPessimoJulho=0;
		Integer numPessimoAgosto=0;
		Integer numPessimoSetembro=0;
		Integer numPessimoOutubro=0;
		Integer numPessimoNovembro=0;
		Integer numPessimoDezembro=0;		
		Integer numRuimJaneiro=0;
		Integer numRuimFevereiro=0;
		Integer numRuimMarco=0;
		Integer numRuimAbril=0;
		Integer numRuimMaio=0;
		Integer numRuimJunho=0;
		Integer numRuimJulho=0;
		Integer numRuimAgosto=0;
		Integer numRuimSetembro=0;
		Integer numRuimOutubro=0;
		Integer numRuimNovembro=0;
		Integer numRuimDezembro=0;		
		
		JSONArray jobBom = new JSONArray();
		JSONArray jobOtimo = new JSONArray();
		JSONArray jobPessimo = new JSONArray();
		JSONArray jobRuim = new JSONArray();
		
		for(Object[] obj : listObject){			
			BigInteger qtd = (BigInteger) obj[0];
			Integer qtdInt = qtd.intValue();
			String opcao =  (String) obj[1];
			Integer mes = (Integer) obj[2];
			Integer ano1 = (Integer) obj[3];
			
			switch (opcao) {
			case "BOM":
				switch (mes) {
				case 1:
					numBomJaneiro = qtdInt;
					break;
				case 2:
					numBomFevereiro = qtdInt;
					break;
				case 3:
					numBomMarco = qtdInt;
					break;
				case 4:
					numBomAbril = qtdInt;
					break;
				case 5:
					numBomMaio = qtdInt;
					break;
				case 6:
					numBomJunho = qtdInt;
					break;
				case 7:
					numBomJulho = qtdInt*10;
					break;
				case 8:
					numBomAgosto = qtdInt;
					break;
				case 9:
					numBomSetembro = qtdInt;
					break;
				case 10:
					numBomOutubro = qtdInt;
					break;
				case 11:
					numBomNovembro = qtdInt;
					break;
				case 12:
					numBomDezembro = qtdInt;
					break;
				}	
				break;
			case "OTIMO":
				switch (mes) {
				case 1:
					numOtimoJaneiro = qtdInt;
					break;
				case 2:
					numOtimoFevereiro = qtdInt;
					break;
				case 3:
					numOtimoMarco = qtdInt;
					break;
				case 4:
					numOtimoAbril = qtdInt;
					break;
				case 5:
					numOtimoMaio = qtdInt;
					break;
				case 6:
					numOtimoJunho = qtdInt;
					break;
				case 7:
					numOtimoJulho = qtdInt;
					break;
				case 8:
					numOtimoAgosto = qtdInt;
					break;
				case 9:
					numOtimoSetembro = qtdInt*10;
					break;
				case 10:
					numOtimoOutubro = qtdInt;
					break;
				case 11:
					numOtimoNovembro = qtdInt*10;
					break;
				case 12:
					numOtimoDezembro = qtdInt;
					break;
				}			
			break;
			case "PESSIMO":
				switch (mes) {
				case 1:
					numPessimoJaneiro = qtdInt;
					break;
				case 2:
					numPessimoFevereiro = qtdInt;
					break;
				case 3:
					numPessimoMarco = qtdInt;
					break;
				case 4:
					numPessimoAbril = qtdInt;
					break;
				case 5:
					numPessimoMaio = qtdInt;
					break;
				case 6:
					numPessimoJunho = qtdInt;
					break;
				case 7:
					numPessimoJulho = qtdInt;
					break;
				case 8:
					numPessimoAgosto = qtdInt;
					break;
				case 9:
					numPessimoSetembro = qtdInt;
					break;
				case 10:
					numPessimoOutubro = qtdInt;
					break;
				case 11:
					numPessimoNovembro = qtdInt*10;
					break;
				case 12:
					numPessimoDezembro = qtdInt;
					break;
				}	
			break;
			case "RUIM":
				switch (mes) {
				case 1:
					numRuimJaneiro = qtdInt;
					break;
				case 2:
					numRuimFevereiro = qtdInt;
					break;
				case 3:
					numRuimMarco = qtdInt;
					break;
				case 4:
					numRuimAbril = qtdInt;
					break;
				case 5:
					numRuimMaio = qtdInt;
					break;
				case 6:
					numRuimJunho = qtdInt;
					break;
				case 7:
					numRuimJulho = qtdInt*10;
					break;
				case 8:
					numRuimAgosto = qtdInt;
					break;
				case 9:
					numRuimSetembro = qtdInt*10;
					break;
				case 10:
					numRuimOutubro = qtdInt;
					break;
				case 11:
					numRuimNovembro = qtdInt;
					break;
				case 12:
					numRuimDezembro = qtdInt;
					break;
				}			
			break;
			}
			
		}
		jobBom.put(numBomJaneiro);
		jobBom.put(numBomFevereiro);
		jobBom.put(numBomMarco);
		jobBom.put(numBomAbril);
		jobBom.put(numBomMaio);
		jobBom.put(numBomJunho);
		jobBom.put(numBomJulho);
		jobBom.put(numBomAgosto);
		jobBom.put(numBomSetembro);
		jobBom.put(numBomOutubro);
		jobBom.put(numBomNovembro);
		jobBom.put(numBomDezembro);
		
		jobOtimo.put(numOtimoJaneiro);
		jobOtimo.put(numOtimoFevereiro);
		jobOtimo.put(numOtimoMarco);
		jobOtimo.put(numOtimoAbril);
		jobOtimo.put(numOtimoMaio);
		jobOtimo.put(numOtimoJunho);
		jobOtimo.put(numOtimoJulho);
		jobOtimo.put(numOtimoAgosto);
		jobOtimo.put(numOtimoSetembro);
		jobOtimo.put(numOtimoOutubro);
		jobOtimo.put(numOtimoNovembro);
		jobOtimo.put(numOtimoDezembro);
		
		jobPessimo.put(numPessimoJaneiro);
		jobPessimo.put(numPessimoFevereiro);
		jobPessimo.put(numPessimoMarco);
		jobPessimo.put(numPessimoAbril);
		jobPessimo.put(numPessimoMaio);
		jobPessimo.put(numPessimoJunho);
		jobPessimo.put(numPessimoJulho);
		jobPessimo.put(numPessimoAgosto);
		jobPessimo.put(numPessimoSetembro);
		jobPessimo.put(numPessimoOutubro);
		jobPessimo.put(numPessimoNovembro);
		jobPessimo.put(numPessimoDezembro);
		
		jobRuim.put(numRuimJaneiro);
		jobRuim.put(numRuimFevereiro);
		jobRuim.put(numRuimMarco);
		jobRuim.put(numRuimAbril);
		jobRuim.put(numRuimMaio);
		jobRuim.put(numRuimJunho);
		jobRuim.put(numRuimJulho);
		jobRuim.put(numRuimAgosto);
		jobRuim.put(numRuimSetembro);
		jobRuim.put(numRuimOutubro);
		jobRuim.put(numRuimNovembro);
		jobRuim.put(numRuimDezembro);
				
		jsonArray.put(jobBom);
		jsonArray.put(jobOtimo);
		jsonArray.put(jobPessimo);
		jsonArray.put(jobRuim);
		
		
		return jsonArray;
	}
}
