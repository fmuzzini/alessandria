import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Pannello Laterale
 * <p>
 * Contiene i comandi per modifcare e
 * cercare i dati
 * 
 * @author Filippo Muzzini
 *
 */
public class PannelloLaterale extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il pannello laterale
	 * e associa i componenti alla tabella
	 * 
	 * @param table Tabella
	 */
	public PannelloLaterale(TabellaBiblioteca table){
		super();
		this.setLayout(new GridLayout(5,1));
		this.add(new PannelloRicerca(table));
		this.add(new PulsanteAggiungi(table));
		
		PulsanteRimuovi rimuovi = new PulsanteRimuovi(table);
		PulsanteModifica modifica = new PulsanteModifica(table);
		PulsanteVisualizza visualizza = new PulsanteVisualizza(table);
		table.addSelezioneListener(modifica);
		table.addSelezioneListener(rimuovi);
		table.addSelezioneListener(visualizza);
		
		this.add(visualizza);
		this.add(modifica);
		this.add(rimuovi);
	}

}
