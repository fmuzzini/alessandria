import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 * Item Aiuto
 * @author Filippo Muzzini
 *
 */
public class ItemAiuto extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public ItemAiuto(){
		super("Aiuto");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame frame = new FinestraAiuto();
		frame.setVisible(true);
	}
	
}
