import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Item salva del menu file
 * 
 * @author Filippo Muzzini
 *
 */
public class ItemSalva extends JMenuItem implements ActionListener {
	
	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza l'item e
	 * associa la tabella
	 * 
	 * @param table Tabella
	 */
	public ItemSalva(TabellaBiblioteca table){
		super("Salva Biblioteca");
		this.addActionListener(this);
		this.table = table;
	}

	/**
	 * Salva la biblioteca su file
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Crea il gruppo estensioni per il filtraggio
		Estensioni est = new Estensioni();
		GruppoEstensioni g = new GruppoEstensioni(Alessandria.desc);
		g.addEstensione(Alessandria.file);
		est.addGruppo(g);
		
		//Apre la finestra di salvataggio
		ScegliFile chooser = new ScegliFile(est);
		
		int ret = chooser.showSaveDialog(chooser);
		if (ret != JFileChooser.APPROVE_OPTION)
			return;
		File file = chooser.getSelectedFile();
		
		//Salva la biblioteca
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(table.getBiblioteca());
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "Impossibile salvare", "", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "Impossibile salvare", "", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
