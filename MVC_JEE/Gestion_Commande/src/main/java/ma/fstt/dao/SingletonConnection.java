package ma.fstt.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client; 
public class SingletonConnection { 
 
private static Connection connection; 
// Un blocs static s’exécute une seule fois lors du chargement  de la classe
// et ne s’exécute pas lors des instanciation de la classe ,ils sont lancés avant l'appel des constructeurs.
 
static{ 
 
 try { 
 Class.forName("com.mysql.cj.jdbc.Driver"); 
 connection= 
DriverManager.getConnection("jdbc:mysql://localhost:3306/gestcmd"
,"root",""); 
 } catch (Exception e) { 
 // TODO Auto-generated catch block
 e.printStackTrace(); 
 } 
 } 
public static Connection getConnection() { 
 return connection; 
 } 

public static void test() throws SQLException {
	List<Client> listClient = new ArrayList<>();
	Connection con=SingletonConnection.getConnection();
	String sql = "SELECT * FROM client";

	Statement statement =  con.createStatement();
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
		System.out.println(client);
	}
	
	resultSet.close();
	statement.close();	
	System.out.println(listClient);
}
 


//public static void main(String[] args)  {
//
//	try {
//		SingletonConnection.test();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
}
