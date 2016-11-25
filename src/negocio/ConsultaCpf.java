package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.ConsumidorDao;
import dao.ConsumidorDaoImpl;
import dao.HibernateUtil;
import entidade.Consumidor;

public class ConsultaCpf implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        ConsumidorDao consumidorDao = new ConsumidorDaoImpl();
        
        String cpfRecebido = request.getParameter("cpf");
        Consumidor consumidorRecebido = consumidorDao.pesquisaPorCpf(cpfRecebido, session);
        
        if(consumidorRecebido!=null){
        	JSONObject objeto = new JSONObject();
			objeto.put("id", consumidorRecebido.getId());
			objeto.put("cpf", consumidorRecebido.getCpf());
			objeto.put("email", consumidorRecebido.getEmail());
			objeto.put("login", consumidorRecebido.getLogin());
			objeto.put("nome", consumidorRecebido.getNome());
			objeto.put("senha", consumidorRecebido.getSenha());
			objeto.put("telefone", consumidorRecebido.getTelefone());
			
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
