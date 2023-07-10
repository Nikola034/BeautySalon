package testiranje;

import static org.junit.Assert.*;

import org.junit.Test;

import entitetiSalona.KlijentAdmin;
import entitetiSalona.KozmetickiSalon;
import enumi.Pol;
import korisnici.Klijent;
import korisnici.Menadzer;

public class KlijentAdminTest {

	@Test
    public void testDodajKlijenta() {
		
        Klijent klijent = new Klijent(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, false);
        
        KlijentAdmin.DodajKlijenta(klijent);

        assertTrue(KozmetickiSalon.klijenti.contains(klijent));
        
        KlijentAdmin.ObrisiKlijenta(klijent.getId());
    }
	
	@Test
    public void testIzmeniKlijenta() {
        
		Klijent existingKlijent = new Klijent(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, false);
		KlijentAdmin.DodajKlijenta(existingKlijent);
        
        Klijent updatedKlijent = new Klijent(-1, "Nikson1234", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, false);
        int id = existingKlijent.getId();

        KlijentAdmin.IzmeniKlijenta(id, updatedKlijent);

        assertTrue(KozmetickiSalon.klijenti.contains(updatedKlijent));
        assertFalse(KozmetickiSalon.klijenti.contains(existingKlijent));
        
        KlijentAdmin.ObrisiKlijenta(existingKlijent.getId());
    }
	
	@Test
    public void testObrisiKlijenta() {
        
		Klijent klijent = new Klijent(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, false);
		KlijentAdmin.DodajKlijenta(klijent);
        
        int id = klijent.getId();

        KlijentAdmin.ObrisiKlijenta(id);

        assertFalse(KozmetickiSalon.klijenti.contains(klijent));
    }

}
