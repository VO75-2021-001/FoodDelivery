package it.tabelle;
import java.sql.*;
import java.util.*;

public class FornitoriServizi {
    public List <TabellaFornitoriServizi> getallFornitoriServizi(){
        List<TabellaFornitoriServizi> lista = new ArrayList<>();
        try {
            //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
           //creaimo lo statement
           Statement statement = connection.createStatement();
           //creiamo la string con la query da inviare (cambiare nome_tabella con quella su cui dovete lavorare)
           String query = "SELECT * FROM FornitoriServizi";
           //inviamo la query al database e salviamo i risultati
           ResultSet resultSet = statement.executeQuery(query);
           //leggiamo tutti i dati
           //creiamo i sinsogli oggeti e li aggiungiamo alla lista
           while(resultSet.next()) {
               //leggo i sindoli dati, questo sara da sistemare per ognugno di voi
               int campoUno = resultSet.getInt("IDFornitore");
               int campoDue = resultSet.getInt("IDServizio");
               //genero l'oggetto usando i dati letti
               TabellaFornitoriServizi tabOrdini = new TabellaFornitoriServizi(campoUno,campoDue);
               //aggiuno l'oggetto creatto alla lista
               lista.add(tabOrdini);
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
    public TabellaFornitoriServizi getFromId(int pk,int spk) {
        try {
            //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "SELECT * FROM fornitoriservizi WHERE IDFornitore = ? and IDServizio = ?";
            //creo il preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //imposto i valori dei vari ? presenti nella query (1 in questo caso)
            preparedStatement.setInt(1, pk);
            preparedStatement.setInt(2, spk);
            //inviamo la query al database e salviamo i risultati
            ResultSet resultSet = preparedStatement.executeQuery();
            //mi sposto sulla prima (e in teoria anche unica) riga letta
            resultSet.next();
            //leggo i sindoli dati, questo sara da sistemare per ognugno di voi
            int campoUno = resultSet.getInt("IDFornitore");
            int campoDue = resultSet.getInt("IDServizio");
            //genero l'oggetto usando i dati letti
            TabellaFornitoriServizi tabFornitoriServizi = new TabellaFornitoriServizi(campoUno,campoDue);
            //mando in return l'oggetto letto
            return tabFornitoriServizi;
        } catch (ClassNotFoundException e) {
            System.out.println(" e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return null;
        } catch (SQLException e) {
            System.out.println(" e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return null;
        }
    }
}