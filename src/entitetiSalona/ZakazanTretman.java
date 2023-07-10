package entitetiSalona;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumi.Stanje;
import funkcionalnosti.Funkcionalnost;

public class ZakazanTretman{

	private int id;
	private int idKlijenta;
	private int idKozmeticara;
	private int idTretmana;
	private Date vreme;
	private Stanje stanje;
	
	public ZakazanTretman() 
	{
		this.id = -1;
		this.idKlijenta = -1;
		this.idKozmeticara = -1;
		this.idTretmana = -1;
		this.vreme = new Date(1970,1,1);
		this.stanje = null;
	}
	
	public ZakazanTretman(int idKlijenta, int idKozmeticara, int idTretmana, Date vreme, Stanje stanje) 
	{
		this.id = SledeciID(KozmetickiSalon.zakazaniTretmani);
		this.idKlijenta = idKlijenta;
		this.idKozmeticara = idKozmeticara;
		this.idTretmana = idTretmana;
		this.vreme = vreme;
		this.stanje = stanje;
	}
	
	public ZakazanTretman(int id, int idKlijenta, int idKozmeticara, int idTretmana, Date vreme, Stanje stanje) 
	{
		this.id = id;
		this.idKlijenta = idKlijenta;
		this.idKozmeticara = idKozmeticara;
		this.idTretmana = idTretmana;
		this.vreme = vreme;
		this.stanje = stanje;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdKlijenta() {
		return idKlijenta;
	}
	public void setIdKlijenta(int idKlijenta) {
		this.idKlijenta = idKlijenta;
	}
	
	public int getidTretmana() {
		return idTretmana;
	}
	public void setidTretmana(int idTretmana) {
		this.idTretmana = idTretmana;
	}
	
	public int getIdKozmeticara() {
		return idKozmeticara;
	}
	public void setIdKozmeticara(int idKozmeticara) {
		this.idKozmeticara = idKozmeticara;
	}
	
	public Date getVreme() {
		return vreme;
	}
	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}
	
	public Stanje getStanje() {
		return stanje;
	}
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "," + this.idKlijenta + "," + this.idKozmeticara + "," + this.idTretmana + "," + Funkcionalnost.dateToString(this.vreme) + "," + this.stanje;
	}
	
	
	public static List<ZakazanTretman> UcitajZakazaneTretmane() 
	{
		List<ZakazanTretman> tretmani = new ArrayList<ZakazanTretman>();
		
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("csv/zakazaniTretmani.csv"), "utf-8"));
			String row;
	    	while((row = in.readLine()) != null) {
	    		String[] words = row.split(",");
	    		int id = Integer.parseInt(words[0]);
	    		int idKlijenta = Integer.parseInt(words[1]);
	    		int idKozmeticara = Integer.parseInt(words[2]);
	    		int idTretmana = Integer.parseInt(words[3]);
	    		Date vreme = Funkcionalnost.stringToDate(words[4]);
	    		Stanje stanje = Stanje.valueOf(words[5]);
	    		ZakazanTretman novi = new ZakazanTretman(id,  idKlijenta, idKozmeticara, idTretmana, Funkcionalnost.stringToDate(words[4]), stanje);
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
	
	public static void SacuvajZakazaneTretmane(List<ZakazanTretman> tretmani) 
	{
		try {
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
						new FileOutputStream("csv/zakazaniTretmani.csv"), "utf-8"));
			for (ZakazanTretman tretman : tretmani) {
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
	
	public static int SledeciID(List<ZakazanTretman> zakazaniTretmani) 
	{
		if(!zakazaniTretmani.isEmpty()) 
		{
			int max = zakazaniTretmani.get(0).getId();
			
			for (ZakazanTretman zakazanTretman : zakazaniTretmani) {
				if(zakazanTretman.getId() > max) 
				{
					max = zakazanTretman.getId();
				}
			}
			
			return max + 1;
		}
		return 1;
	}
	
	public static ZakazanTretman NadjiPoID(int id, List<ZakazanTretman> lista) 
	{
		for (ZakazanTretman zakazanTretman : lista) {
			if(zakazanTretman.getId() == id) return zakazanTretman;
		}
		return null;
	}
}
