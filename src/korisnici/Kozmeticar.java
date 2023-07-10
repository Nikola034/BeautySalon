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

public class Kozmeticar extends Zaposleni{
	
	private List<Integer> obucenZaTretmane;

	public Kozmeticar() 
	{
		super();
		this.obucenZaTretmane = null;
	}
	
	public Kozmeticar(String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus, List<Integer> obucenZaTretmane)
	{
		super(SledeciID(KozmetickiSalon.kozmeticari), ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
		this.obucenZaTretmane = obucenZaTretmane;
	}
	
	public Kozmeticar(int id, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme, String lozinka, int nivoStrucneSpreme, int staz, double koeficijent, double osnova, double bonus, List<Integer> obucenZaTretmane)
	{
		super(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus);
		this.obucenZaTretmane = obucenZaTretmane;
	}
	
	public List<Integer> getObucenZaTretmane() {
		return obucenZaTretmane;
	}
	public void setObucenZaTretmane(List<Integer> obucenZaTretmane) {
		this.obucenZaTretmane = obucenZaTretmane;
	}
	public void dodajTretman(int idTretmana) 
	{
		this.obucenZaTretmane.add(idTretmana);
	}
	
	private String PretvoriTretmane() 
	{
		StringBuilder stringBuilder = new StringBuilder("");
		for (Integer tipTretmana : obucenZaTretmane) {
			stringBuilder.append(tipTretmana.toString()).append("-");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "," + PretvoriTretmane();
	}
	
	public static List<Kozmeticar> UcitajKozmeticare()
	{
		List<Kozmeticar> kozmeticari = new ArrayList<Kozmeticar>();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/kozmeticari.csv"), "utf-8"));
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
	    		String[] obucensStrings = words[13].split("-");
	    		List<Integer> obucenZaTretmane = new ArrayList<Integer>();
	    		for (String str : obucensStrings) {
					obucenZaTretmane.add(Integer.parseInt(str));
				}
	    		Kozmeticar novi = new Kozmeticar(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, nivoStrucneSpreme, staz, koeficijent, osnova, bonus, obucenZaTretmane);
	    		kozmeticari.add(novi);
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
		
		return kozmeticari;
	}
	
	public static void SacuvajKozmeticare(List<Kozmeticar> kozmeticari) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/kozmeticari.csv"), "utf-8"));
			for (Kozmeticar kozmeticar : kozmeticari) {
				out.println(kozmeticar);
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
	
	public static int SledeciID(List<Kozmeticar> kozmeticari) 
	{
		if(!kozmeticari.isEmpty()) 
		{
			int max = kozmeticari.get(0).getId();
			
			for (Kozmeticar kozmeticar : kozmeticari) {
				if(kozmeticar.getId() > max) 
				{
					max = kozmeticar.getId();
				}
			}
			
			return max + 1;
		}
		return 1;
	}
	
	public static Kozmeticar NadjiPoID(int id, List<Kozmeticar> lista) 
	{
		for (Kozmeticar kozmeticar : lista) {
			if(kozmeticar.getId() == id) return kozmeticar;
		}
		return null;
	}
}
