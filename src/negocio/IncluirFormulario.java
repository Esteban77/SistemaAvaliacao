package negocio;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import dao.PerguntaDao;
import dao.PerguntaDaoImpl;
import dao.TipoDeFormularioDao;
import dao.TipoDeFormularioDaoImpl;
import entidade.Empresa;
import entidade.Pergunta;
import entidade.TipoDeFormulario;


public class IncluirFormulario implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Session session = HibernateUtil.getSession();
		Long idEmpresa = (Long) request.getSession().getAttribute("idEmpresa");
		Empresa empresa = new EmpresaDaoImpl().pesquisaPorId(idEmpresa, session);
		
		TipoDeFormulario formulario = new TipoDeFormulario();
		Pergunta pergunta;
		String perguntas;
		List<Pergunta> listPerguntas = new ArrayList<>();
		TipoDeFormularioDao formularioDao = new TipoDeFormularioDaoImpl();
		
		
		perguntas = request.getParameter("perguntas");
		JSONArray lista = new JSONArray(perguntas);
		
		formulario.setId(null);
		formulario.setNomeFormulario(request.getParameter("nomeFormulario"));

		formulario.setEmpresa(empresa);
		formularioDao.salvarOuAlterar(formulario, session);
		
				
		for(Object s :lista){
			pergunta = new Pergunta();
			pergunta.setNomePergunta(s.toString());
			pergunta.setTipoDeFormulario(formulario);
			listPerguntas.add(pergunta);
		}
		formulario.setPerguntas(listPerguntas);	
		formularioDao.salvarOuAlterar(formulario, session);
		
		TipoDeFormulario formRetorno = formularioDao.pesquisaPorId(formulario.getId(), session);
		session.close();
		request.getSession().setAttribute("empresa", empresa);
		
		if(formRetorno!=null){
			JSONObject objeto = new JSONObject();
			objeto.put("id", formRetorno.getId());
			objeto.put("nome", formRetorno.getNomeFormulario());
			try {
				response.setCharacterEncoding("UTF-8");  
		        response.setContentType("application/json");   
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
