package testiranje;

import static org.junit.Assert.*;

import org.junit.Test;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.RecepcionerAdmin;
import enumi.Pol;
import korisnici.Menadzer;
import korisnici.Recepcioner;

public class RecepcionerAdminTest {

	@Test
    public void testDodajRecepcionera() {
		
        Recepcioner recepcioner = new Recepcioner(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
        
        RecepcionerAdmin.DodajRecepcionera(recepcioner);

        assertTrue(KozmetickiSalon.recepcioneri.contains(recepcioner));
        
        RecepcionerAdmin.ObrisiRecepcionera(recepcioner.getId());
    }
	
	@Test
    public void testIzmeniRecepcionera() {
        
		Recepcioner existingRecepcioner = new Recepcioner(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
		RecepcionerAdmin.DodajRecepcionera(existingRecepcioner);
        
        Recepcioner updatedRecepcioner = new Recepcioner(-1, "Nikson1234", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
        int id = existingRecepcioner.getId();

        RecepcionerAdmin.IzmeniRecepcionera(id, updatedRecepcioner);

        assertTrue(KozmetickiSalon.recepcioneri.contains(updatedRecepcioner));
        assertFalse(KozmetickiSalon.recepcioneri.contains(existingRecepcioner));
        
        RecepcionerAdmin.ObrisiRecepcionera(existingRecepcioner.getId());
    }
	
	@Test
    public void testObrisiRecepcionera() {
        
		Recepcioner recepcioner = new Recepcioner(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
		RecepcionerAdmin.DodajRecepcionera(recepcioner);
        
        int id = recepcioner.getId();

        RecepcionerAdmin.ObrisiRecepcionera(id);

        assertFalse(KozmetickiSalon.recepcioneri.contains(recepcioner));
    }
}
