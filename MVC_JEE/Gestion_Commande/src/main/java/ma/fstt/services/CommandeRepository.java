package ma.fstt.services;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCmd;

public interface CommandeRepository {

	public boolean insertCommande(Commande commande) throws SQLException;
	public boolean deleteCommande(Commande commande) throws SQLException;
	public List<Commande> listAllCommandes() throws SQLException;
	public boolean updateCommande(Commande commande) throws SQLException;
	Commande getCommande(int id) throws SQLException;
}
