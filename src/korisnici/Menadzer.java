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

public class Menadzer extends Zaposleni{
	
	public Menadzer() 
	{
		super();
	}
	
	public Menadzer(String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus) 
	{
		super(SledeciID(KozmetickiSalon.menadzeri), ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
	}
	
	public Menadzer(int id, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus) 
	{
		super(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static List<Menadzer> UcitajMenadzere()
	{
		List<Menadzer> menadzeri = new ArrayList<Menadzer>();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/menadzeri.csv"), "utf-8"));
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
	    		Menadzer novi = new Menadzer(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
	    		menadzeri.add(novi);
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
		
		return menadzeri;
	}
	
	public static void SacuvajMenadzere(List<Menadzer> menadzeri) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/menadzeri.csv"), "utf-8"));
			for (Menadzer menadzer : menadzeri) {
				out.println(menadzer);
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
	
	public static int SledeciID(List<Menadzer> menadzeri) 
	{
		if(!menadzeri.isEmpty()) 
		{
			int max = menadzeri.get(0).getId();
			
			for (Menadzer menadzer : menadzeri) {
				if(menadzer.getId() > max) 
				{
					max = menadzer.getId();
				}
			}
			
			return max + 1;
		}
		return 1;
	}
	
	public static Menadzer NadjiPoID(int id, List<Menadzer> lista) 
	{
		for (Menadzer menadzer : lista) {
			if(menadzer.getId() == id) return menadzer;
		}
		return null;
	}
}
