package food.delivery.database;

public class TabellaFornitoriServizi {
    private int IDFornitore;
    private int IDServizio;
    
    public TabellaFornitoriServizi(int campo1,int campo2){
        this.setIDFornitore(campo1);
        this.setIDServizio(campo2);
    }

    public int getIDFornitore() {
        return IDFornitore;
    }

    public void setIDFornitore(int iDFornitore) {
        this.IDFornitore = iDFornitore;
    }

    public int getIDServizio() {
        return IDServizio;
    }

    public void setIDServizio(int iDServizio) {
        this.IDServizio = iDServizio;
    }

    @Override
    public String toString() {
        return "{" +
            " IDFornitore='" + getIDFornitore() + "'" +
            ", IDServizio='" + getIDServizio() + "'" +
            "}";
    }

}