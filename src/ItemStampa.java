import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Item stampa del menu file
 * 
 * @author Filippo Muzzini
 *
 */
public class ItemStampa extends JMenuItem implements ActionListener {

	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza l'item e
	 * associa la tabella
	 * 
	 * @param table Table
	 */
	public ItemStampa(TabellaBiblioteca table){
		super("Stampa Biblioteca");
		this.table = table;
		this.addActionListener(this);
	}

	/**
	 * Crea una copia della tabella attuale,
	 * la ridimensiona e la stampa
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//Copia la tabella e la ridimensiona
		TabellaBiblioteca table;
		try {
			table = (TabellaBiblioteca) this.table.clone();
			table.clearSelection();
			table.aggiustaLarghezza();
		} catch (CloneNotSupportedException e1) {
			table = this.table;
		}
		
		//Stampa la tabella con un intestazione
		MessageFormat head = new MessageFormat("Alessandria - Stampa Biblioteca");
		try {
			table.print(JTable.PrintMode.FIT_WIDTH, head, null, true, null, false);
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Impossibile stampare", "", JOptionPane.ERROR_MESSAGE);
		} catch (PrinterException e) {
			JOptionPane.showMessageDialog(this, "Impossibile stampare", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	
}
