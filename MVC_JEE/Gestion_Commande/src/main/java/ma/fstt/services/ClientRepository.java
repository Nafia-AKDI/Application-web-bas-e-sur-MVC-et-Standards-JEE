package ma.fstt.services;



import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository {
	
	public boolean insertClient(Client client) throws SQLException;
	public boolean deleteClient(Client client) throws SQLException;
	public List<Client> listAllClients() throws SQLException;
	public boolean updateClient(Client client) throws SQLException;
	Client getClient(int id) throws SQLException;



	
}
