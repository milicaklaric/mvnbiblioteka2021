package rs.ac.bg.fon.nprog.mvnbiblioteka2021;

/**
 * Klasa koja predstavlja autora knjige.
 * Autor ima ime i prezime kao string vrednosti.
 * 
 * @author Milica Klaric
 * @version 0.1
 *
 */

public class Autor {

	/**
	 * Ime autora kao string.
	 */
	private String ime;
	/**
	 * Prezime autora kao string.
	 */
	private String prezime;
	
	/**
	 * Vraca ime autora
	 * @return Ime autora kao String
	 */
	public String getIme() {
		return ime;
	}
	
	/**
	 * Postavlja ime autora na novu vrednost.
	 * 
	 * @param ime ime autora kao string
	 * 
	 * @throws java.lang.NullPointerException ako je uneto ime null
	 * @throws java.lang.RuntimeException ako je uneto ime krace od 2 karaktera
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		
		if (ime.length() <2)
			throw new RuntimeException("Ime mora imati vise od 2 karaktera");
		
		this.ime = ime;
	}
	
	/**
	 * Vraca prezime autora.
	 * @return Prezime autora kao String.
	 */
	public String getPrezime() {
		return prezime;
	}
	
	/**
	 * Postavlja prezime autora na novu vrednost.
	 * 
	 * @param prezime prezime autora kao string
	 * 
	 * @throws java.lang.NullPointerException ako je uneto prezime null
	 * @throws java.lang.RuntimeException ako je uneto prezime krace od 2 karaktera
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
		
		if (prezime.length() <2)
			throw new RuntimeException("Prezime mora imati vise od 2 karaktera");
		
		
		this.prezime = prezime;
	}
	
	/**
	 * Bezparametarski konstruktor koji inicijalizuje objekat sa null vrednostima parametara.
	 */
	public Autor() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parametarski konstruktor koji inicijalizuje objekat i posravlja vrednosti za ime i prezime autora.
	 * 
	 * @param ime Ime autora kao String
	 * @param prezime Prezime autora kao String
	 */
	public Autor(String ime, String prezime) {
		super();
		setIme(ime);
		setPrezime(prezime);
	}
	
	/**
	 * @return Vraca strig sa vim podacima o autoru
	 */
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}
	
	/**
	 * Poredjenje objekata klase Autor i vraca TRUE ako su isti i FALSE ako nisu.
	 * 
	 * Autori se porede po imenu i prezimenu i oba moraju da budu ista.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ako su oba objekta klase Autor i imaju ista imena i prezimena</li>
	 * 		<li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	
	
}
