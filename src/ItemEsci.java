import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class ItemEsci extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public ItemEsci(){
		super("Esci");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
