package rs.ac.bg.fon.nprog.mvnbiblioteka2021.interfejs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.Knjiga;

public abstract class BibliotekaInterfaceTest {
	
	protected BibliotekaInterface biblioteka;

	@Test
	void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
	}
	
	@Test
	void testDodajKnjiguNull() {
	
		assertThrows(java.lang.NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null));
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		k.setNaslov("Knjiga 1");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("12345");
		k2.setNaslov("Knjiga 2");
		
		biblioteka.dodajKnjigu(k);
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.dodajKnjigu(k2));
		
		assertEquals("Knjiga vec postoji u biblioteci", e.getMessage());
	}

	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		k.setNaslov("Knjiga 1");
		biblioteka.dodajKnjigu(k);
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	void testObrisiKnjiguNull() {
				
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("5632");
		k2.setNaslov("Knjiga 2");
		
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.obrisiKnjigu(k2));
	}

	@Test
	void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		k.setNaslov("Knjiga 1");
		biblioteka.dodajKnjigu(k);
		
		LinkedList<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
	}

	
	@Test
	void testPronadjiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		k.setNaslov("Knjiga o dzungli");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("56321");
		k2.setNaslov("Gospodar prstenova");
		
		Knjiga k3 = new Knjiga();
		k3.setIsbn("785341");
		k3.setNaslov("Evgenije Onjegin");
		
		biblioteka.dodajKnjigu(k);
		biblioteka.dodajKnjigu(k2);
		biblioteka.dodajKnjigu(k3);
		
		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, null, "ospod", null);
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}

}
