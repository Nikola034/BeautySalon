package korisnici;
import enumi.Pol;

public abstract class Zaposleni extends Korisnik {
	
	private int nivoStrucneSpreme;
	private int staz;
	private double koeficijent;
	private double osnova;
	private double bonus;
	private double plata;
	
	public Zaposleni() 
	{
		super();
		this.nivoStrucneSpreme = 0;
		this.staz = 0;
		this.koeficijent = 0;
		this.osnova = 0;
		this.bonus = 0;
		this.plata = 0;
	}
	
	public Zaposleni(int id, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus) 
	{
		super(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka);
		this.nivoStrucneSpreme = nivoStrucneSpreme;
		this.staz = staz;
		this.koeficijent = koeficijent;
		this.osnova = osnova;
		this.bonus = bonus;
		this.plata = this.osnova + (this.osnova / 3) * koeficijent + this.osnova * 1 / 7 * this.koeficijent + this.bonus * 1.3;
	}
	
	public int getNivoStrucneSpreme() {
		return nivoStrucneSpreme;
	}
	public void setNivoStrucneSpreme(int nivoStrucneSpreme) {
		this.nivoStrucneSpreme = nivoStrucneSpreme;
	}
	
	public int getStaz() {
		return staz;
	}
	public void setStaz(int staz) {
		this.staz = staz;
	}
	
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	public void racunajPlatu() 
	{
		this.plata = this.osnova + (this.osnova / 3) * koeficijent + this.osnova * 1 / 7 * this.koeficijent + this.bonus * 1.3;
	}
	
	public double getKoeficijent() {
		return koeficijent;
	}
	public void setKoeficijent(double koeficijent) {
		this.koeficijent = koeficijent;
	}

	public double getOsnova() {
		return osnova;
	}
	public void setOsnova(double osnova) {
		this.osnova = osnova;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "," + this.nivoStrucneSpreme + "," + this.staz + "," + this.koeficijent + "," + this.osnova + "," + this.bonus;
	}
	
}
