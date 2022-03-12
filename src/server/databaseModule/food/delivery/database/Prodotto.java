package food.delivery.database;

public class Prodotto {
	
	private int IDProdotto;
	private String NomeProdotto;
	private String CodiceProdotto;
	private Double Prezzo;
	private boolean Disponibilita;
	private int Fornitore;
	
	public Prodotto(int IDProdotto, String NomeProdotto, String CodiceProdotto, 
			   Double Prezzo, boolean Disponibilita, int Fornitore) {
		
		this.IDProdotto = IDProdotto;
		this.NomeProdotto = NomeProdotto;
		this.CodiceProdotto = CodiceProdotto;
		this.Prezzo = Prezzo;
		this.Disponibilita = Disponibilita;
		this.Fornitore = Fornitore;
	}
	
	public int getIDProdotto() {
		return IDProdotto;
	}
	public String getNomeProdotto() {
		return NomeProdotto;
	}
	public String getCodiceProdotto() {
		return CodiceProdotto;
	}
	public Double getPrezzo() {
		return Prezzo;
	}
	public boolean getDisponibilita() {
		return Disponibilita;
	}
	public int getFornitore() {
		return Fornitore;
	}
	public void setIDProdotto(int IDProdotto) {
		this.IDProdotto = IDProdotto;
	}
	public void setNomeProdotto(String NomeProdotto) {
		this.NomeProdotto = NomeProdotto;
	}
	public void setCodiceProdotto(String CodiceProdotto) {
		this.CodiceProdotto = CodiceProdotto;
	}
	public void setPrezzo(Double Prezzo) {
		this.Prezzo = Prezzo;
	}
	public void setDisponibilita(boolean Disponibilita) {
		this.Disponibilita = Disponibilita;
	}
	public void setFornitore(int Fornitore) {
		this.Fornitore = Fornitore;
	}

	@Override
	public String toString() {
		return "Map [IDProdotto=" + IDProdotto + ", NomeProdotto=" + NomeProdotto + ", CodiceProdotto=" + CodiceProdotto
				+ ", Prezzo=" + Prezzo + ", Disponibilita=" + Disponibilita + ", Fornitore=" + Fornitore + "]";
	}
	
	

}
