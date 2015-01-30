import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 * Item Carica del menu File
 * 
 * @author Filippo Muzzini
 *
 */
public class ItemCarica extends JMenuItem implements ActionListener {
	
	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza l'item
	 * e associa la tabella
	 * 
	 * @param table Tabella
	 */
	public ItemCarica(TabellaBiblioteca table){
		super("Carica Biblioteca");
		this.addActionListener(this);
		this.table = table;
	}

	/**
	 * Apre la finestra per la scelta del file
	 * e sostituisce la biblioteca.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Crea il gruppoestensione per la selezione
		Estensioni est = new Estensioni();
		GruppoEstensioni g = new GruppoEstensioni(Alessandria.desc);
		g.addEstensione(Alessandria.file);
		est.addGruppo(g);
		
		//Apre la finestra per la scelta del file
		JFileChooser chooser = new ScegliFile(est);
		int res = chooser.showOpenDialog(chooser);
		
		if(res != JFileChooser.APPROVE_OPTION)
			return;
		
		//Legge il file selezionato
		File file = chooser.getSelectedFile();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "File inesistente", "", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "Impossibile aprire il file", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Sostituisce la biblioteca
		Biblioteca biblio = null;
		try {
			biblio = (Biblioteca) in.readObject();
			table.cambioBiblioteca(biblio);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "File corrotto", "", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "Classe diversa", "", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				in.close();
			} catch (IOException e1) {
				System.out.println("Errore nella chiusura del file");
			}
		}
		
	}

}
