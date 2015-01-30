import java.awt.event.ActionEvent;

/**
 * Pulsante per la modifica di un libro
 * 
 * @author Filippo Muzzini
 *
 */
public class PulsanteModifica extends PulsanteLaterale {
	
	private int libro;

	private static final long serialVersionUID = 1L;

	/**
	 * Inizializza il pulsante
	 * 
	 * @param table Tabella
	 */
	public PulsanteModifica(TabellaBiblioteca table) {
		super(table);
		this.setText("Modifica");
		this.addActionListener(this);
	}

	/**
	 * Potendo modificare un libro alla volta
	 * attiva questo pulsante solo se è selezionato
	 * soltanto un libro
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
	 * Preleva il libro e apre il
	 * dialog per modificarlo
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Biblioteca biblio = this.getBiblioteca();
		DialogModifica frame = new DialogModifica(biblio.getLibro(libro), this);
		frame.setVisible(true);
		this.getBiblioteca().libroChange(libro);
	}
	
	

}
