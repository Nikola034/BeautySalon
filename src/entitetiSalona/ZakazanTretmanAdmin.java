package entitetiSalona;

public class ZakazanTretmanAdmin {
	public static void DodajZakazanTretman(ZakazanTretman zakazanTretman) 
	{
		KozmetickiSalon.zakazaniTretmani.add(zakazanTretman);
		ZakazanTretman.SacuvajZakazaneTretmane(KozmetickiSalon.zakazaniTretmani);
	}
	public static void IzmeniZakazanTretman(int id, ZakazanTretman izmena) 
	{
		ZakazanTretman stari = ZakazanTretman.NadjiPoID(id, KozmetickiSalon.zakazaniTretmani);
		int index = KozmetickiSalon.zakazaniTretmani.indexOf(stari);
		KozmetickiSalon.zakazaniTretmani.set(index, izmena);
		ZakazanTretman.SacuvajZakazaneTretmane(KozmetickiSalon.zakazaniTretmani);
	}
	public static void ObrisiZakazanTretman(int id) 
	{
		ZakazanTretman brisanje = ZakazanTretman.NadjiPoID(id, KozmetickiSalon.zakazaniTretmani);
		int index = KozmetickiSalon.zakazaniTretmani.indexOf(brisanje);
		KozmetickiSalon.zakazaniTretmani.remove(index);
		ZakazanTretman.SacuvajZakazaneTretmane(KozmetickiSalon.zakazaniTretmani);
	}
}
