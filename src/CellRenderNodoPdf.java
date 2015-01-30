import java.awt.Component;
import java.awt.Image;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * Render per le miniature Pdf
 * 
 * @author Filippo Muzzini
 *
 */
public class CellRenderNodoPdf extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	/**
	 * Inizializza il render.
	 */
	public CellRenderNodoPdf(){
		super();
	}
	
	/**
	 * Prende l'immagine e la scala per
	 * renderla una miniatura.
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		NodoPdf nodo = (NodoPdf) value;
		Image img = nodo.getImg().getScaledInstance(100, -1, Image.SCALE_FAST);
		Icon ico = new ImageIcon(img);
	    label.setIcon(ico);
	    
	    return label;
	}

}
