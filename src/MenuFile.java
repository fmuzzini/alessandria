import javax.swing.JMenu;


public class MenuFile extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public MenuFile(TabellaBiblioteca table){
		super("File");
		this.add(new ItemCarica());
		this.add(new ItemSalva(table));
		this.add(new ItemEsci());
	}

}
