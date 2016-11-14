package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Acao;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FrontController() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
   		try {
			request.setCharacterEncoding("UTF-8");    	
			String parametro = request.getParameter("acao");
			String nomeDaClasse = "negocio."+parametro;
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			String pagina = acao.executar(request, response);
			
			if(pagina=="true"){
				
			}else if(pagina=="false"){
				throw new ServletException("A lógica de persistencia causou uma excessão");
			}else{
				request.getServletContext().getRequestDispatcher(pagina).forward(request, response);
			}			
		} catch (Exception e) {
			throw new ServletException(
	             "A lógica de negócio causou uma excessão", e);
		}		
	}
    
}
