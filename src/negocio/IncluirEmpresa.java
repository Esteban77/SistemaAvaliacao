package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.EmpresaDao;
import dao.EmpresaDaoImpl;
import dao.HibernateUtil;
import entidade.Empresa;

public class IncluirEmpresa implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Empresa empresa = new Empresa();
		EmpresaDao empresaDao = new EmpresaDaoImpl();
		Session session = HibernateUtil.getSession();
		
		empresa.setId(null);
		empresa.setNome(request.getParameter("nomeEmpresa"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setLogin(request.getParameter("nomeUsuario"));
		empresa.setSenha(request.getParameter("senha"));
		empresa.setTelefone(request.getParameter("telefone"));
		
		empresaDao.salvarOuAlterar(empresa, session);
		
		session.close();
		

		return "/jsp/menuEmpresa.jsp";

	}

}
