import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Finestra aiuto
 * @author Filippo Muzzini
 *
 */
public class FinestraAiuto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public FinestraAiuto(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String text = "Questo programma consente la visualizzazione e la modifica" +
				"di una biblioteca ebook\n\n" +
				"Nella parte centralle è visibile una tabella con i libri presenti\n\n" +
				"con i tasti laterali è possibili aggiungere, modificare, eliminare\n" +
				"o visualizzare i libri\n\n" +
				"Con il campo in alto a destra è possibile efettuare ricerche\n\n" +
				"Dal menu file è possibile salvare o caricare biblioteche";
		JTextArea pan = new JTextArea(text);
		JScrollPane scroll = new JScrollPane(pan);
		this.add(scroll);
		
		this.pack();
	}
}
