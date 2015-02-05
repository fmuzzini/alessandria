import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utili strumenti per la generazione
 * dei formati leggibili
 * 
 * @author Filippo Muzzini
 *
 */
public class Utilities {
	
	private static final String[] leggibili = {"PDF", "EPub"};
	private static final String[] pdf = {"PDF"};
	private static final String[] epub = {"EPUB"};
	
	/**
	 * Viene istanziato un libro 
	 * in base al suo formato
	 * 
	 * @param file File
	 * @return Libro
	 */
	public static Libro istanzaLibro(File file){
		String ext = FiltroEstensioni.getEstensione(file).toUpperCase();
		
		if (isFormato(pdf, ext))
			return new LibroPdf(file);
		
		if (isFormato(epub, ext))
			return new LibroEpub(file);
		
		return new Libro(file);
	}
	
	/**
	 * Ritorna i nomi dei formati leggibili
	 * @return Formati leggibili
	 */
	public static String[] getLeggibili(){
		return leggibili;
	}
	
	public static String[] getAllEstLegg(){
		String[] formati = getLeggibili();
		ArrayList<String> est = new ArrayList<String>();
		
		for(String f : formati)
			est.addAll(getEstensioni(f));
		
		String[] ret = new String[0];
		ret = est.toArray(ret);
		return ret;
	}
	
	/**
	 * Ritorna le estensioni associate al
	 * formato
	 * 
	 * @param formato Formato
	 * @return Estensioni
	 */
	public static List<String> getEstensioni(String formato){
		if (formato.equals("PDF"))
			return Arrays.asList(pdf);
		
		if (formato.equals("EPub"))
			return Arrays.asList(epub);
		
		return null;
	}

	/**
	 * Controlla che l'estensione corrisponda
	 * al formato
	 * 
	 * @param formato Formato
	 * @param ext Estensione
	 * @return Corrispondenza
	 */
	private static boolean isFormato(String[] formato, String ext) {
		for(String f : formato)
			if (ext.equals(f))
				return true;
		
		return false;
	}
	
}
