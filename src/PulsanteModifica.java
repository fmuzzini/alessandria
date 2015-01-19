import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class PulsanteModifica extends PulsanteLaterale implements ActionListener {
	
	private int libro;

	private static final long serialVersionUID = 1L;

	public PulsanteModifica(TabellaBiblioteca table) {
		super(table);
		this.setText("Modifica");
		this.addActionListener(this);
	}

	@Override
	public void libriSelezionati(int[] libri) {
		if (libri.length != 1){
			this.setEnabled(false);
			return;
		}
		
		this.setEnabled(true);
		this.libro = libri[0];
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Biblioteca biblio = this.getBiblioteca();
		DialogModifica frame = new DialogModifica(biblio.getLibro(libro), this);
		frame.setVisible(true);
	}
	
	

}
