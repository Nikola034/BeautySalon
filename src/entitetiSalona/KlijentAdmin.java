package entitetiSalona;

import korisnici.Klijent;

public class KlijentAdmin {
	public static void DodajKlijenta(Klijent klijent) 
	{
		KozmetickiSalon.klijenti.add(klijent);
		Klijent.SacuvajKlijente(KozmetickiSalon.klijenti);
	}
	public static void IzmeniKlijenta(int id, Klijent izmena) 
	{
		Klijent stari = Klijent.NadjiPoID(id, KozmetickiSalon.klijenti);
		int index = KozmetickiSalon.klijenti.indexOf(stari);
		KozmetickiSalon.klijenti.set(index, izmena);
		Klijent.SacuvajKlijente(KozmetickiSalon.klijenti);
	}
	public static void ObrisiKlijenta(int id) 
	{
		Klijent brisanje = Klijent.NadjiPoID(id, KozmetickiSalon.klijenti);
		int index = KozmetickiSalon.klijenti.indexOf(brisanje);
		KozmetickiSalon.klijenti.remove(index);
		Klijent.SacuvajKlijente(KozmetickiSalon.klijenti);
	}
}
