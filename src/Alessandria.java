
/**
 * Classe principale.
 * 
 * Contiene costanti utili per l'esecuzione del programma.
 * 
 * 
 * @author Filippo Muzzini
 *
 */
public class Alessandria {

	/**< Descrizione dei file di salvataggio */
	public static final String desc = "Biblioteca Alessandria";	
	
	/**< Estensione dei file di salvataggio */
	public static final String file = "ba";	
	
	/**< Elenco dei formati leggibili */
	public static final String[] libriLeggibili = {"pdf", "epub"};	
	

	/**
	 * Inizializza una biblioteca vuota
	 * e l'interfaccia grafica.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Biblioteca a = new Biblioteca();
		
		Finestra finestra = new Finestra(a);
		finestra.setVisible(true);		
	}

}
