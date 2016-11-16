package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.HibernateUtil;
import dao.RespostaFormularioDaoImpl;
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
			List<RespostaFormulario> respostas = new ArrayList<>();
			Resposta respostaOpcao = new Resposta();
			
			Long idPergunta = Long.parseLong(request.getParameter("idPergunta"));
			String opcao = request.getParameter("opcoes" + idPergunta);
			
			resposta.setId(null);
			
			
		return null;
	}

}
