package entitetiSalona;
import java.awt.color.ICC_ColorSpace;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enumi.Pol;
import korisnici.Klijent;
import korisnici.Kozmeticar;
import korisnici.Menadzer;
import korisnici.Recepcioner;

public class KozmetickiSalon {

	public static String Naziv = "Moj Salon";
	public static List<String> RaspoloziviTermini = new ArrayList<String>(Arrays.asList("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
			"17:00", "18:00", "19:00"));
	
	public static List<Menadzer> menadzeri = Menadzer.UcitajMenadzere();
	public static List<Kozmeticar> kozmeticari = Kozmeticar.UcitajKozmeticare();
	public static List<Recepcioner> recepcioneri = Recepcioner.UcitajRecepcionere();	
	public static List<Klijent> klijenti = Klijent.UcitajKlijente();
	public static List<Tretman> tretmani = Tretman.UcitajTretmane();
	public static List<ZakazanTretman> zakazaniTretmani = ZakazanTretman.UcitajZakazaneTretmane();
	
	private double UslovZaKarticuLojalnosti;
	
	public static double getUslov() 
	{
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/uslov.csv"), "utf-8"));
			String row;
	    	while((row = in.readLine()) != null) {
	    		return Double.parseDouble(row);
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
		return -1;
	}
	
	public static void setUslov(double uslov) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/uslov.csv"), "utf-8"));
			out.println(uslov);
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
	
	public static int getBonus() 
	{
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/bonus.csv"), "utf-8"));
			String row;
	    	while((row = in.readLine()) != null) {
	    		return Integer.parseInt(row);
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
		return -1;
	}
	
	public static void setBonus(int nacin) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/bonus.csv"), "utf-8"));
			out.println(nacin);
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
}
