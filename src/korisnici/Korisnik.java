package korisnici;
import entitetiSalona.KozmetickiSalon;
import enumi.Pol;

public abstract class Korisnik {
	
	private int id;
	private String ime;
	private String prezime;
	private Pol pol;
	private String telefon;
	private String adresa;
	private String korisnickoIme;
	private String lozinka;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Pol getPol() {
		return pol;
	}
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public Korisnik() {
		this.id = -1;
		this.ime = "";
		this.prezime = "";
		this.pol = null;
		this.telefon = "";
		this.adresa = "";
		this.korisnickoIme = "";
		this.lozinka = "";
	}
	
	public Korisnik(int id, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka) 
	{
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.telefon = telefon;
		this.adresa = adresa;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "," + this.ime + "," + this.prezime + "," + this.pol + "," + this.telefon + "," + this.adresa + "," + this.korisnickoIme + "," + this.lozinka;
	}
	
}
