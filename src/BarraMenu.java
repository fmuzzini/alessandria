import javax.swing.JMenuBar;


public class BarraMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	public BarraMenu(TabellaBiblioteca table){
		super();
		this.add(new MenuFile(table));
		
	}

}
