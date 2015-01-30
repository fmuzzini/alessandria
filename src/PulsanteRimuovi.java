import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * Pulsante per la rimozione dei libri
 * 
 * @author Filippo Muzzini
 *
 */
public class PulsanteRimuovi extends PulsanteLaterale {
	
	private int libri[];

	private static final long serialVersionUID = 1L;

	/**
	 * Inizializza il pulsante
	 * 
	 * @param table Tabella
	 */
	public PulsanteRimuovi(TabellaBiblioteca table) {
		super(table);
		this.setText("Rimuovi");
		this.addActionListener(this);
	}

	/**
	 * Il pulsante è attivo solo se
	 * sono selezionati dei libri
	 */
	@Override
	public void libriSelezionati(int libri[]) {
		if (libri.length == 0){
			this.setEnabled(false);
			return;
		}
		
		this.setEnabled(true);
		this.libri = libri;

	}

	/**
	 * Rimuove i libri selezionati
	 * dalla biblioteca
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Biblioteca biblio = this.getBiblioteca();
		Arrays.sort(this.libri);
		for (int i=0; i<libri.length; i++){
			biblio.rimuoviLibro(libri[i]-i);
		}
		
	}
	
	

}
