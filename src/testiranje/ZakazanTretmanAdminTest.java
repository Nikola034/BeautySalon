package testiranje;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.ZakazanTretman;
import entitetiSalona.ZakazanTretmanAdmin;
import enumi.Pol;
import enumi.Stanje;
import korisnici.Menadzer;

public class ZakazanTretmanAdminTest {

	@Test
    public void testDodajZakazanTretman() {
		
		ZakazanTretman zakazanTretman = new ZakazanTretman(-1, 11, 11, 11, new Date(1970,1,1), Stanje.ZAKAZAN);
        
        ZakazanTretmanAdmin.DodajZakazanTretman(zakazanTretman);

        assertTrue(KozmetickiSalon.zakazaniTretmani.contains(zakazanTretman));
        
        ZakazanTretmanAdmin.ObrisiZakazanTretman(zakazanTretman.getId());
    }
	
	@Test
    public void testIzmeniZakazanTretman() {
        
		ZakazanTretman existingZakazanTretman = new ZakazanTretman(-1, 11, 11, 11, new Date(1970,1,1), Stanje.ZAKAZAN);
		ZakazanTretmanAdmin.DodajZakazanTretman(existingZakazanTretman);
        
        ZakazanTretman updatedZakazanTretman = new ZakazanTretman(-1, 112, 121, 121, new Date(1970,1,1), Stanje.ZAKAZAN);
        int id = existingZakazanTretman.getId();

        ZakazanTretmanAdmin.IzmeniZakazanTretman(id, updatedZakazanTretman);

        assertTrue(KozmetickiSalon.zakazaniTretmani.contains(updatedZakazanTretman));
        assertFalse(KozmetickiSalon.zakazaniTretmani.contains(existingZakazanTretman));
        
        ZakazanTretmanAdmin.ObrisiZakazanTretman(existingZakazanTretman.getId());
    }
	
	@Test
    public void testObrisiZakazanTretman() {
        
		ZakazanTretman zakazanTretman = new ZakazanTretman(-1, 11, 11, 11, new Date(1970,1,1), Stanje.ZAKAZAN);
		ZakazanTretmanAdmin.DodajZakazanTretman(zakazanTretman);
        
        int id = zakazanTretman.getId();

        ZakazanTretmanAdmin.ObrisiZakazanTretman(id);

        assertFalse(KozmetickiSalon.zakazaniTretmani.contains(zakazanTretman));
    }

}
