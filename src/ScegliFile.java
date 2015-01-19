import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ScegliFile extends JFileChooser {
	
	private String[] ext;

	private static final long serialVersionUID = 1L;
	
	public ScegliFile(String descrizione, String... estensioni){
		super();
		this.setFileFilter(new FileNameExtensionFilter(descrizione, estensioni));
		this.setAcceptAllFileFilterUsed(false);
		this.ext = estensioni;
	}
	
	@Override
	public int showSaveDialog(Component comp){
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.setMultiSelectionEnabled(false);
		
		int ret = super.showSaveDialog(comp);
		if (ret != JFileChooser.APPROVE_OPTION)
			return ret;
		
		File file = this.getSelectedFile();
		String path = file.getAbsolutePath();
		String ext = "";
		int punto = path.lastIndexOf('.');
		if (punto != -1 && punto<path.length())
			ext = path.substring(punto+1).toUpperCase();
		
		String regex = "^(";
		for (int i=0; i<this.ext.length; i++)
			regex += "(" + this.ext[i].toUpperCase() + ")|";
		regex = regex.substring(0, regex.length()-1);
		regex += ")$";
		
		System.out.println(regex);
		
		if (!ext.matches(regex))
			path = addExtension(path, this.ext[0]);
		
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
