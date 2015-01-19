import javax.swing.JPanel;


public class PannelloFooter extends JPanel {

	public PannelloFooter(TabellaBiblioteca table) {
		this.setMinimumSize(getMinimumSize());
		this.add(new EtichettaNumero(table));
		this.setMaximumSize(getMinimumSize());
	}

	private static final long serialVersionUID = 1L;
	
	

}
