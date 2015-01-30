import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Visualizzatore di libri.
 * <p>
 * Crea l'interfaccia grafica per la visualizzazione
 * dei libri
 * 
 * @author Filippo Muzzini
 *
 */
public class Visualizzatore extends JFrame implements WindowListener {
	
	private LibroLeggibile libro;
	private JPanel navBar;
	private JPanel vista;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Compie le operazioni necessarie alla
	 * visualizzazione del libro in una nuova finestra.
	 * 
	 * @param libro Libro da visualizzare
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Visualizzatore(LibroLeggibile libro) throws FileNotFoundException, IOException{
		super();
		this.libro = libro;
		libro.apri();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.navBar = libro.getNavBar();
		this.vista = libro.getVista();
		
		this.add(BorderLayout.WEST, this.navBar);
		this.add(BorderLayout.CENTER, this.vista);
		
		this.setTitle(libro.getTitolo() + " - Alessandria");
		this.addWindowListener(this);
				
		this.pack();
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.libro.chiudi();
		this.dispose();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
