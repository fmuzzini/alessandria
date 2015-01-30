import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Pulsante per la visualizzazione di
 * un libro
 * 
 * @author Filippo Muzzini
 *
 */
public class PulsanteVisualizza extends PulsanteLaterale {
	
	private int libro;

	private static final long serialVersionUID = 1L;

	/**
	 * Inizializza il pulsante
	 * 
	 * @param table Tabella
	 */
	public PulsanteVisualizza(TabellaBiblioteca table) {
		super(table);
		this.setText("Visualizza");
		this.addActionListener(this);
	}

	/**
	 * Il pulsante è attivo
	 * solo se vi è selezionato
	 * solamente un libro
	 */
	@Override
	public void libriSelezionati(int[] libri) {
		if (libri.length != 1){
			this.setEnabled(false);
			return;
		}
		
		this.setEnabled(true);
		this.libro = libri[0];
	}

	/**
	 * Se il libro è leggibile apre il visualizzatore
	 * altrimenti delega al sistema operativo la sua apertura
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Libro libro = this.getTable().getBiblioteca().getLibro(this.libro);
		
		if(libro instanceof LibroLeggibile){
			LibroLeggibile leg = (LibroLeggibile) libro;
			
			Visualizzatore v = null;
			try {
				v = new Visualizzatore(leg);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, "File non trovato", "", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Impossibile aprire il file", "", JOptionPane.ERROR_MESSAGE);
			}
			
			v.setVisible(true);
			
		} else {
			try {
				Desktop.getDesktop().open(libro.getFile());
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, "File non trovato", "", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Impossibile aprire il file", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
