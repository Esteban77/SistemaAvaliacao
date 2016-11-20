package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.PerguntaDaoImpl;
import dao.RespostaFormularioDaoImpl;
import entidade.Opcao;
import entidade.Pergunta;
import entidade.Resposta;
import entidade.RespostaFormulario;

public class SalvarRespostasFormulario  implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
			Session session = HibernateUtil.getSession();
			RespostaFormulario respostaFormulario = new RespostaFormulario();
			RespostaFormularioDaoImpl respostaDao = new RespostaFormularioDaoImpl();
			String idRespostaF = request.getParameter("idResposta");
			Long idResposta = Long.parseLong(idRespostaF);
			respostaFormulario = respostaDao.pesquisaPorId(idResposta, session);
			String respostas;
			String comentario;
			String data;
			
			respostas = request.getParameter("respostas");
			comentario = request.getParameter("comentario");
			data = request.getParameter("data");
			JSONArray jsonRespostas = new JSONArray(respostas);
			PerguntaDaoImpl perguntaDao = new PerguntaDaoImpl();
			List<Resposta> listRespostas = new ArrayList<>();
			Pergunta pergunta = null;
			String res = null;
			
			for(int i=0;i<jsonRespostas.length();i++){
				JSONObject jsonobj = jsonRespostas.getJSONObject(i);
				res = (String) jsonobj.get("resposta");
				String id =  (String) jsonobj.get("idPergunta");
				Long idPergunta = Long.valueOf(id);
				pergunta = perguntaDao.pesquisaPorId(idPergunta, session);
				Resposta resposta = new Resposta();
				resposta.setId(null);
				resposta.setPergunta(pergunta);
				for(Opcao op : Opcao.values()){
					if(res.equals(op.name())){						
						resposta.setOpcao(op);
					}
				}
				resposta.setRespostaFormulario(respostaFormulario);
				listRespostas.add(resposta);
			}		
			Date date = new Date();
			date.getDate();
			respostaFormulario.setComentario(comentario);
			respostaFormulario.setData(date);
			respostaFormulario.setRespostas(listRespostas);
			respostaDao.salvarOuAlterar(respostaFormulario, session);			
			session.close();
			
			if(respostaFormulario.getRespostas()!=null || !respostaFormulario.getRespostas().isEmpty()){
				return "true";
			}else{
				return "false";
			}					
		
	}

}
