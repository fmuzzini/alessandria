import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;


/**
 * Filtro per le estensioni.
 * <p>
 * Utilizzato per filtrare gruppi di file.
 * <p>
 * Utiliti per ottenere l'estensione di un file.
 * @author filippo
 *
 */
public class FiltroEstensioni implements FileFilter {
	
	private String regex;
	
	/**
	 * Inizializza il filtro con le
	 * estensioni passate.
	 * 
	 * @param ext Estensioni
	 */
	public FiltroEstensioni(ArrayList<String> ext){
		regex = "^(";
		for (String str : ext)
			regex += "(" + str.toUpperCase() + ")|";
		regex = regex.substring(0, regex.length()-1);
		regex += ")$";
	}

	@Override
	public boolean accept(File file) {
		String ext = getEstensione(file);
		
		return ext.matches(this.regex);
	}
	
	/**
	 * Restituisce l'estensione del file.
	 * 
	 * @param f File
	 * @return Estensione
	 */
	public static String getEstensione(File f){
		String path = f.getAbsolutePath();
		String ext = "";
		int punto = path.lastIndexOf('.');
		if (punto != -1 && punto<(path.length()-1))
			ext = path.substring(punto+1).toUpperCase();
		
		return ext;
	}

}
