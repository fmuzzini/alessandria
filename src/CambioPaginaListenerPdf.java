
/**
 * Interfaccia per ascoltatori Pdf.
 * <p>
 * Fornisce i metodi da utilizzare quando viene
 * cambiata pagina.
 * 
 * @author Filippo Muzzini
 *
 */
public interface CambioPaginaListenerPdf {
	
	/**
	 * Metodo chiamato al cambio pagina.
	 * 
	 * @param nodo Nuova pagina
	 */
	public void paginaCambiata(NodoPdf nodo);
}
