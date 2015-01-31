import javax.swing.JMenuBar;

/**
 * Barra del menù.
 * 
 * @author Filippo Muzzini
 *
 */
public class BarraMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea la barra dei menu e associa gli item
	 * alla tabella
	 * 
	 * @param table Tabella a cui associate gli item
	 */
	public BarraMenu(TabellaBiblioteca table){
		super();
		this.add(new MenuFile(table));
		this.add(new MenuAiuto());
		
	}

}
