package rs.ac.bg.fon.nprog.mvnbiblioteka2021.interfejs;

import java.util.LinkedList;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.Autor;
import rs.ac.bg.fon.nprog.mvnbiblioteka2021.Knjiga;

/**
 * Interfejsk koji predstavlja biblioteku
 * @author Milica Klaric
 *
 */
public interface BibliotekaInterface {

	/**
	 * Dodaje novu knjigu u biblioteku.
	 * 
	 * @param knjiga Knjiga koja se dodaje
	 * 
	 * @throws java.lang.NullPointerException ako je dodata knjiga null
	 * @throws java.lang.RuntimeException ako je knjiga vec postoji u biblioteci
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	
	public void obrisiKnjigu(Knjiga knjiga);
	
	public LinkedList<Knjiga> vratiSveKnjige();
	
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac);
}
