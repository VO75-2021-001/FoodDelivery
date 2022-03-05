package it.prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TabellaTestDatabase {
	public List<TabellaTest> getAllTabellaUtenti() {
		List<TabellaTest> lista = new ArrayList<>();
		try {
			 //carichiamo il driver
			Class.forName("com.mysql.jdbc.Driver");
			//Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NOME_DATABASE", "USERNAME", "PASSWORD");
			//creaimo lo statement
			Statement statement = connection.createStatement();
			//creiamo la string con la query da inviare (cambiare nome_tabella con quella su cui dovete lavorare)
			String query = "SELECT * FROM nome_tabella";
			//inviamo la query al database e salviamo i risultati
			ResultSet resultSet = statement.executeQuery(query);
			//leggiamo tutti i dati
			//creiamo i sinsogli oggeti e li aggiungiamo alla lista
			while(resultSet.next()) {
				//leggo i sindoli dati, questo sara da sistemare per ognugno di voi
				int idTabella = resultSet.getInt("nome_colonna");
				String campoUno = resultSet.getString("nome_colonna");
				String campoDue = resultSet.getString("nome_colonna");
				//genero l'oggetto usando i dati letti
				TabellaTest tabTest = new TabellaTest(idTabella,campoUno,campoDue);
				//aggiuno l'oggetto creatto alla lista
				lista.add(tabTest);
			}
			//mando in return la lista con tutti gli oggetti
			return lista;
		} catch (ClassNotFoundException e) {
			//mando in return la lista con tutti gli oggetti
			return lista;
		} catch (SQLException e) {
			//mando in return la lista con tutti gli oggetti
			return lista;
		}
	}
	
	public TabellaTest getFromId(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NOME_DATABASE", "USERNAME", "PASSWORD");
			//genero la stringa di query
			String query = "SELECT * FROM nome_tabella WHERE colonna_id = ?";
			//creo il preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//imposto i valori dei vari ? presenti nella query (1 in questo caso)
			preparedStatement.setInt(1, id);
			//inviamo la query al database e salviamo i risultati
			ResultSet resultSet = preparedStatement.executeQuery();
			//mi sposto sulla prima (e in teoria anche unica) riga letta
			resultSet.next();
			//leggo i sindoli dati, questo sara da sistemare per ognugno di voi
			int idTabella = resultSet.getInt("nome_colonna");
			String campoUno = resultSet.getString("nome_colonna");
			String campoDue = resultSet.getString("nome_colonna");
			//genero l'oggetto usando i dati letti
			TabellaTest tabTest = new TabellaTest(idTabella,campoUno,campoDue);
			//mando in return l'oggetto letto
			return tabTest;
		} catch (ClassNotFoundException e) {
			//mando in return la lista con tutti gli oggetti
			return null;
		} catch (SQLException e) {
			//mando in return la lista con tutti gli oggetti
			return null;
		}
	}
}
