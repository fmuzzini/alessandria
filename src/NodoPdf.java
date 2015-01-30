import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPage;


/**
 * Nodo che rappresenta una pagina pdf
 * 
 * @author Filippo Muzzini
 *
 */
public class NodoPdf {
	
	private int index;
	private PDPage pagina;
	private BufferedImage img;
	
	
	/**
	 * Inizializza il nodo
	 * 
	 * @param page Pagina
	 * @param index Numero di pagina
	 */
	public NodoPdf(PDPage page, int index){
		this.pagina = page;
		this.index = index;
		this.img = null;
	}
	
	/**
	 * Ritorna il render della pagina
	 * sotto forma di immagine
	 * 
	 * @return Immagine della pagina
	 */
	public BufferedImage getImg(){
		if (this.img == null)
			try {
				this.img = this.pagina.convertToImage();
			} catch (IOException e) {
				BufferedImage imm = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
				Graphics g = imm.getGraphics();
				g.drawString("Impossibile visualizzare la pagina", 0, 0);
				this.img = imm;
			}
		
		return this.img;
	}
	
	/**
	 * Ritorna la pagina
	 * @return Pagina
	 */
	public PDPage getPagina(){
		return this.pagina;
	}
	
	/**
	 * Setta la pagina
	 * @param page Pagina
	 */
	public void setRif(PDPage page){
		this.pagina = page;
	}
	
	/**
	 * Ritorna il numero di pagina
	 * @return Numero di pagina
	 */
	public int getIndex(){
		return this.index;
	}
	
	/**
	 * Ritorna la Stringa rappresentante
	 * la pagina (cioè il numero di pagina)
	 */
	public String toString(){
		return Integer.toString(this.index);
	}
	
}
