import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class PulsanteAggiungi extends JButton implements ActionListener {
	
	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	public PulsanteAggiungi(TabellaBiblioteca table){
		super("Aggiungi");
		this.table = table;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DialogModifica f = new DialogModifica(new LibroProva("", "", "", 0, 0), this);
		f.setVisible(true);
		((ModelTableBiblioteca) (table.getModel())).fireTableDataChanged();
		
	}

}
