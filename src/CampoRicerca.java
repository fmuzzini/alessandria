import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Classe che rappresenta il campo
 * per la ricerca.
 * <p>
 * Quando si preme invio o il tasto cerca
 * associato controlla se il testo è cambiato
 * e decide che azione svolgere
 * 
 * @author Filippo Muzzini
 *
 */
public class CampoRicerca extends JTextField implements ActionListener, DocumentListener {
	
	private TabellaBiblioteca table;
	private boolean testoCambiato;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea il campo di ricerca e lo 
	 * associa alla tabella su cui svolgere la ricerca.
	 * 
	 * @param table Tabella su cui svolgere la ricerca
	 */
	public CampoRicerca(TabellaBiblioteca table){
		super(20);
		this.table = table;
		this.testoCambiato = true;
		this.getDocument().addDocumentListener(this);
		this.addActionListener(this);
	}

	/**
	 * Se il testo è cambiato inizia una nuova 
	 * ricerca altrimenti mostra il prossimo risultato.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		if (testoCambiato == true){
			String str = this.getText();
			table.ricerca(str);
			testoCambiato = false;
		}
		else
			table.prossRis();
	}

	/**
	 * Aggiorna lo stato di testoCambiato
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		this.testoCambiato = true;		
	}

	/**
	 * Aggiorna lo stato di testoCambiato
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.testoCambiato = true;		
	}

	/**
	 * Aggiorna lo stato di testo cambiato
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.testoCambiato = true;		
	}

}
