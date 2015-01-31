import javax.swing.JMenu;

/**
 * Menu aiuto
 * 
 * @author Filippo Muzzini
 *
 */
public class MenuAiuto extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public MenuAiuto(){
		super("Aiuto");
		this.add(new ItemAiuto());
		this.add(new ItemInfo());
	}

}
