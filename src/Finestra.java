import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Finestra(Biblioteca biblioteca){
		super("Alessandria - Biblioteca EBook");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannello = new JPanel();
		pannello.setLayout(new BorderLayout());
		
		TabellaBiblioteca table = new TabellaBiblioteca(new ModelTableBiblioteca(biblioteca));
		
		pannello.add(BorderLayout.CENTER, new PannelloCentrale(table));
		pannello.add(BorderLayout.SOUTH, new PannelloFooter(table));
		
		this.setJMenuBar(new BarraMenu(table));
		this.add(pannello);
		
		this.pack();
		
	}
}
