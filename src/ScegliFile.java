import java.awt.Component;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Dialog per la scelta dei file
 * 
 * @author Filippo Muzzini
 *
 */
public class ScegliFile extends JFileChooser {
	
	private ArrayList<String> ext;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il Dialog
	 * Crea e inserisce i gruppi di estensione
	 *
	 * @param est Estensioni da utilizzare
	 */
	public ScegliFile(Estensioni est){
		super();
		this.ext = new ArrayList<String>();
		
		for(GruppoEstensioni gruppo : est){
			String[] ext = new String[0];
			ext = gruppo.getEstensioni().toArray(ext);
			this.setFileFilter(new FileNameExtensionFilter(gruppo.getDescrizione(), ext));
			this.ext.addAll(gruppo.getEstensioni());
		}
		
		this.setAcceptAllFileFilterUsed(est.isAltriFile());
	}
	
	/**
	 * Mostra il dialog di salvataggio
	 * e se il file esiste già chiede
	 * all'utente se efettuare la sovrascrittura
	 */
	@Override
	public int showSaveDialog(Component comp){
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.setMultiSelectionEnabled(false);
		
		int ret = super.showSaveDialog(comp);
		if (ret != JFileChooser.APPROVE_OPTION)
			return ret;
		
		//Preleva il file
		File file = this.getSelectedFile();
		String path = file.getAbsolutePath();
		
		//Crea filtro con estensioni concesse
		FiltroEstensioni filtro = new FiltroEstensioni(this.ext);
		
		//Se l'estensione non coincide viene aggiunta la prima
		//estensione presente nella lista di quelle concesse
		if( !filtro.accept(file) )
			path = addExtension(path, this.ext.get(0));
		
		/*String ext = "";
		int punto = path.lastIndexOf('.');
		if (punto != -1 && punto<path.length())
			ext = path.substring(punto+1).toUpperCase();
		
		String regex = "^(";
		for (int i=0; i<this.ext.size(); i++)
			regex += "(" + this.ext.get(i).toUpperCase() + ")|";
		regex = regex.substring(0, regex.length()-1);
		regex += ")$";
		
		if (!ext.matches(regex))
			path = addExtension(path, this.ext.get(0));*/
		
		file = new File(path);
		if (!file.exists()){
			this.setSelectedFile(new File(path));
			return JFileChooser.APPROVE_OPTION;
		}
		
		//il file esiste chiedo per sovrascrittura
		int res = JOptionPane.showConfirmDialog(this, "Il file esiste già. Sovrascriverlo?", "", JOptionPane.YES_NO_OPTION);
		if (res != JOptionPane.YES_OPTION)
			return JFileChooser.CANCEL_OPTION;
		
		this.setSelectedFile(new File(path));
		return JFileChooser.APPROVE_OPTION;
				
	}

	/**
	 * Aggiunge al path l'estensione
	 * 
	 * @param path Path del file
	 * @param ext Estensione da aggiungere
	 * @return Path completo di estensione
	 */
	private String addExtension(String path, String ext) {
		if (!(path.charAt(path.length()-1) == '.'))
			path += ".";
		
		path += ext;
		return path;
	}
}
