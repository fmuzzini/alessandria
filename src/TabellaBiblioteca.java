import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;

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
public class TabellaBiblioteca extends JTable implements ListSelectionListener {
	
	private int iterRis;
	private String strRic;
	private ArrayList<SelezioneListener> selezioneListener;

	private static final long serialVersionUID = 1L;

	/**
	 * @param dm Table Model
	 */
	public TabellaBiblioteca(ModelTableBiblioteca dm) {
		super(dm);
		
		this.setAutoCreateRowSorter(true);
		
		this.iterRis = 0;
		this.strRic = "";
		
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.getSelectionModel().addListSelectionListener(this);
		
		this.selezioneListener = new ArrayList<SelezioneListener>();
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
		iterRis = 0;
		strRic = str.toUpperCase();
		prossRis();
	}
	
	/**
	 * Cerca e visualizza il risultato
	 * successivo dell'ultima ricerca.
	 */
	public void prossRis(){		
		int row = iterRis;
		int col;
		boolean ris = false;
		
		togliSelezione();
		
		for (; row<this.getRowCount(); row++) {
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
			
			iterRis = 0;
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
	
	@Override
	public void tableChanged(TableModelEvent e){
		int iter = this.convertRowIndexToModel(this.iterRis);
		super.tableChanged(e);
		this.iterRis = this.convertRowIndexToView(iter);
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

}
