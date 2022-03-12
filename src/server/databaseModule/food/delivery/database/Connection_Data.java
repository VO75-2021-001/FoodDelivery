package food.delivery.database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connection_Data {

	public List<Prodotto> getAllProdotto() {
		List<Prodotto> lista = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fooddelivery", "root", "12345678");
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM prodotto";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int IDProdotto = rs.getInt("IDProdotto");
				String NomeProdotto = rs.getString("NomeProdotto");
				String CodiceProdotto = rs.getString("CodiceProdotto");
				Double Prezzo = rs.getDouble("Prezzo");
				boolean Disponibilita = rs.getBoolean("Disponibilita");
				int Fornitore = rs.getInt("Fornitore");
				Prodotto oggetto = new Prodotto(IDProdotto, NomeProdotto, CodiceProdotto, 
						              Prezzo, Disponibilita, Fornitore);
				
				lista.add(oggetto);
				
			}
			conn.close();
			
			return lista;
			
			} catch(ClassNotFoundException err) {
				err.printStackTrace();
			return lista;
			
		    } catch(SQLException err) {
		    	err.printStackTrace();
		    return lista;
	  }
	}
	public Prodotto getFromId(int id) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fooddelivery", "root", "12345678");
		String query = "SELECT * FROM prodotto WHERE IDProdotto = ?";
		PreparedStatement Pstmt = conn.prepareStatement(query);
		Pstmt.setInt(1, id);
		ResultSet rs = Pstmt.executeQuery();
		rs.next();
		int IDProdotto = rs.getInt("IDProdotto");
		String NomeProdotto = rs.getString("NomeProdotto");
		String CodiceProdotto = rs.getString("CodiceProdotto");
		Double Prezzo = rs.getDouble("Prezzo");
		boolean Disponibilita = rs.getBoolean("Disponibilita");
		int Fornitore = rs.getInt("Fornitore");
		Prodotto oggetto = new Prodotto(IDProdotto, NomeProdotto, CodiceProdotto, 
	              Prezzo, Disponibilita, Fornitore);
		conn.close();
		return oggetto;
		
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
		        return null;
	    } catch(SQLException err) {
	    	err.printStackTrace();
	    	    return null;
  }
 }   
	public boolean InsertQuery(Prodotto p) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fooddelivery", "root", "12345678");		
		String query = "INSERT INTO Prodotto(NomeProdotto, CodiceProdotto) VALUES (?, ?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, p.getNomeProdotto());
		stmt.setString(2, p.getCodiceProdotto());
		int b = stmt.executeUpdate();
		conn.close();
		if(b > 0) {
			return true;
		}
		else {
			return false;
		}
	} catch(ClassNotFoundException err) {
		err.printStackTrace();
		return false;
    } catch(SQLException err) {
    	err.printStackTrace();
    	return false;
	}
  }
	public void UpdateQuery() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fooddelivery", "root", "12345678");		
		String query = "UPDATE Prodotto SET NomeProdotto = 'Pasta' WHERE NomeProdotto = 'Sushi'";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		conn.close();
	} catch(ClassNotFoundException err) {
		err.printStackTrace();
    } catch(SQLException err) {
    	err.printStackTrace();
	}
  }
	public void DeleteQuery() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fooddelivery", "root", "12345678");		
			String query = "DELETE FROM Prodotto WHERE NomeProdotto = 'Pasta'";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
	    } catch(SQLException err) {
	    	err.printStackTrace();
		}
	  }

	}
	

