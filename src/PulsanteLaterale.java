import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Pulsanti del pannello laterale
 * 
 * @author Filippo Muzzini
 *
 */
public abstract class PulsanteLaterale extends JButton implements SelezioneListener, ActionListener {
	
	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il pulsante
	 * e lo associa alla tabella
	 * 
	 * @param table Tabella
	 */
	public PulsanteLaterale(TabellaBiblioteca table){
		super();
		this.table = table;
		this.setEnabled(false);
	}
	
	/**
	 * Ritorna la biblioteca associata alla
	 * tabella
	 * 
	 * @return Biblioteca
	 */
	public Biblioteca getBiblioteca(){
		return this.table.getBiblioteca();
	}
	
	/**
	 * Ritorna la tabella associata
	 * 
	 * @return Tabella
	 */
	public TabellaBiblioteca getTable(){
		return this.table;
	}

}
