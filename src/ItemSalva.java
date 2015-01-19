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


public class ItemSalva extends JMenuItem implements ActionListener {
	
	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	public ItemSalva(TabellaBiblioteca table){
		super("Salva Biblioteca");
		this.addActionListener(this);
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ScegliFile chooser = new ScegliFile("Biblioteca Alessandria", "ba");
		
		int ret = chooser.showSaveDialog(chooser);
		if (ret != JFileChooser.APPROVE_OPTION)
			return;
		File file = chooser.getSelectedFile();
		
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(table.getBiblioteca());
		} catch (FileNotFoundException e1) {
			JOptionPane.showConfirmDialog(this, "Impossibile salvare", "", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e1) {
			JOptionPane.showConfirmDialog(this, "Impossibile salvare", "", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
