package entitetiSalona;

public class TretmanAdmin {
	public static void DodajTretman(Tretman tretman) 
	{
		KozmetickiSalon.tretmani.add(tretman);
		Tretman.SacuvajTretmane(KozmetickiSalon.tretmani);
	}
	public static void IzmeniTretman(int id, Tretman izmena) 
	{
		Tretman stari = Tretman.NadjiPoID(id, KozmetickiSalon.tretmani);
		int index = KozmetickiSalon.tretmani.indexOf(stari);
		KozmetickiSalon.tretmani.set(index, izmena);
		Tretman.SacuvajTretmane(KozmetickiSalon.tretmani);
	}
	public static void ObrisiTretman(int id) 
	{
		Tretman brisanje = Tretman.NadjiPoID(id, KozmetickiSalon.tretmani);
		int index = KozmetickiSalon.tretmani.indexOf(brisanje);
		KozmetickiSalon.tretmani.remove(index);
		Tretman.SacuvajTretmane(KozmetickiSalon.tretmani);
	}
}
