import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * Libro nel formato Pdf
 * <p>
 * Formato leggibile
 * 
 * @author Filippo Muzzini
 *
 */
public class LibroPdf extends LibroLeggibile {
	
	private transient PDDocument doc;
	private transient JPanel nav;
	private transient NavigatorePdf navigator;
	private transient PannelloVistaPdf vista;

	private static final long serialVersionUID = 1L;

	public LibroPdf(String titolo, String autore, File file, int anno,
			int pagine) {
		super(titolo, autore, file, anno, pagine);
	}

	public LibroPdf(File f) {
		super(f);
	}

	/**
	 * Apre il file, nel caso lo descripta,
	 * crea navigatore e pannelli per la visualizzazione
	 */
	@Override
	public void apri() throws FileNotFoundException, IOException {
		RandomAccessBuffer ran = new RandomAccessBuffer();
		this.doc = PDDocument.load(this.getFile(), ran);
		
		if(this.doc.isEncrypted())
			decripta();		
		
		this.navigator = new NavigatorePdf(this.doc);
		
		this.nav = new JPanel();
		NavPdf navpdf = new NavPdf(this.navigator);
		this.nav.add(new JScrollPane(navpdf));
		
		this.vista = new PannelloVistaPdf(this.navigator);
		
		this.navigator.addCambioPaginaListener(this.vista.getVista());
		this.navigator.addCambioPaginaListener(navpdf);

	}
	
	/**
	 * Ritorna la barra di navigazione
	 */
	@Override
	public JPanel getNavBar() {
		return this.nav;
	}

	/**
	 * Ritorna la vista delle pagine
	 */
	@Override
	public JPanel getVista() {
		return this.vista;
	}

	/**
	 * chiude il file e i componenti
	 */
	@Override
	public void chiudi() {
		this.nav = null;
		this.navigator = null;
		this.vista = null;
		
		try {
			this.doc.close();
		} catch (IOException e) {
			System.out.println("Errore nella chiusura del documento");
		} finally {
			this.doc = null;
		}
	}

	/**
	 * Chiede la password e decripta il file
	 */
	private void decripta() {
		boolean decriptato;
		do{
			String pass = JOptionPane.showInputDialog("Documento protetto: Inserire Password");
			try{
				this.doc.decrypt(pass);
				decriptato = true;
			} catch(CryptographyException e){
				decriptato = false;
			} catch (IOException e) {
				decriptato = false;
			}
		} while(decriptato == false);
	}



}
