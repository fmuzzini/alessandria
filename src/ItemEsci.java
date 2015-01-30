import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * Item Esci del menu file
 * 
 * @author Filippo Muzzini
 *
 */
public class ItemEsci extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza l'item
	 */
	public ItemEsci(){
		super("Esci");
		this.addActionListener(this);
	}

	/**
	 * Esce dal programma
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
