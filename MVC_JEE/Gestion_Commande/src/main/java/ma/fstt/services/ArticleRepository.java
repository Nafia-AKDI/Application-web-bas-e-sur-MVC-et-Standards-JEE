package ma.fstt.services;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Article;


public interface ArticleRepository {
	public boolean insertArticle(Article article) throws SQLException;
	public boolean deleteArticle(Article article) throws SQLException;
	public List<Article> listAllArticles() throws SQLException;
	public boolean updateArticle(Article client) throws SQLException;
	Article getArticle(int id) throws SQLException;
}
