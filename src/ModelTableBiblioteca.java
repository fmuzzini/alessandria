import javax.swing.table.AbstractTableModel;


public class ModelTableBiblioteca extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Biblioteca biblioteca;
	
	/**
	 * @param biblioteca Biblioteca associata alla tebella
	 */
	public ModelTableBiblioteca(Biblioteca biblioteca){
		super();
		this.biblioteca = biblioteca;
	}
	
	@Override
	public int getColumnCount() {
		return Libro.getNumeroCampi();
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
		default:
			return null;
		}
		
	}

}
