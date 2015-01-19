import javax.swing.JPanel;


public class PannelloRicerca extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public PannelloRicerca(TabellaBiblioteca table){
		super();
		CampoRicerca campo = new CampoRicerca(table);
		this.setMaximumSize(getMinimumSize());
		this.add(campo);
		this.add(new BottoneRicerca(campo));
	}

}
