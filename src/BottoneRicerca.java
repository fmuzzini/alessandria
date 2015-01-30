import javax.swing.JButton;

/**
 * Classe che rappresenta il bottone di ricerca.
 * <p>
 * Il bottone è associato ad un campo di ricerca.
 * 
 * @author Filippo Muzzini
 *
 */
public class BottoneRicerca extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea il bottone e lo associa al campo di reicerca
	 * 
	 * @param text Campo di Ricerca
	 */
	public BottoneRicerca(CampoRicerca text){
		super("Prossimo Risultato");
		this.addActionListener(text);
	}

}
