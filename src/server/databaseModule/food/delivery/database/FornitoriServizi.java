package food.delivery.database;
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
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return null;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return null;
        }
    }
    public boolean insertfornitoriservizi(int infornitore,int inservizio){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "INSERT INTO fornitoriservizi (IDFornitore,IDServizio) VALUES IDFornitore = ? and IDServizio = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, infornitore);
            preparedStatement.setInt(2, inservizio);
            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
        
    }

    public boolean updateIds(int upidfornitore,int upidservizio,int pk,int spk){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDFornitore = ? AND IDServizio =? WHERE IDFornitore = ? and IDServizio = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidfornitore);
            preparedStatement.setInt(2, upidservizio);
            preparedStatement.setInt(3, pk);
            preparedStatement.setInt(4, spk);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
        
    }
    public boolean updateIds(int upidfornitore,int upidservizio){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDFornitore = ? AND IDServizio =?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidfornitore);
            preparedStatement.setInt(2, upidservizio);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
        
    }
    public boolean updateIdFrn(int upidfornitore){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDFornitore = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidfornitore);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
    }
    public boolean updateIdFrn(int upidfornitore,int idfornitore){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDFornitore = ? WHERE IDFornitore = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidfornitore);
            preparedStatement.setInt(2, idfornitore);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
    }
    public boolean updateIdFrn(int upidfornitore,int idfornitore,int idservizio){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDFornitore = ? WHERE IDFornitore = ? and IDServizio = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidfornitore);
            preparedStatement.setInt(2, idfornitore);
            preparedStatement.setInt(3, idservizio);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
    }
    public boolean updateIdSrv(int upidservizio){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDServizio = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidservizio);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
        
    }
    public boolean updateIdSrv(int upidservizio,int idservizio){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDServizio = ? WHERE IDFornitore = ? and IDServizio = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidservizio);
            preparedStatement.setInt(2, idservizio);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
    }
    public boolean updateIdSrv(int upidservizio,int idfornitore,int idservizio){
        int result = 0;
        try {
             //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "UPDATE fornitoriservizi SET IDServizio = ? WHERE IDFornitore = ? and IDServizio = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, upidservizio);
            preparedStatement.setInt(2, idfornitore);
            preparedStatement.setInt(3, idservizio);

            result = preparedStatement.executeUpdate();

            if(result > 0){
                return true;
            }else{
                return false;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
    }
    public boolean deleteFromId(int pk,int spk) {
        int result = 0;
        try {
            //carichiamo il driver
           Class.forName("com.mysql.jdbc.Driver");
           //Creiamo l'oggetto di connesione (cambiare i dati in maiuscolo con i vostri)
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "servizio", "servizio");
            //genero la stringa di query
            String query = "DELETE FROM fornitoriservizi WHERE IDFornitore = ? and IDServizio = ?";
            //creo il preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //imposto i valori dei vari ? presenti nella query (1 in questo caso)
            preparedStatement.setInt(1, pk);
            preparedStatement.setInt(2, spk);
            result = preparedStatement.executeUpdate();
            if(result > 0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException e: " +  e);
            //mando in return la lista con tutti gli oggetti
            return false;
        }
    }

}