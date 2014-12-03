
/**
 * Classe per memorizzare i risultati di una ricerca
 * nella bibloteca.
 * Contiene l'indice del libro matchato
 * e l'indice del campo dove è stata matchata 
 * la stringa di ricerca
 * 
 * @author filippo
 *
 */
public class RisRicercaLibro {
	public int libro;
	public int campo;
	
	/**
	 * @param libro Indice del libro
	 * @param campo Indice del campo
	 */
	public RisRicercaLibro(int libro, int campo){
		this.libro = libro;
		this.campo = campo;
	}
}
