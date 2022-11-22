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

import ma.fstt.dao.ArticleDAO;
import ma.fstt.entities.Article;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */

public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDAO articleDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

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
			case "/article/new":
				showNewForm(request, response);
				break;
			case "/article/insert":
				insertArticle(request, response);
				break;
			case "/article/delete":
				deleteArticle(request, response);
				break;
			case "/article/edit":
				showEditForm(request, response);
				break;
			case "/article/update":
				updateArticle(request, response);
				break;
			case "/article/list":
				listArticle(request, response);
				break;
			
			default:
				listArticle(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Article> listArticle = articleDAO.listAllArticles();
		
		request.setAttribute("listArticle", listArticle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArticleList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArticleForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article existingArticle = articleDAO.getArticle(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArticleForm.jsp");
		request.setAttribute("article", existingArticle);
		dispatcher.forward(request, response);

	}

	private void insertArticle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom_art = request.getParameter("nomArt");
		int pu = Integer.parseInt(request.getParameter("pu"));
		int qte_stock = Integer.parseInt(request.getParameter("QteStock"));
	


		Article newArticle = new Article(nom_art, pu, qte_stock);
		articleDAO.insertArticle(newArticle);
		response.sendRedirect("list");
	}

	private void updateArticle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("codArt"));
		String nom_art = request.getParameter("nomArt");
		int pu = Integer.parseInt(request.getParameter("pu"));
		int qte_stock = Integer.parseInt(request.getParameter("QteStock"));


		Article article = new Article(id, nom_art, pu, qte_stock);
		articleDAO.updateArticle(article);
		response.sendRedirect("list");
	}

	private void deleteArticle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Article article = new Article(id);
		articleDAO.deleteArticle(article);
		response.sendRedirect("list");

	}

}
