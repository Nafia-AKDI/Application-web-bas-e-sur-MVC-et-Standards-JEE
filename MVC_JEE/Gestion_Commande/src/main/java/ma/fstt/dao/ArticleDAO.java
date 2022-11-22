package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Article;
import ma.fstt.services.ArticleRepository;

public  class ArticleDAO implements ArticleRepository {
	private Connection jdbcConnection;
	
	protected void connect() throws SQLException {
		
			jdbcConnection =SingletonConnection.getConnection();
	}
//	protected void disconnect() throws SQLException {
//		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
//			jdbcConnection.close();
//		}
//	}
	@Override
	public boolean insertArticle(Article article) throws SQLException {
		String sql = "INSERT INTO article (nom_art, pu, qte_stock) VALUES (?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, article.getNomArt());
		statement.setLong(2, article.getPu());
		statement.setLong(3, article.getQteStock());
		
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowInserted;
	}
	@Override
	public List<Article> listAllArticles() throws SQLException {
		List<Article> listArticle = new ArrayList<>();
		
		String sql = "SELECT * FROM article";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int codArt = resultSet.getInt("cod_art");
			String nomArt = resultSet.getString("nom_art");
			int pu = resultSet.getInt("pu");
			int qteStock = resultSet.getInt("qte_stock");
			
			
			Article article = new Article(codArt, nomArt, pu, qteStock);
			listArticle.add(article);
			
		}
		
		resultSet.close();
		statement.close();
		
		//disconnect();
		
		return listArticle;
	}
	@Override
	public boolean deleteArticle(Article article) throws SQLException {
		String sql = "DELETE FROM article where cod_art = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, article.getCodArt());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowDeleted;		
	}
	@Override
	public boolean updateArticle(Article article) throws SQLException {
		String sql = "UPDATE article SET  nom_art = ?, pu = ?, qte_stock = ?";
		sql += " WHERE cod_art = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, article.getNomArt());
		statement.setLong(2, article.getPu());
		statement.setLong(3, article.getQteStock());
		statement.setLong(4, article.getCodArt());
	
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowUpdated;		
	}
	@Override
	public Article getArticle(int id) throws SQLException {
		Article article = null;
		String sql = "SELECT * FROM article WHERE cod_art = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			int codArt = resultSet.getInt("cod_art");

			String nomArt = resultSet.getString("nom_art");
			int pu = resultSet.getInt("pu");
			int qteStock = resultSet.getInt("qte_stock");
			
			article = new Article(codArt, nomArt, pu, qteStock);
		}
		
		resultSet.close();
		statement.close();
		
		return article;
				
	}
	}