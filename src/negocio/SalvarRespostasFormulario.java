package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;

import dao.HibernateUtil;
import dao.RespostaFormularioDaoImpl;
import entidade.Pergunta;
import entidade.Resposta;
import entidade.RespostaFormulario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalvarRespostasFormulario  implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
			Session session = HibernateUtil.getSession();
			RespostaFormulario resposta = new RespostaFormulario();
			RespostaFormularioDaoImpl respostaDao = new RespostaFormularioDaoImpl();
			String respostas;
			Resposta respostaOpcao = new Resposta();
			

			respostas = request.getParameter("respostas");
			JSONArray jsonRespostas = new JSONArray(respostas);
			
			for(Object s :jsonRespostas){
				System.out.println(s.toString());
			}
			
			
			
		return null;
	}

}
