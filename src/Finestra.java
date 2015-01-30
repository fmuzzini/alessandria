import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Finestra principale che contiene l'applicazione.
 * <p>
 * Genera tutta l'interfaccia grafica.
 * 
 * @author Filippo Muzzini
 *
 */
public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Genera tutti gli elementi e li associa alla biblioteca
	 * 
	 * @param biblioteca Biblioteca contenente i dati
	 */
	public Finestra(Biblioteca biblioteca){
		super("Alessandria - Biblioteca EBook");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannello = new JPanel();
		pannello.setLayout(new BorderLayout());
		
		TabellaBiblioteca table = new TabellaBiblioteca(new ModelTableBiblioteca(biblioteca));
		
		pannello.add(BorderLayout.CENTER, new PannelloCentrale(table));
		
		this.setJMenuBar(new BarraMenu(table));
		this.add(pannello);
		
		this.pack();
		
	}
}
