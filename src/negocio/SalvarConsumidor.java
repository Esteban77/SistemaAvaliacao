package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.ConsumidorDaoImpl;
import dao.HibernateUtil;
import dao.RespostaFormularioDaoImpl;
import dao.TipoDeFormularioDaoImpl;
import entidade.Consumidor;
import entidade.Opcao;
import entidade.Pergunta;
import entidade.RespostaFormulario;
import entidade.TipoDeFormulario;

public class SalvarConsumidor implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Session session = HibernateUtil.getSession();
		Consumidor consumidor = new Consumidor();
		RespostaFormulario respostaFormulario = new RespostaFormulario();
		RespostaFormularioDaoImpl respostaDao = new RespostaFormularioDaoImpl();
		TipoDeFormularioDaoImpl tipoDeFormularioDao = new TipoDeFormularioDaoImpl();
		
//		String idCons = request.getParameter("idConsumidor");
		String anonimo = request.getParameter("anonimo");
		String pedido = request.getParameter("pedido");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nomeConsumidor = request.getParameter("nomeConsumidor");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		String tipoFormulario = request.getParameter("idTipoFormulario");
		Long idTipoFormulario = Long.parseLong(tipoFormulario);
		TipoDeFormulario tipoDeFormulario = tipoDeFormularioDao.pesquisaPorId(idTipoFormulario, session);
		
		if(anonimo!=null){
			respostaFormulario.setAnonimo(true);
			respostaFormulario.setConsumidor(null);
			respostaFormulario.setId(null);
			respostaFormulario.setNumeroPedido(Integer.parseInt(pedido));
			respostaFormulario.setTipoDeFormulario(tipoDeFormulario);			
		}else{
//			Long idConsumidor = Long.parseLong("idCons");
			ConsumidorDaoImpl consumidorDao = new ConsumidorDaoImpl();
//			consumidor.setId(idConsumidor);
			consumidor.setId(null);
			consumidor.setCpf(cpf);
			consumidor.setEmail(email);
			consumidor.setLogin(login);
			consumidor.setNome(nomeConsumidor);
			consumidor.setSenha(senha);
			consumidor.setTelefone(telefone);
			consumidorDao.salvarOuAlterar(consumidor, session);			
			
			respostaFormulario.setAnonimo(false);
			respostaFormulario.setConsumidor(consumidor);
			respostaFormulario.setId(null);
			respostaFormulario.setNumeroPedido(Integer.parseInt(pedido));
			respostaFormulario.setTipoDeFormulario(tipoDeFormulario);			
		}
		respostaDao.salvarOuAlterar(respostaFormulario, session);
		session.close();
		
		if(respostaFormulario.getId()!=null){
			response.setCharacterEncoding("UTF-8");  
	        response.setContentType("application/json");
	        JSONObject objeto = new JSONObject();
			objeto.put("idRespostaFormulario", respostaFormulario.getId());
			objeto.put("idConsumidor", consumidor.getId());
			try {
				response.getWriter().write(objeto.toString());
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
