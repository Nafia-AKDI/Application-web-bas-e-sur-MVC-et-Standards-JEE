package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.services.ClientRepository;

public  class ClientDAO implements ClientRepository {
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
	public boolean insertClient(Client client) throws SQLException {
		String sql = "INSERT INTO client ( adr_cli, nom_cli, pre_cli, tel_cli, ville_cli) VALUES (?, ?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, client.getAdrCli());
		statement.setString(2, client.getNomCli());
		statement.setString(3, client.getPreCli());
		statement.setString(4, client.getTelCli());
		statement.setString(5, client.getVilleCli());
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowInserted;
	}
	@Override
	public List<Client> listAllClients() throws SQLException {
		List<Client> listClient = new ArrayList<>();
		
		String sql = "SELECT * FROM client";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int codCli = resultSet.getInt("cod_cli");
			String adrCli = resultSet.getString("adr_cli");
			String nomCli = resultSet.getString("nom_cli");
			String preCli = resultSet.getString("pre_cli");
			String telCli = resultSet.getString("tel_cli");
			String villeCli = resultSet.getString("ville_cli");
			
			
			Client client = new Client(codCli, nomCli, preCli, adrCli, telCli, villeCli);
			listClient.add(client);
			
		}
		
		resultSet.close();
		statement.close();
		
		//disconnect();
		
		return listClient;
	}
	@Override
	public boolean deleteClient(Client client) throws SQLException {
		String sql = "DELETE FROM client where cod_cli = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, client.getCodCli());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowDeleted;		
	}
	@Override
	public boolean updateClient(Client client) throws SQLException {
		String sql = "UPDATE client SET adr_cli = ?, nom_cli = ?, pre_cli = ?, tel_cli = ?, ville_cli = ?";
		sql += " WHERE cod_cli = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, client.getAdrCli());
		statement.setString(2, client.getNomCli());
		statement.setString(3, client.getPreCli());
		statement.setString(4, client.getTelCli());
		statement.setString(5, client.getVilleCli());
		statement.setLong(6, client.getCodCli());
	
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowUpdated;		
	}
	@Override
	public Client getClient(int id) throws SQLException {
		Client client = null;
		String sql = "SELECT * FROM client WHERE cod_Cli = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			int codCli = resultSet.getInt("cod_cli");
			String adrCli = resultSet.getString("adr_cli");
			String nomCli = resultSet.getString("nom_cli");
			String preCli = resultSet.getString("pre_cli");
			String telCli = resultSet.getString("tel_cli");
			String villeCli = resultSet.getString("ville_cli");
			
			client = new Client(codCli, nomCli, preCli, adrCli, telCli, villeCli);
		}
		
		resultSet.close();
		statement.close();
		
		return client
				;
	}
	}