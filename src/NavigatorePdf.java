import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageNode;

/**
 * Gestisce la navigazione e la visualizzazione
 * dei documenti pdf
 * 
 * @author Filippo Muzzini
 *
 */
public class NavigatorePdf {
	
	private NodoPdf[] nodi;
	private int attuale;
	private ArrayList<CambioPaginaListenerPdf> listenerList;
	
	/**
	 * Inizializza il navigatore.
	 * <p>
	 * Crea una lista delle pagine del documento
	 * sotto forma di nodi
	 * 
	 * @param doc Documento
	 */
	public NavigatorePdf(PDDocument doc){
		
		PDDocumentCatalog catalog = doc.getDocumentCatalog();
		PDPageNode pages = catalog.getPages();
		List<PDPage> lista = getPageList(pages);
		
		this.nodi = new NodoPdf[lista.size()];
		
		for(int i=0; i<lista.size(); i++){
			NodoPdf nodo = new NodoPdf(lista.get(i), i);
			this.nodi[i] = nodo;
		}
		
		this.attuale = 0;
		this.listenerList = new ArrayList<CambioPaginaListenerPdf>();
	}
	
	/**
	 * Passa alla pagine successiva
	 */
	public void nextPage(){
		gotoPage(this.attuale + 1);
	}
	
	/**
	 * Passa alla pagina precedente
	 */
	public void previousPage(){
		gotoPage(this.attuale - 1);
	}
	
	/**
	 * Va alla pagina specificata
	 * 
	 * @param index Pagina
	 */
	public void gotoPage(int index){
		if (index >= 0 && index < this.nodi.length)
			this.attuale = index;
		
		System.out.println("index: " + index);
		paginaCambiata();
	}
	
	/**
	 * Notifica agli ascoltatori che la pagina è cambiata
	 */
	private void paginaCambiata() {
		for (CambioPaginaListenerPdf listener : this.listenerList)
			listener.paginaCambiata(this.nodi[this.attuale]);
	}

	/**
	 * Aggiunge un'ascoltatore
	 * 
	 * @param listener Ascoltatore
	 */
	public void addCambioPaginaListener(CambioPaginaListenerPdf listener){
		this.listenerList.add(listener);
	}
	
	/**
	 * Ritorna la lista dei nodi
	 * 
	 * @return Lista dei nodi
	 */
	public NodoPdf[] getNodi(){
		return this.nodi;
	}

	/**
	 * Metodo chiamato dalla barra di
	 * navigazione quando viene selezionata
	 * una pagina
	 * 
	 * @param sel Indice della pagina
	 */
	public void selezioneCambiata(int sel) {
		this.gotoPage(sel);		
	}
	
	/**
	 * Ritorna la pagina attuale
	 * sotto forma di nodo
	 * 
	 * @return Pagina
	 */
	public NodoPdf getAttuale(){
		return this.nodi[this.attuale];
	}
	
	/**
	 * Crea ricorsivamente la lista dei figli
	 * di un nodo
	 * 
	 * @param root Nodo
	 * @return Lista dei figli
	 */
	private List<PDPage> getPageList(PDPageNode root) {
		List<PDPage> pages = new ArrayList<PDPage>();
		
		@SuppressWarnings("rawtypes")
		List figli = root.getKids();
		
		for(int i=0; i<figli.size(); i++){
			Object obj = figli.get(i);
			
			if(obj instanceof PDPage)
				pages.add((PDPage) obj);
			
			if(obj instanceof PDPageNode){
				List<PDPage> res = getPageList((PDPageNode) obj);
				pages.addAll(res);
			}
		}
		
		return pages;
	}
	
}
