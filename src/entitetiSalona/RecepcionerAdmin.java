package entitetiSalona;

import korisnici.Recepcioner;

public class RecepcionerAdmin {
	public static void DodajRecepcionera(Recepcioner recepcioner) 
	{
		KozmetickiSalon.recepcioneri.add(recepcioner);
		Recepcioner.SacuvajRecepcionere(KozmetickiSalon.recepcioneri);
	}
	public static void IzmeniRecepcionera(int id, Recepcioner izmena) 
	{
		Recepcioner stari = Recepcioner.NadjiPoID(id, KozmetickiSalon.recepcioneri);
		int index = KozmetickiSalon.recepcioneri.indexOf(stari);
		KozmetickiSalon.recepcioneri.set(index, izmena);
		Recepcioner.SacuvajRecepcionere(KozmetickiSalon.recepcioneri);
	}
	public static void ObrisiRecepcionera(int id) 
	{
		Recepcioner brisanje = Recepcioner.NadjiPoID(id, KozmetickiSalon.recepcioneri);
		int index = KozmetickiSalon.recepcioneri.indexOf(brisanje);
		KozmetickiSalon.recepcioneri.remove(index);
		Recepcioner.SacuvajRecepcionere(KozmetickiSalon.recepcioneri);
	}
}
