import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class PannelloCentrale extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PannelloCentrale(TabellaBiblioteca table){		
		JScrollPane scroll = new JScrollPane(table);
		PannelloLaterale lat = new PannelloLaterale(table);
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, scroll);
		this.add(BorderLayout.EAST, lat);
	}

}
