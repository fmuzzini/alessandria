import java.io.Serializable;
import java.util.ArrayList;



/**
 * Classe Biblioteca.
 * <p>
 * Contiene le informazioni dell'intera
 * biblioteca compreso l'insieme di libri.
 * 
 * @author filippo
 *
 */
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Libro> libri;
	
	//TODO mantenere la lista ordinata!!!!
	
	public Biblioteca(){
		libri = new ArrayList<Libro>();
	}
	
	/**
	 * Ritorna il numero di libri della biblioteca.
	 * 
	 * @return Numero libri
	 */
	public int getNumeroLibri(){
		return libri.size();
	}
	
	/**
	 * Aggiunge un libro alla biblioteca.
	 * @param libro	Libro da aggiungere
	 */
	public void aggiungiLibro(Libro libro){
		libri.add(libro);
	}
	
	/**
	 * Rimuove il libro associato
	 * all'indice.
	 * 
	 * @param index	Indice del libro da rimuovere
	 * @return	Libro appena rimosso
	 */
	public Libro rimuoviLibro(int index){
		return libri.remove(index);
	}
	
	/**
	 * Restituisce il libro associato
	 * all'indice.
	 * 
	 * @param index	Indice del libro
	 * @return	Libro associato all'indice
	 */
	public Libro getLibro(int index){
		return libri.get(index);
	}
	
	//TODO stampa (può essere usata la stessa per tabella)
	

}
