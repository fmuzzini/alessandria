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
public abstract class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String titolo;
	private String autore;
	private String file;
	private int	anno;
	private int pagine;
	
	static final String campi[] = {"Titolo", "Autore", "Anno", "Pagine"};
	
	/**
	 * Ritorna il numero di campi per
	 * la visualizzazione della tabella.
	 * 
	 * @return Numero campi
	 */
	static public int getNumeroCampi(){
		return campi.length;
	}
	
	/**
	 * Ritorna il nome del campo per
	 * la visualizzazione della tabella
	 * 
	 * @param index Indice del campo
	 * @return Nome del campo
	 */
	static public String getNomeCampo(int index){
		return campi[index];
	}
	
	/**
	 * @param titolo	Titolo del libro
	 * @param autore	Autore del libro
	 * @param file		Percorso del file
	 * @param anno		Anno del libro
	 * @param pagine	Numero di pagine del libro
	 */
	public Libro(String titolo, String autore, String file, int anno, int pagine) {
		this.titolo = titolo;
		this.autore = autore;
		this.file = file;
		this.anno = anno;
		this.pagine = pagine;
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
	public String getFile() {
		return file;
	}

	/**
	 * Setta il percorso del file.
	 * 
	 * @param file	Percorso del file
	 */
	public void setFile(String file) {
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
	
	/**
	 * Cerca una corrispondenza tra i campi del
	 * libro.
	 * Se la trova ritorna il campo sotto
	 * forma di indice altrimenti
	 * ritorna -1
	 * 
	 * @param str Stringa da confrontare
	 * @return Indice del campo in cui c'è la corrispondenza
	 */
	public int cerca(String str){
		if(this.titolo.contains(str))
			return 0;
		if(this.autore.contains(str))
			return 1;
		
		int n;
		try{
			n = Integer.parseInt(str);
		} catch(NumberFormatException e){
			return -1;
		}
		
		if(this.anno == n)
			return 2;
		if(this.pagine == n)
			return 3;
		
		return -1;
	}
	
	/**
	 * Metodo astratto che permette la lettura del libro.
	 * <p>
	 * Tale metodo è astratto poichè la sua implementazione
	 * dipende dal formato del libro.
	 */
	public abstract void leggi();
}
