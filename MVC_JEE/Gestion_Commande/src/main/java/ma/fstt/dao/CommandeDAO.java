package ma.fstt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.services.CommandeRepository;

public  class CommandeDAO implements CommandeRepository {
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
	public boolean insertCommande(Commande commande) throws SQLException {
		String sql = "INSERT INTO commande ( date_cmd, cod_cli) VALUES (?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setDate(1, commande.getDateCmd());
		statement.setLong(2, commande.getCodCli());

		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowInserted;
	}
	@Override
	public List<Commande> listAllCommandes() throws SQLException {
		List<Commande> listCommande = new ArrayList<>();
		
		String sql = "SELECT * FROM commande";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int codCli = resultSet.getInt("cod_cli");
			Date dateCmd = resultSet.getDate("date_cmd");
			int numCmd = resultSet.getInt("num_cmd");
			
			
			
			Commande commande = new Commande(numCmd, dateCmd, codCli);
			listCommande.add(commande);
			
		}
		
		resultSet.close();
		statement.close();
		
		//disconnect();
		
		return listCommande;
	}
	@Override
	public boolean deleteCommande(Commande commande) throws SQLException {
		String sql = "DELETE FROM commande where num_cmd = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, commande.getNumCmd());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowDeleted;		
	}
	@Override
	public boolean updateCommande(Commande commande) throws SQLException {
		String sql = "UPDATE commande SET date_cmd = ?, cod_cli = ?";
		sql += " WHERE num_cmd = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setDate(1, commande.getDateCmd());
		statement.setLong(2, commande.getCodCli());
		statement.setLong(3, commande.getNumCmd());
	
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowUpdated;		
	}
	@Override
	public Commande getCommande(int id) throws SQLException {
		Commande commande = null;
		String sql = "SELECT * FROM commande WHERE num_cmd = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			int codCli = resultSet.getInt("cod_cli");
			Date dateCmd = resultSet.getDate("date_cmd");
			int numCmd = resultSet.getInt("num_cmd");
			
			commande = new Commande(numCmd, dateCmd, codCli);
		}
		
		resultSet.close();
		statement.close();
		
		return commande;
				
	}
	}