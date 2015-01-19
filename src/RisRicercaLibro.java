
/**
 * Classe per memorizzare i risultati di una ricerca
 * nella bibloteca.
 * Contiene l'indice del libro matchato
 * e i campi in cui è stato riscontrato 
 * il match sono posti a true
 * 
 * @author filippo
 *
 */
public class RisRicercaLibro {
	private int libro;
	private boolean titolo;
	private boolean autore;
	private boolean anno;
	private boolean pagine;
	private boolean match;
	
	/**
	 * @param libro Indice del libro
	 * @param campo Indice del campo
	 */
	public RisRicercaLibro(){
		this.anno = false;
		this.autore = false;
		this.pagine = false;
		this.titolo = false;
		this.match = false;
	}

	/**
	 * Ritorna l'indice del libro
	 * 
	 * @return indice del libro
	 */
	public int getLibro() {
		return libro;
	}

	/**
	 * Setta l'indice del libro
	 * 
	 * @param libro Indice del libro
	 */
	public void setLibro(int libro) {
		this.libro = libro;
	}

	/**
	 * Ritorna true se c'è match nel titolo
	 * 
	 * @return True se c'è match nel titolo
	 */
	public boolean isTitolo() {
		return titolo;
	}

	/**
	 * Setta lo stato del match titolo
	 * 
	 * @param titolo Stato del titolo
	 */
	public void setTitolo(boolean titolo) {
		this.titolo = titolo;
		this.match = true;
	}

	/**
	 * Ritorna true se c'è match nell'autore
	 * 
	 * @return true se c'è match nell'autore
	 */
	public boolean isAutore() {
		return autore;
	}

	/**
	 * Setta lo stato del match dell'autore
	 * 
	 * @param autore stato del match dell'autore
	 */
	public void setAutore(boolean autore) {
		this.autore = autore;
		this.match = true;
	}

	/**
	 * Ritorna true se c'è match nell'anno
	 * 
	 * @return true se c'è match sull'anno
	 */
	public boolean isAnno() {
		return anno;
	}

	/**
	 * Setta lo stato del match dell'anno
	 * 
	 * @param anno stato del match dell'anno
	 */
	public void setAnno(boolean anno) {
		this.anno = anno;
		this.match = true;
	}

	/**
	 * Ritorna true se c'è match nelle pagine
	 * 
	 * @return true se c'è match nelle pagine
	 */
	public boolean isPagine() {
		return pagine;
	}

	/**
	 * Setta lo stato del match sulle pagine
	 * 
	 * @param pagine stato del match sulle pagine
	 */
	public void setPagine(boolean pagine) {
		this.pagine = pagine;
		this.match = true;
	}
	
	/**
	 * Ritorna true se l'oggetto contiene
	 * almeno un campo matchato
	 * 
	 * @return True se c'è un match
	 */
	public boolean isMatch(){
		return match;
	}
}
