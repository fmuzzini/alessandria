import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Item aiuto
 * @author Filippo Muzzini
 *
 */
public class ItemInfo extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public ItemInfo(){
		super("Info");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = "Alessandria - Biblioteca Ebook\n\n"
				+"Filippo Muzzini";
		
		JOptionPane.showMessageDialog(this, text, "Alessandria", JOptionPane.INFORMATION_MESSAGE);
	}

}
