import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;


public class DialogModifica extends JDialog {

	private Libro libro;
	private JTextField titolo;
	private JTextField autore;
	private JSpinner anno;
	private JSpinner pagine;
	
	private static final long serialVersionUID = 1L;
	
	public DialogModifica(Libro libro, Component comp){
		super(SwingUtilities.windowForComponent(comp), "Modifica Informazioni Libro");
		this.libro = libro;
		
		this.setLayout(new GridLayout(6,2,5,5));
		
		JTextField file = new JTextField(libro.getFile());
		file.setEditable(false);
		file.setEnabled(false);
		
		titolo = new JTextField(20);
		autore = new JTextField(20);
		anno = new JSpinner();
		pagine = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		
		this.add(new JLabel("File"));
		this.add(file);
		this.add(new JLabel("Titolo"));
		this.add(titolo);
		this.add(new JLabel("Autore"));
		this.add(autore);
		this.add(new JLabel("Anno"));
		this.add(anno);
		this.add(new JLabel("Pagine"));
		this.add(pagine);
		
		this.add(new JButton("OK"));
		this.add(new JButton("Annulla"));
		
		this.pack();
	}

}
