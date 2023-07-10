package entitetiSalona;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import korisnici.Menadzer;

public class Tretman {

	private int id;
	private String naziv;
	private int trajanje;
	private double cena;
	
	public Tretman() 
	{
		this.id = -1;
		this.naziv = "";
		this.trajanje = -1;
		this.cena = -1;
	}
	
	public Tretman(String naziv, int trajanje, double cena) 
	{
		this.id = SledeciID(KozmetickiSalon.tretmani);
		this.naziv = naziv;
		this.trajanje = trajanje;
		this.cena = cena;
	}
	
	public Tretman(int id, String naziv, int trajanje, double cena) 
	{
		this.id = id;
		this.naziv = naziv;
		this.trajanje = trajanje;
		this.cena = cena;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public int getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}
	
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "," + this.naziv + "," + this.trajanje + "," + this.cena;
	}
	
	public static List<Tretman> UcitajTretmane() 
	{
		List<Tretman> tretmani = new ArrayList<Tretman>();
		 
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/tretmani.csv"), "utf-8"));
			String row;
	    	while((row = in.readLine()) != null) {
	    		String[] words = row.split(",");
	    		int id = Integer.parseInt(words[0]);
	    		String naziv = words[1];
	    		int trajanje = Integer.parseInt(words[2]);
	    		double cena = Double.parseDouble(words[3]); 
	    		Tretman novi = new Tretman(id,  naziv, trajanje, cena);
	    		tretmani.add(novi);
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
		
		return tretmani;
	}
	
	public static void SacuvajTretmane(List<Tretman> tretmani) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/tretmani.csv"), "utf-8"));
			for (Tretman tretman : tretmani) {
				out.println(tretman);
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
	
	public static int SledeciID(List<Tretman> tretmani) 
	{
		if(!tretmani.isEmpty()) 
		{
			int max = tretmani.get(0).getId();
			
			for (Tretman tretman : tretmani) {
				if(tretman.getId() > max) 
				{
					max = tretman.getId();
				}
			}
			
			return max + 1;
		}
		return 1;
	}
	
	public static Tretman NadjiPoID(int id, List<Tretman> lista) 
	{
		for (Tretman tretman : lista) {
			if(tretman.getId() == id) return tretman;
		}
		return null;
	}
}
