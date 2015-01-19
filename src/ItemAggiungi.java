import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class ItemAggiungi extends JMenuItem implements ActionListener {
	
	private Biblioteca biblioteca;

	private static final long serialVersionUID = 1L;
	
	public ItemAggiungi(Biblioteca biblioteca){
		super("Aggiungi Libro");
		this.biblioteca = biblioteca;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
