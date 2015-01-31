import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.RowSorterEvent;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * Classe che fornisce una rappresentazione
 * grafica della biblioteca.
 * <p>
 * Fornisce inoltre i metodi per visualizzare
 * il risultato di una ricerca.
 * 
 * @author Filippo Muzzini
 *
 */
public class TabellaBiblioteca extends JTable implements ListSelectionListener, Cloneable {
	
	private int iterRis;
	private String strRic;
	private ArrayList<SelezioneListener> selezioneListener;
	

	private static final long serialVersionUID = 1L;

	/**
	 * Inizializza la tabella cercando di
	 * settare la larghezza delle colonne
	 * in modo da visualizzare tutti i dati
	 * e inizializza i parametri per la ricerca.
	 * 
	 * @param dm Table Model
	 */
	public TabellaBiblioteca(ModelTableBiblioteca dm) {
		super(dm);
		
		this.setAutoCreateRowSorter(true);
		
		initRicerca();
		this.strRic = "";
		
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.getSelectionModel().addListSelectionListener(this);
		
		this.selezioneListener = new ArrayList<SelezioneListener>();
		
		this.aggiustaLarghezza();
	}
	
	/**
	 * Ritorna la biblioteca riferita 
	 * alla tabella.
	 * 
	 * @return Biblioteca
	 */
	public Biblioteca getBiblioteca(){
		return ((ModelTableBiblioteca) this.getModel()).getBiblioteca();
	}

	/**
	 * Cerca e visualizza il primo risultato
	 * di una ricerca.
	 * 
	 * @param str Chiave della ricerca
	 */
	public void ricerca(String str){
		initRicerca();
		strRic = str.toUpperCase();
		prossRis();
	}
	
	

	/**
	 * Cerca e visualizza il risultato
	 * successivo dell'ultima ricerca.
	 */
	public void prossRis(){			
		int row = iterRis;
		int righe = this.getRowCount();
		int col;
		boolean ris = false;
		
		togliSelezione();
		
		for (; row < righe; row++) {
			col = 0;
			for (; col<this.getColumnCount(); col++){
				if (this.getValueAt(row, col).toString().toUpperCase().contains(strRic)){
					ris = true;
					iterRis = row + 1;
					break;
				}
			}
			if (ris == true)
				break;
			
		}
		
		if (ris == false){
			if (iterRis == 0)
				JOptionPane.showConfirmDialog(this, "Nessun Risultato", "Ricerca Terminata", JOptionPane.CLOSED_OPTION);
			else
				JOptionPane.showConfirmDialog(this, "Fine Risultati", "Ricerca Terminata", JOptionPane.CLOSED_OPTION);
			
			initRicerca();
			return;
		}			
		
		mettiSelezione(row);
	}
	
	/**
	 * Pulisce la selezione della tabella
	 */
	private void togliSelezione(){
		this.clearSelection();
	}
	
	/**
	 * Seleziona la riga passata
	 * @param row Riga
	 */
	private void mettiSelezione(int row){
		this.getSelectionModel().setSelectionInterval(row, row);
	}
	
	/**
	 * Notifica agli ascoltatori il cambio
	 * di selezione.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e){
		super.valueChanged(e);
		
		if (e.getValueIsAdjusting())
			return;
		
		int selezione[] = this.getSelectedRows();
		int libri[] = new int[selezione.length];
		
		for (int i=0; i<selezione.length; i++)
			libri[i] = this.convertRowIndexToModel(selezione[i]);
		
		for (int i=0; i<this.selezioneListener.size(); i++)
			this.selezioneListener.get(i).libriSelezionati(libri);
	}
	
	/**
	 * Aggiunge un listener che viene chiamato
	 * al variare della selezione
	 * 
	 * @param listener Oggetto ascoltatore
	 */
	public void addSelezioneListener(SelezioneListener listener){
		this.selezioneListener.add(listener);
	}

	/**
	 * Cambia la biblioteca associata a questa
	 * tabella
	 * 
	 * @param biblio Nuova Biblioteca
	 */
	public void cambioBiblioteca(Biblioteca biblio) {
		this.getModel().setBiblioteca(biblio);
		
		initRicerca();
		this.aggiustaLarghezza();
	}
	
	/**
	 * Setta le larghezze delle colonne affinche
	 * siano visibili tutte le informazioni.
	 * 
	 */
	public void aggiustaLarghezza() {
		for (int column = 0; column < this.getColumnCount(); column++)
		{
		    TableColumn tableColumn = this.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
		 
		    for (int row = 0; row < this.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = this.getCellRenderer(row, column);
		        Component c = this.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + this.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		 
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		 
		    tableColumn.setPreferredWidth(preferredWidth);
		}		
	}
	
	/**
	 * Quando l'ordinamento cambia
	 * la ricerca viene fatta ripartire
	 * dalla prima riga
	 */
	@Override
	public void sorterChanged(RowSorterEvent e){		
		togliSelezione();
		initRicerca();		
	}
	
	@Override
	public ModelTableBiblioteca getModel(){
		return (ModelTableBiblioteca) super.getModel();
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	/**
	 * Inizializza i parametri di ricerca
	 */
	private void initRicerca() {
		iterRis = 0;
	}
}
