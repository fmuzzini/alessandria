import javax.swing.JMenu;

/**
 * Menu file.
 * 
 * @author Filippo Muzzini
 *
 */
public class MenuFile extends JMenu {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea il menù file e associa gli elementi alla tabella.
	 * 
	 * @param table Tabella a cui associare gli elementi
	 */
	public MenuFile(TabellaBiblioteca table){
		super("File");
		this.add(new ItemCarica(table));
		this.add(new ItemSalva(table));
		this.add(new ItemStampa(table));
		this.add(new ItemEsci());
	}

}
