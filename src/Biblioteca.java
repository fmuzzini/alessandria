import java.io.Serializable;
import java.util.Vector;



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
	private Vector<Libro> libri;
	
	//TODO mantenere la lista ordinata!!!!
	
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
	
	/**
	 * Cerca in ogni libro la stringa passata.
	 * Memorizza i vari match in un vettore e lo restituisce
	 * 
	 * @param str Stringa da matchare
	 * @return Vettore contanente i risultati
	 */
	public Vector<RisRicercaLibro> ricerca(String str){
		Vector<RisRicercaLibro> res = new Vector<RisRicercaLibro>();
		
		for(int i=0; i<libri.size(); i++){
			int campo = getLibro(i).cerca(str);
			if(campo != -1)
				res.add(new RisRicercaLibro(i, campo));
		}
		
		return res;
	}
	//TODO stampa (può essere usata la stessa per tabella)
	

}
