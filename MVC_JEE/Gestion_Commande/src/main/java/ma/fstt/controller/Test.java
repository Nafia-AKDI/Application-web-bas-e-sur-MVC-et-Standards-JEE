package ma.fstt.controller;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.dao.ArticleDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LigneCmdDAO;
import ma.fstt.entities.Article;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCmd;

public class Test {
	public static void main(String[] args) {
		LigneCmdDAO ligneCmdDAO=new LigneCmdDAO();
	try {
		List<LigneCmd> listLigneCmd = ligneCmdDAO.listAllLigneCmds();


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
}
}
