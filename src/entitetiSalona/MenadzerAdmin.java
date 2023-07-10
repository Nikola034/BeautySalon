package entitetiSalona;

import korisnici.Menadzer;

public class MenadzerAdmin {
	public static void DodajMenadzera(Menadzer menadzer) 
	{
		KozmetickiSalon.menadzeri.add(menadzer);
		Menadzer.SacuvajMenadzere(KozmetickiSalon.menadzeri);
	}
	public static void IzmeniMenadzera(int id, Menadzer izmena) 
	{
		Menadzer stari = Menadzer.NadjiPoID(id, KozmetickiSalon.menadzeri);
		int index = KozmetickiSalon.menadzeri.indexOf(stari);
		KozmetickiSalon.menadzeri.set(index, izmena);
		Menadzer.SacuvajMenadzere(KozmetickiSalon.menadzeri);
	}
	public static void ObrisiMenadzera(int id) 
	{
		Menadzer brisanje = Menadzer.NadjiPoID(id, KozmetickiSalon.menadzeri);
		int index = KozmetickiSalon.menadzeri.indexOf(brisanje);
		KozmetickiSalon.menadzeri.remove(index);
		Menadzer.SacuvajMenadzere(KozmetickiSalon.menadzeri);
	}
}
