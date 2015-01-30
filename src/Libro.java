import java.io.File;
import java.io.Serializable;


/**
 * Classe astratta Libro.
 * <p>
 * Contiene tutte le informazioni comuni
 * ai libri (titolo, autore, anno, pagine)
 * e dichiaria il prototipo della funzione che
 * permette la lettura del libro.
 * 
 * @author Filippo Muzzini
 *
 */
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String titolo;
	private String autore;
	private File file;
	private int	anno;
	private int pagine;
	
	
	/**
	 * Inizializza il libro con i parametri passati
	 * 
	 * @param titolo	Titolo del libro
	 * @param autore	Autore del libro
	 * @param file		Percorso del file
	 * @param anno		Anno del libro
	 * @param pagine	Numero di pagine del libro
	 */
	public Libro(String titolo, String autore, File file, int anno, int pagine) {
		this.titolo = titolo;
		this.autore = autore;
		this.file = file;
		this.anno = anno;
		this.pagine = pagine;
	}
	
	/**
	 * Inizializza il libro con campi vuoti
	 * tranne il campo file
	 * 
	 * @param file File
	 */
	public Libro(File file) {
		this("", "", file, 0, 0);
	}


	/**
	 * Ritorna il titolo del libro.
	 * 
	 * @return	Titolo del libro
	 */
	public String getTitolo() {
		return titolo;
	}
	
	/**
	 * Setta il titolo del libro.
	 * 
	 * @param titolo	Titolo del libro
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	/**
	 * Ritorna il nome dell'autore.
	 * 
	 * @return	Nome dell'autore
	 */
	public String getAutore() {
		return autore;
	}
	
	/**
	 * Setta l'autore del libro.
	 * 
	 * @param autore	Autore del libro
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	/**
	 * Ritorna il percorso del file.
	 * 
	 * @return	Percorso del file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Setta il percorso del file.
	 * 
	 * @param file	Percorso del file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Ritorna l'anno del libro.
	 * 
	 * @return	Anno del libro
	 */
	public int getAnno() {
		return anno;
	}
	
	/**
	 * Setta l'anno del libro.
	 * 
	 * @param anno	Anno del libro
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	/**
	 * Ritorna il numero di pagine del libro.
	 * 
	 * @return	Numero di pagine
	 */
	public int getPagine() {
		return pagine;
	}
	
	/**
	 * Setta il numero di pagine del libro.
	 * 
	 * @param pagine	Numero di pagine
	 */
	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
	
}
