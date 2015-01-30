import 
javax.swing.JPanel;

/**
 * Pannello Ricerca
 * <p>
 * Contiene {@link CampoRicerca} e {@link PulsanteRicerca}
 * 
 * @author Filippo Muzzini
 *
 */
public class PannelloRicerca extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il pannello
	 * e associa i componenti alla tabella
	 * 
	 * @param table Tabella
	 */
	public PannelloRicerca(TabellaBiblioteca table){
		super();
		CampoRicerca campo = new CampoRicerca(table);
		this.setMaximumSize(getMinimumSize());
		this.add(campo);
		this.add(new BottoneRicerca(campo));
	}

}
