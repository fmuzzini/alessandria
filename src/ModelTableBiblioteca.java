import javax.swing.table.AbstractTableModel;

/**
 * Classe Modello per la tabella.
 * <p>
 * Fornisce i metodi per prelevare i dati
 * dalla biblioteca e mostrarli nella tabella
 * 
 * @author Filippo Muzzini
 *
 */
public class ModelTableBiblioteca extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Biblioteca biblioteca;
	
	static final private String campi[] = {"Titolo", "Autore", "Anno", "Pagine", "File"};
	
	/**
	 * @param biblioteca Biblioteca associata alla tebella
	 */
	public ModelTableBiblioteca(Biblioteca biblioteca){
		super();
		this.biblioteca = biblioteca;
	}
	
	@Override
	public int getColumnCount() {
		return campi.length;
	}
	
	@Override
	public String getColumnName(int col){
		return campi[col];
	}

	@Override
	public int getRowCount() {
		return biblioteca.getNumeroLibri();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Libro libro = biblioteca.getLibro(row);
		switch (col){
		case 0:
			return libro.getTitolo();
		case 1:
			return libro.getAutore();
		case 2:
			return libro.getAnno();
		case 3:
			return libro.getPagine();
		case 4:
			return libro.getFile();
		default:
			return null;
		}
		
	}
	
	/**
	 * Ritorna la biblioteca associata
	 * @return Biblioteca
	 */
	public Biblioteca getBiblioteca(){
		return this.biblioteca;
	}
	
	/**
	 * Setta la biblioteca da cui
	 * attingere i dati
	 * 
	 * @param biblioteca Biblioteca
	 */
	public void setBiblioteca(Biblioteca biblioteca){
		this.biblioteca = biblioteca;
	}

}
