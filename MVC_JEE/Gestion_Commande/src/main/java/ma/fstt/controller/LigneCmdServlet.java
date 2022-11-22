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
import ma.fstt.dao.LigneCmdDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Article;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCmd;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */

public class LigneCmdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO;
	private ArticleDAO articleDAO;
	private LigneCmdDAO ligneCmdDAO;



	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		commandeDAO = new CommandeDAO();
		ligneCmdDAO = new LigneCmdDAO();
		articleDAO = new ArticleDAO();


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
			case "/ligneCmd/new":
				showNewForm(request, response);
				break;
			case "/ligneCmd/insert":
				insertLigneCmd(request, response);
				break;
			case "/ligneCmd/delete":
				deleteLigneCmd(request, response);
				break;
			case "/ligneCmd/edit":
				showEditForm(request, response);
				break;
			case "/ligneCmd/update":
				updateLigneCmd(request, response);
				break;
			case "/ligneCmd/list":
				listLigneCmd(request, response);
				break;
			
			default:
				listLigneCmd(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listLigneCmd(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<LigneCmd> listLigneCmd = ligneCmdDAO.listAllLigneCmds();
		request.setAttribute("listLigneCmd", listLigneCmd);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("LigneCmdList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<Commande> listCommande = commandeDAO.listAllCommandes();
		List<Article> listArticle = articleDAO.listAllArticles();

		RequestDispatcher dispatcher = request.getRequestDispatcher("LigneCmdForm.jsp");
		request.setAttribute("listCommande", listCommande);
		request.setAttribute("listArticle", listArticle);
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LigneCmd existingLigneCmd = ligneCmdDAO.getLigneCmd(id);
		List<Commande> listCommande = commandeDAO.listAllCommandes();
		List<Article> listArticle = articleDAO.listAllArticles();
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeForm.jsp");
		request.setAttribute("listCommande", listCommande);
		request.setAttribute("listArticle", listArticle);
		request.setAttribute("ligneCmd", existingLigneCmd);
		dispatcher.forward(request, response);

	}

	private void insertLigneCmd(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int qte_cmd = Integer.parseInt(request.getParameter("qteCmd"));
		int cod_art = Integer.parseInt(request.getParameter("codArt"));
		int num_cmd = Integer.parseInt(request.getParameter("numCmd"));


	
		LigneCmd newLigneCmd = new LigneCmd(qte_cmd, cod_art, num_cmd);
		ligneCmdDAO.insertLigneCmd(newLigneCmd);
		response.sendRedirect("list");
	}

	private void updateLigneCmd(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("numLigne"));
		int qte_cmd = Integer.parseInt(request.getParameter("qteCmd"));
		int cod_art = Integer.parseInt(request.getParameter("codArt"));
		int num_cmd = Integer.parseInt(request.getParameter("numCmd"));


		LigneCmd ligneCmd = new LigneCmd(id, qte_cmd, cod_art, num_cmd);
		ligneCmdDAO.updateLigneCmd(ligneCmd);
		response.sendRedirect("list");
	}

	private void deleteLigneCmd(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		LigneCmd ligneCmd = new LigneCmd(id);
		ligneCmdDAO.deleteLigneCmd(ligneCmd);
		response.sendRedirect("list");

	}

}
