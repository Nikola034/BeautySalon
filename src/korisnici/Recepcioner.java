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

public class Recepcioner extends Zaposleni{

	public Recepcioner() 
	{
		super();
	}
	
	public Recepcioner(String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus) 
	{
		super(SledeciID(KozmetickiSalon.recepcioneri), ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
	}
	
	public Recepcioner(int id, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus) 
	{
		super(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static List<Recepcioner> UcitajRecepcionere()
	{
		List<Recepcioner> recepcioneri = new ArrayList<Recepcioner>();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/recepcioneri.csv"), "utf-8"));
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
	    		int nivoStrucneSpreme = Integer.parseInt(words[8]);
	    		int staz = Integer.parseInt(words[9]);
	    		double koeficijent = Double.parseDouble(words[10]);
	    		double osnova = Double.parseDouble(words[11]);
	    		double bonus = Double.parseDouble(words[12]);
	    		Recepcioner novi = new Recepcioner(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
	    		recepcioneri.add(novi);
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
		
		return recepcioneri;
	}
	
	public static void SacuvajRecepcionere(List<Recepcioner> recepcioneri) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/recepcioneri.csv"), "utf-8"));
			for (Recepcioner recepcioner : recepcioneri) {
				out.println(recepcioner);
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
	
	public static int SledeciID(List<Recepcioner> recepcioneri) 
	{
		if(!recepcioneri.isEmpty()) 
		{
			int max = recepcioneri.get(0).getId();
			
			for (Recepcioner recepcioner : recepcioneri) {
				if(recepcioner.getId() > max) 
				{
					max = recepcioner.getId();
				}
			}
			
			return max + 1;
		}
		return 1;
	}
	
	public static Recepcioner NadjiPoID(int id, List<Recepcioner> lista) 
	{
		for (Recepcioner recepcioner : lista) {
			if(recepcioner.getId() == id) return recepcioner;
		}
		return null;
	}
}
