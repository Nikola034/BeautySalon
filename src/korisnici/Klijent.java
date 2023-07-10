package korisnici;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entitetiSalona.KozmetickiSalon;
import enumi.Pol;

public class Klijent extends Korisnik{
	
	private double stanje;
	private double potrosnja;
	private boolean pravoNaKarticuLojalnosti;
	
	public Klijent() 
	{
		super();
		this.stanje = 0;
		this.pravoNaKarticuLojalnosti = false;
		this.potrosnja = 0;
	}
	
	public Klijent(String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, double stanje, double potrosnja, Boolean pravo) 
	{
		super(SledeciID(KozmetickiSalon.klijenti), ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka);
		this.stanje = stanje;
		this.pravoNaKarticuLojalnosti = pravo;
		this.potrosnja = 0;
	}
	
	public Klijent(int id, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, double stanje, double potrosnja, Boolean pravo) 
	{
		super(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka);
		this.stanje = stanje;
		this.pravoNaKarticuLojalnosti = pravo;
		this.potrosnja = potrosnja;
	}

	public double getStanje() {
		return stanje;
	}
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public boolean getPravoNaKarticuLojalnosti() {
		return pravoNaKarticuLojalnosti;
	}
	public void setPravoNaKarticuLojalnosti(boolean pravoNaKarticuLojalnosti) {
		this.pravoNaKarticuLojalnosti = pravoNaKarticuLojalnosti;
	}
	
	public double getPotrosnja() {
		return potrosnja;
	}
	public void setPotrosnja(double potrosnja) {
		this.potrosnja = potrosnja;
	}
	
	public void odobriKarticuLojalnosti() 
	{
		this.pravoNaKarticuLojalnosti = true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "," + this.stanje + "," + this.potrosnja + "," + this.pravoNaKarticuLojalnosti;
	}
	
	public static List<Klijent> UcitajKlijente()
	{
		List<Klijent> klijenti = new ArrayList<Klijent>();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/klijenti.csv"), "utf-8"));
			String row;
	    	while((row = in.readLine()) != null) {
	    		String[] words = row.split(",");
	    		int id = Integer.parseInt(words[0]);
	    		String ime = words[1];
	    		String prezime = words[2];
	    		Pol pol = Pol.valueOf(words[3]);
	    		String telefon = words[4];
	    		String adresa = words[5];
	    		String korisnickoIme = words[6];
	    		String lozinka = words[7];
	    		double stanje = Double.parseDouble(words[8]);
	    		double potrosnja = Double.parseDouble(words[9]);
	    		Boolean pravo = Boolean.valueOf(words[10]);
	    		Klijent novi = new Klijent(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, stanje, potrosnja, pravo);
	    		klijenti.add(novi);
	    	}
	      
	      in.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Datoteka nije pronadjena!");
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Doslo je do greske prilikom otvaranja datoteke!");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doslo je do greske!");
		}
		
		return klijenti;
	}
	
	public static void SacuvajKlijente(List<Klijent> klijenti) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/klijenti.csv"), "utf-8"));
			for (Klijent klijent : klijenti) {
				out.println(klijent);
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Datoteka nije pronadjena!");
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Doslo je do greske prilikom otvaranja datoteke!");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doslo je do greske!");
		}
	}
	
	public static int SledeciID(List<Klijent> klijenti) 
	{
		if(!klijenti.isEmpty()) 
		{
			int max = klijenti.get(0).getId();
			
			for (Klijent klijent : klijenti) {
				if(klijent.getId() > max) 
				{
					max = klijent.getId();
				}
			}
			
			return max + 1;
		}
		return 1;
	}

	public static Klijent NadjiPoID(int id, List<Klijent> lista) 
	{
		for (Klijent klijent : lista) {
			if(klijent.getId() == id) return klijent;
		}
		return null;
	}
}
