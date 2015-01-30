import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class VistaPdf extends JLabel implements CambioPaginaListenerPdf {

	private NodoPdf nodo;
	
	private static final long serialVersionUID = 1L;
	
	public VistaPdf(NavigatorePdf nav){
		super();
		this.nodo = nav.getAttuale();
		
		cambiaImmagine();		
	}
	
	@Override
	public void paginaCambiata(NodoPdf nodo) {
		this.nodo = nodo;
		
		cambiaImmagine();
	}
	
	private void cambiaImmagine() {
		BufferedImage img = this.nodo.getImg();
		this.setIcon(new ImageIcon(img));
		
		this.repaint();
	}
}
