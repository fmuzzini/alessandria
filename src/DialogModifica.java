import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 * Dialog che consente la modifica dei dati
 * di un libro.
 * 
 * @author Filippo Muzzini
 *
 */
public class DialogModifica extends JDialog implements ActionListener {

	private Libro libro;
	private JTextField titolo;
	private JTextField autore;
	private JSpinner anno;
	private JSpinner pagine;
	private JButton annulla;
	private JButton ok;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il Dialog.
	 * 
	 * @param libro Libro da modificare
	 * @param comp Componente padre
	 */
	public DialogModifica(Libro libro, Component comp){
		super(SwingUtilities.windowForComponent(comp), "Informazioni per " + libro.getFile().getName(), ModalityType.APPLICATION_MODAL);
		this.libro = libro;
		
		this.setLayout(new GridLayout(6,2,5,5));
		
		JTextField file = new JTextField(libro.getFile().toString(), 20);
		file.setEditable(false);
		file.setEnabled(false);
		
		titolo = new JTextField(libro.getTitolo(), 20);
		autore = new JTextField(libro.getAutore(), 20);
		anno = new JSpinner();
		pagine = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		anno.setValue(libro.getAnno());
		pagine.setValue(libro.getPagine());
		
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
		
		this.annulla = new JButton("Annulla");
		this.ok = new JButton("OK");
		
		this.annulla.addActionListener(this);
		this.ok.addActionListener(this);
		
		this.add(this.ok);
		this.add(this.annulla);
		
		this.pack();
	}

	/**
	 * Se viene il premuto il tasto di conferma
	 * si esegue un controllo sui campi 
	 * e si applicano le modifiche
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ok){
		
			try {
				this.anno.commitEdit();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(this, "Controllare il campo Anno", "", JOptionPane.ERROR_MESSAGE);
			}
		
			try {
				this.pagine.commitEdit();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(this, "Controllare il campo Pagine", "", JOptionPane.ERROR_MESSAGE);
			}
		
			libro.setTitolo(this.titolo.getText());
			libro.setAutore(this.autore.getText());
			libro.setAnno((Integer) this.anno.getValue());
			libro.setPagine((Integer) this.pagine.getValue());
		}
		
		this.dispose();
	
	}

}
