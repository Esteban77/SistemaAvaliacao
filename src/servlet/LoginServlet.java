package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.mysql.jdbc.Connection;

import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import entidade.Empresa;

/**
 * servlet implementation class loginServlet
 */
@WebServlet("/svtlogar")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();       
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) request.getAttribute("conexao");
		String username=request.getParameter("nomeUsuario");
		String senha=request.getParameter("senha");
		HttpSession session = request.getSession();
		
		Empresa empresa = new EmpresaDaoImpl().buscarEmpresa(username, senha,HibernateUtil.getSession());
	
		if (empresa!=null) {
			session.setAttribute("idPessoa", empresa.getId());
			session.setAttribute("pessoa", empresa);
			response.sendRedirect("jsp/menuEmpresa.jsp");
		} else {
			response.sendRedirect("jsp/home.html");
		}
	}

}







