import javax.swing.JButton;

/**
 * Classe che rappresenta il bottone di ricerca.
 * 
 * @author Filippo Muzzini
 *
 */
public class BottoneRicerca extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param text Campo di Ricerca
	 */
	public BottoneRicerca(CampoRicerca text){
		super("Prossimo Risultato");
		this.addActionListener(text);
	}

}
