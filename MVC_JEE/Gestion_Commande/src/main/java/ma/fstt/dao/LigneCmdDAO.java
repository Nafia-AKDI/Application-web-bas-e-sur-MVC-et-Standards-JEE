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
import ma.fstt.entities.LigneCmd;
import ma.fstt.services.CommandeRepository;
import ma.fstt.services.LigneCmdRepository;

public  class LigneCmdDAO implements LigneCmdRepository {
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
	public boolean insertLigneCmd(LigneCmd ligneCmd) throws SQLException {
		String sql = "INSERT INTO ligne_cmd ( qte_cmd, cod_art, num_cmd) VALUES (?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, ligneCmd.getQteCmd());
		statement.setLong(2, ligneCmd.getCodArt());
		statement.setLong(3, ligneCmd.getNumCmd());

		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowInserted;
	}
	@Override
	public List<LigneCmd> listAllLigneCmds() throws SQLException {
		List<LigneCmd> listLigneCmd = new ArrayList<>();
		
		String sql = "SELECT * FROM ligne_cmd";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int numLigne = resultSet.getInt("num_ligne");
			int qteCmd = resultSet.getInt("qte_cmd");
			int codArt = resultSet.getInt("cod_art");
			int numCmd = resultSet.getInt("num_cmd");
			System.out.print(resultSet.getInt("num_ligne"));

			
			
			
			LigneCmd ligneCmd = new LigneCmd(numLigne, qteCmd, codArt, numCmd);

			listLigneCmd.add(ligneCmd);
			
		}
		
		resultSet.close();
		statement.close();
		
		//disconnect();
		
		return listLigneCmd;
	}
	@Override
	public boolean deleteLigneCmd(LigneCmd ligneCmd) throws SQLException {
		String sql = "DELETE FROM ligne_cmd where num_ligne = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, ligneCmd.getNumLigne());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowDeleted;		
	}
	@Override
	public boolean updateLigneCmd(LigneCmd ligneCmd) throws SQLException {
		String sql = "UPDATE ligne_cmd SET qte_cmd = ?, cod_art = ?, num_cmd = ?";
		sql += " WHERE num_ligne = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, ligneCmd.getQteCmd());
		statement.setLong(2, ligneCmd.getCodArt());
		statement.setLong(3, ligneCmd.getNumCmd());
		statement.setLong(4, ligneCmd.getNumLigne());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowUpdated;		
	}
	@Override
	public LigneCmd getLigneCmd(int id) throws SQLException {
		LigneCmd ligneCmd = null;
		String sql = "SELECT * FROM ligne_cmd WHERE num_ligne = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			int qteCmd = resultSet.getInt("qte_cmd");
			int codArt = resultSet.getInt("cod_art");
			int numCmd = resultSet.getInt("num_cmd");
			
			
			ligneCmd = new LigneCmd( qteCmd, codArt, numCmd);

		}
		
		resultSet.close();
		statement.close();
		
		return ligneCmd;
				
	}
	}