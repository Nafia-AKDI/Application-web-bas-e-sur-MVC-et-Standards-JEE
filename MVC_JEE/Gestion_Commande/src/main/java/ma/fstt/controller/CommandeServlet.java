package ma.fstt.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ArticleDAO;
import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Article;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */

public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO;
	private ClientDAO clientDAO;


	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		commandeDAO = new CommandeDAO();
		clientDAO = new ClientDAO();


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/commande/new":
				showNewForm(request, response);
				break;
			case "/commande/insert":
				insertCommande(request, response);
				break;
			case "/commande/delete":
				deleteCommande(request, response);
				break;
			case "/commande/edit":
				showEditForm(request, response);
				break;
			case "/commande/update":
				updateCommande(request, response);
				break;
			case "/commande/list":
				listCommande(request, response);
				break;
			
			default:
				listCommande(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCommande(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Commande> listCommande = commandeDAO.listAllCommandes();
		request.setAttribute("listCommande", listCommande);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<Client> listClient = clientDAO.listAllClients();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeForm.jsp");
		request.setAttribute("listClient", listClient);	
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Commande existingCommande = commandeDAO.getCommande(id);
		List<Client> listClient = clientDAO.listAllClients();
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeForm.jsp");
		request.setAttribute("listClient", listClient);
		request.setAttribute("commande", existingCommande);
		dispatcher.forward(request, response);

	}

	private void insertCommande(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Date date_cmd = Date.valueOf(request.getParameter("dateCmd"));
		int cod_cli = Integer.parseInt(request.getParameter("codCli"));

	


		Commande newCommande = new Commande(date_cmd, cod_cli);
		commandeDAO.insertCommande(newCommande);
		response.sendRedirect("list");
	}

	private void updateCommande(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("numCmd"));
		Date date_cmd = Date.valueOf(request.getParameter("dateCmd"));
		int cod_cli = Integer.parseInt(request.getParameter("codCli"));


		Commande commande = new Commande(id,date_cmd, cod_cli);
		commandeDAO.updateCommande(commande);
		response.sendRedirect("list");
	}

	private void deleteCommande(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Commande commande = new Commande(id);
		commandeDAO.deleteCommande(commande);
		response.sendRedirect("list");

	}

}
