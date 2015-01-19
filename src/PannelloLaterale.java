import java.awt.GridLayout;

import javax.swing.JPanel;


public class PannelloLaterale extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PannelloLaterale(TabellaBiblioteca table){
		super();
		this.setLayout(new GridLayout(4,1));
		this.add(new PannelloRicerca(table));
		this.add(new PulsanteAggiungi(table));
		
		PulsanteRimuovi rimuovi = new PulsanteRimuovi(table);
		PulsanteModifica modifica = new PulsanteModifica(table);
		table.addSelezioneListener(modifica);
		table.addSelezioneListener(rimuovi);
		
		this.add(modifica);
		this.add(rimuovi);
	}

}
