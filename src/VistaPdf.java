import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Pannello per la visualizzazione di una pagina pdf
 * 
 * @author Filippo Muzzini
 *
 */
public class VistaPdf extends JLabel implements CambioPaginaListenerPdf {

	private NodoPdf nodo;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il pannello
	 * 
	 * @param nav Navigatore
	 */
	public VistaPdf(NavigatorePdf nav){
		super();
		this.nodo = nav.getAttuale();
		
		cambiaImmagine();		
	}
	
	/**
	 * Visualizza la pagina passata come
	 * parametro
	 */
	@Override
	public void paginaCambiata(NodoPdf nodo) {
		this.nodo = nodo;
		
		cambiaImmagine();
	}
	
	/**
	 * Ridisegna il pannello con 
	 * la pagina attuale
	 */
	private void cambiaImmagine() {
		BufferedImage img = this.nodo.getImg();
		this.setIcon(new ImageIcon(img));
		
		this.repaint();
	}
}
