import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class PulsanteRimuovi extends PulsanteLaterale implements ActionListener {
	
	private int libri[];

	private static final long serialVersionUID = 1L;

	public PulsanteRimuovi(TabellaBiblioteca table) {
		super(table);
		this.setText("Rimuovi");
		this.addActionListener(this);
	}

	@Override
	public void libriSelezionati(int libri[]) {
		if (libri.length == 0){
			this.setEnabled(false);
			return;
		}
		
		this.setEnabled(true);
		this.libri = libri;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Biblioteca biblio = this.getBiblioteca();
		Arrays.sort(this.libri);
		for (int i=0; i<libri.length; i++){
			biblio.rimuoviLibro(libri[i]-i);
		}
		
		((ModelTableBiblioteca) this.getTable().getModel()).fireTableDataChanged();
		
	}
	
	

}
