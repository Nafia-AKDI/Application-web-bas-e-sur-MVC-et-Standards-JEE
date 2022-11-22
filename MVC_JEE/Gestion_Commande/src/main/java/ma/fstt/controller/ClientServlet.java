package ma.fstt.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

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
			case "/client/new":
				showNewForm(request, response);
				break;
			case "/client/insert":
				insertClient(request, response);
				break;
			case "/client/delete":
				deleteClient(request, response);
				break;
			case "/client/edit":
				showEditForm(request, response);
				break;
			case "/client/update":
				updateClient(request, response);
				break;
			case "/client/list":
				listClient(request, response);
				break;
			
			default:
				listClient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Client> listClient = clientDAO.listAllClients();
		
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client existingClient = clientDAO.getClient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
		request.setAttribute("client", existingClient);
		dispatcher.forward(request, response);

	}

	private void insertClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom_cli = request.getParameter("nomCli");
		String pre_cli = request.getParameter("preCli");
		String adr_cli = request.getParameter("adrCli");
		String tel_cli = request.getParameter("telCli");
		String ville_cli = request.getParameter("villeCli");


		Client newClient = new Client(nom_cli, pre_cli, adr_cli, tel_cli, ville_cli);
		clientDAO.insertClient(newClient);
		response.sendRedirect("list");
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("codCli"));
		String nom_cli = request.getParameter("nomCli");
		String pre_cli = request.getParameter("preCli");
		String adr_cli = request.getParameter("adrCli");
		String tel_cli = request.getParameter("telCli");
		String ville_cli = request.getParameter("villeCli");


		Client client = new Client(id, nom_cli, pre_cli, adr_cli, tel_cli, ville_cli);
		clientDAO.updateClient(client);
		response.sendRedirect("list");
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Client client = new Client(id);
		clientDAO.deleteClient(client);
		response.sendRedirect("list");

	}

}
