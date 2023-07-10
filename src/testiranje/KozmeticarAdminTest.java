package testiranje;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entitetiSalona.KozmeticarAdmin;
import entitetiSalona.KozmetickiSalon;
import enumi.Pol;
import korisnici.Kozmeticar;
import korisnici.Menadzer;

public class KozmeticarAdminTest {

	@Test
    public void testDodajKozmeticara() {
		
		List<Integer> vestine = new ArrayList<Integer>();
		vestine.add(-3);
		vestine.add(-1);
        Kozmeticar kozmeticar = new Kozmeticar(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0, vestine);
        
        KozmeticarAdmin.DodajKozmeticara(kozmeticar);

        assertTrue(KozmetickiSalon.kozmeticari.contains(kozmeticar));
        
        KozmeticarAdmin.ObrisiKozmeticara(kozmeticar.getId());
    }
	
	@Test
    public void testIzmeniKozmeticara() {
        
		List<Integer> vestine = new ArrayList<Integer>();
		vestine.add(-3);
		vestine.add(-1);
        Kozmeticar existingKozmeticar = new Kozmeticar(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0, vestine);
        KozmeticarAdmin.DodajKozmeticara(existingKozmeticar);
        
        Kozmeticar updatedKozmeticar = new Kozmeticar(-1, "Nikson1234", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0, vestine);
        int id = existingKozmeticar.getId();

        KozmeticarAdmin.IzmeniKozmeticara(id, updatedKozmeticar);

        assertTrue(KozmetickiSalon.kozmeticari.contains(updatedKozmeticar));
        assertFalse(KozmetickiSalon.kozmeticari.contains(existingKozmeticar));
        
        KozmeticarAdmin.ObrisiKozmeticara(existingKozmeticar.getId());
    }
	
	@Test
    public void testObrisiKozmeticara() {
		
		List<Integer> vestine = new ArrayList<Integer>();
		vestine.add(-3);
		vestine.add(-1);
        Kozmeticar kozmeticar = new Kozmeticar(-1, "Nikola", "Bandulaja", Pol.MUSKI, "025/512-802", "Vojvode Putnika 8", "Nikson123", "Sifra123", 0, 0, 0, 0, 0, vestine);
        KozmeticarAdmin.DodajKozmeticara(kozmeticar);
        
        int id = kozmeticar.getId();

        KozmeticarAdmin.ObrisiKozmeticara(id);

        assertFalse(KozmetickiSalon.kozmeticari.contains(kozmeticar));
    }

}
