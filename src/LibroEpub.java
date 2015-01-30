import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JPanel;
import nl.siegmann.epublib.browsersupport.Navigator;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;
import nl.siegmann.epublib.viewer.ContentPane;
import nl.siegmann.epublib.viewer.TableOfContentsPane;

/**
 * Libro nel formato ePub.
 * <p>
 * È un formato leggibile dal lettore interno.
 * 
 * @author Filippo Muzzini
 *
 */
public class LibroEpub extends LibroLeggibile {
	
	private transient Book book;
	private transient Navigator nav;
	private transient FileInputStream input;

	private static final long serialVersionUID = 1L;

	public LibroEpub(String titolo, String autore, File file, int anno,
			int pagine) {
		super(titolo, autore, file, anno, pagine);
	}

	public LibroEpub(File f) {
		super(f);
	}

	/**
	 * Compie le operazioni preliminari 
	 * alla visualizzazione.
	 * <p>
	 * Apre il file, crea il Book e il Navigator
	 */
	@Override
	public void apri() throws FileNotFoundException, IOException {
		EpubReader reader = new EpubReader();
		this.input = new FileInputStream(this.getFile());
		this.book = reader.readEpub(this.input);
		this.nav = new Navigator(this.book);
	}
	
	/**
	 * Ritorna il pannello della gerarchia.
	 * <p>
	 * La libreria ePub mette già a disposizione ciò.
	 * 
	 * @return Pannello della gerarchia.
	 */
	@Override
	public JPanel getNavBar(){
		return new TableOfContentsPane(this.nav);
	}

	/**
	 * Ritorna il pannello della visualizzazione.
	 * <p>
	 * La libraria ePub mette già a disposizione ciò.
	 * 
	 * @return Pannello di visualizzazione.
	 */
	@Override
	public JPanel getVista() {
		return new ContentPane(this.nav);
	}

	/**
	 * Chiude l'input stream usato per la lettura
	 * @throws IOException 
	 * 
	 */
	@Override
	public void chiudi() {
		this.book = null;
		this.nav = null;
		
		try {
			this.input.close();
		} catch (IOException e) {
			System.out.println("Errore nella chiusura dello stream");
		}
	}

}
