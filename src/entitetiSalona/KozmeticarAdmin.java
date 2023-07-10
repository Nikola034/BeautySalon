package entitetiSalona;

import korisnici.Kozmeticar;

public class KozmeticarAdmin {
	public static void DodajKozmeticara(Kozmeticar kozmeticar) 
	{
		KozmetickiSalon.kozmeticari.add(kozmeticar);
		Kozmeticar.SacuvajKozmeticare(KozmetickiSalon.kozmeticari);
	}
	public static void IzmeniKozmeticara(int id, Kozmeticar izmena) 
	{
		Kozmeticar stari = Kozmeticar.NadjiPoID(id, KozmetickiSalon.kozmeticari);
		int index = KozmetickiSalon.kozmeticari.indexOf(stari);
		KozmetickiSalon.kozmeticari.set(index, izmena);
		Kozmeticar.SacuvajKozmeticare(KozmetickiSalon.kozmeticari);
	}
	public static void ObrisiKozmeticara(int id) 
	{
		Kozmeticar brisanje = Kozmeticar.NadjiPoID(id, KozmetickiSalon.kozmeticari);
		int index = KozmetickiSalon.kozmeticari.indexOf(brisanje);
		KozmetickiSalon.kozmeticari.remove(index);
		Kozmeticar.SacuvajKozmeticare(KozmetickiSalon.kozmeticari);
	}
}
