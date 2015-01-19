import javax.swing.JButton;


public abstract class PulsanteLaterale extends JButton implements SelezioneListener {
	
	private TabellaBiblioteca table;

	private static final long serialVersionUID = 1L;
	
	public PulsanteLaterale(TabellaBiblioteca table){
		super();
		this.table = table;
		this.setEnabled(false);
	}
	
	public Biblioteca getBiblioteca(){
		return this.table.getBiblioteca();
	}
	
	public TabellaBiblioteca getTable(){
		return this.table;
	}

}
