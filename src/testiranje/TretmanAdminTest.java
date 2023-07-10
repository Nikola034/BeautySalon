package testiranje;

import static org.junit.Assert.*;

import org.junit.Test;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;
import entitetiSalona.TretmanAdmin;
import enumi.Pol;
import korisnici.Menadzer;

public class TretmanAdminTest {

	@Test
    public void testDodajTretman() {
		
		Tretman tretman = new Tretman(-1, "NoviTretman", 45, 3400);
        
        TretmanAdmin.DodajTretman(tretman);

        assertTrue(KozmetickiSalon.tretmani.contains(tretman));
        
        TretmanAdmin.ObrisiTretman(tretman.getId());
    }
	
	@Test
    public void testIzmeniTretman() {
        
		Tretman existingTretman = new Tretman(-1, "NoviTretman", 45, 3400);
		TretmanAdmin.DodajTretman(existingTretman);
        
        Tretman updatedTretman = new Tretman(-1, "NoviTretman12345", 45, 3400);
        int id = existingTretman.getId();

        TretmanAdmin.IzmeniTretman(id, updatedTretman);

        assertTrue(KozmetickiSalon.tretmani.contains(updatedTretman));
        assertFalse(KozmetickiSalon.tretmani.contains(existingTretman));
        
        TretmanAdmin.ObrisiTretman(existingTretman.getId());
    }
	
	@Test
    public void testObrisiTretman() {
        
		Tretman tretman = new Tretman(-1, "NoviTretman", 45, 3400);
		TretmanAdmin.DodajTretman(tretman);
        
        int id = tretman.getId();

        TretmanAdmin.ObrisiTretman(id);

        assertFalse(KozmetickiSalon.tretmani.contains(tretman));
    }
}
