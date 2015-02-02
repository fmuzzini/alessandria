import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.table.AbstractTableModel;



/**
 * Classe Biblioteca.
 * <p>
 * Contiene le informazioni dell'intera
 * biblioteca compreso l'insieme di libri.
 * 
 * @author Filippo Muzzini
 *
 */
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private transient ArrayList<AbstractTableModel> models;	
	private ArrayList<Libro> libri;
	private HashSet<File> elencoFile;							
	
	/**
	 * Crea una biblioteca vuota.
	 */
	public Biblioteca(){
		libri = new ArrayList<Libro>();
		models = new ArrayList<AbstractTableModel>();
		elencoFile = new HashSet<File>();
	}
	
	/**
	 * Aggiunge un ascoltatore alla biblioteca.
	 * <p>
	 * Tale ascoltatore viene chiamato per ogni tipo
	 * di modifica
	 * 
	 * @param listener Ascoltatore
	 */
	public void addChangeListener(AbstractTableModel listener){
		if(models == null)
			models = new ArrayList<AbstractTableModel>();
		
		this.models.add(listener);
	}
	
	/**
	 * Ritorna il numero di libri della biblioteca.
	 * 
	 * @return Numero libri
	 */
	public int getNumeroLibri(){
		return libri.size();
	}
	
	/**
	 * Aggiunge un libro alla biblioteca.
	 * @param libro	Libro da aggiungere
	 */
	public void aggiungiLibro(Libro libro){
		int last = libri.size();
		libri.add(libro);
		elencoFile.add(libro.getFile());
		for(AbstractTableModel l : models)
			l.fireTableRowsInserted(last, last);
	}
	
	/**
	 * Rimuove il libro associato
	 * all'indice.
	 * 
	 * @param index	Indice del libro da rimuovere
	 * @return	Libro appena rimosso
	 */
	public Libro rimuoviLibro(int index){
		Libro libro = libri.remove(index);
		for(AbstractTableModel l : models)
			l.fireTableRowsDeleted(index, index);
		
		return libro;
	}
	
	/**
	 * Restituisce il libro associato
	 * all'indice.
	 * 
	 * @param index	Indice del libro
	 * @return	Libro associato all'indice
	 */
	public Libro getLibro(int index){
		return libri.get(index);
	}
	
	/**
	 * Chiamato quando un libro cambia
	 * le sue informazioni
	 * 
	 * @param index Indice del libro
	 */
	public void libroChange(int index){
		for(AbstractTableModel l : models)
			l.fireTableRowsUpdated(index, index);
	}

	/**
	 * Controlla se il file è già
	 * presente o meno.
	 * <p>
	 * Viene usato un Hashset poichè
	 * la ricerca scala meglio con
	 * l'ingrandirsi della biblioteca
	 * 
	 * @param f File da controllare
	 * @return risultato
	 */
	public boolean controllaFile(File f) {
		return this.elencoFile.contains(f);
	}
}
