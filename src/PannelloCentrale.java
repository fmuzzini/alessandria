import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Pannello Centrale
 * <p>
 * Contiene la vista della tabella
 * 
 * @author Filippo Muzzini
 *
 */
public class PannelloCentrale extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il pannello centrale
	 * 
	 * @param table Tabella da mostrare
	 */
	public PannelloCentrale(TabellaBiblioteca table){		
		JScrollPane scroll = new JScrollPane(table);
		PannelloLaterale lat = new PannelloLaterale(table);
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, scroll);
		this.add(BorderLayout.EAST, lat);
	}

}
