import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Barra di navigazione pdf
 * <p>
 * Fornisce un'iterfaccia grafica per
 * la navigazione delle pagine
 * 
 * @author Filippo Muzzini
 *
 */
public class NavPdf extends JPanel implements ListSelectionListener, CambioPaginaListenerPdf {
	
	private NavigatorePdf nav;
	private JList lista;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza la barra
	 * e la associa al navigatore
	 * 
	 * @param nav Navigatore
	 */
	public NavPdf(NavigatorePdf nav){
		this.nav = nav;
		NodoPdf[] nodi = nav.getNodi();
		this.lista = new JList(nodi);
		lista.addListSelectionListener(this);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setCellRenderer(new CellRenderNodoPdf());
		JScrollPane scroll = new JScrollPane(lista);
		this.add(scroll);
	}

	/**
	 * Notifica al navigatore il cambio
	 * di selezione
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int sel = this.lista.getSelectedIndex();
		this.nav.selezioneCambiata(sel);
	}

	/**
	 * Metodo chiamato al cambio di pagina.
	 * Seleziona nella lista la pagina attualmente
	 * visualizzata
	 */
	@Override
	public void paginaCambiata(NodoPdf nodo) {
		this.lista.setSelectedIndex(nodo.getIndex());		
	}
}
