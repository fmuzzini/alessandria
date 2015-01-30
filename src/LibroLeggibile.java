import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

/**
 * Libro leggibile con il lettore
 * interno all'applicazione.
 * 
 * @author Filippo Muzzini
 *
 */
public abstract class LibroLeggibile extends Libro {
	
	private static final long serialVersionUID = 1L;

	public LibroLeggibile(String titolo, String autore, File file, int anno,
			int pagine) {
		super(titolo, autore, file, anno, pagine);
	}

	public LibroLeggibile(File f) {
		super(f);
	}

	/**
	 * Metodo astratto che compie l'apertura del libro.
	 * 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public abstract void apri() throws FileNotFoundException, IOException;

	/**
	 * Crea e ritorna il pannello in cui
	 * è visualizzata la gerarchia dei contenuti
	 * 
	 * @return Pannello contente la gerarchia
	 */
	public abstract JPanel getNavBar();

	/**
	 * Crea e ritorna il pannello in cui
	 * vengono visualizzati i contenuti
	 * 
	 * @return Pannello che visualizza i contenuti
	 */
	public abstract JPanel getVista();
	
	/**
	 * Effettua le operazioni di chiusura del file
	 * @throws IOException 
	 */
	public abstract void chiudi();
	
}
