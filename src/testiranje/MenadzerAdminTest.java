package testiranje;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.MenadzerAdmin;
import enumi.Pol;
import korisnici.Menadzer;

public class MenadzerAdminTest {
	
	@Test
    public void testDodajMenadzera() {
		
        Menadzer menadzer = new Menadzer(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
        
        MenadzerAdmin.DodajMenadzera(menadzer);

        assertTrue(KozmetickiSalon.menadzeri.contains(menadzer));
        
        MenadzerAdmin.ObrisiMenadzera(menadzer.getId());
    }
	
	@Test
    public void testIzmeniMenadzera() {
        
        Menadzer existingMenadzer = new Menadzer(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
        MenadzerAdmin.DodajMenadzera(existingMenadzer);
        
        Menadzer updatedMenadzer = new Menadzer(-1, "Nikson1234", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
        int id = existingMenadzer.getId();

        MenadzerAdmin.IzmeniMenadzera(id, updatedMenadzer);

        assertTrue(KozmetickiSalon.menadzeri.contains(updatedMenadzer));
        assertFalse(KozmetickiSalon.menadzeri.contains(existingMenadzer));
        
        MenadzerAdmin.ObrisiMenadzera(existingMenadzer.getId());
    }
	
	@Test
    public void testObrisiMenadzera() {
        
        Menadzer menadzer = new Menadzer(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0);
        MenadzerAdmin.DodajMenadzera(menadzer);
        
        int id = menadzer.getId();

        MenadzerAdmin.ObrisiMenadzera(id);

        assertFalse(KozmetickiSalon.menadzeri.contains(menadzer));
    }
}
