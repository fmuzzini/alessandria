import java.util.ArrayList;

/**
 * Gruppo che rappresenta un dato tipo di file
 * e le estensioni ad esso associate.
 * 
 * @author Filippo Muzzini
 *
 */
public class GruppoEstensioni {

	private String desc;
	private ArrayList<String> exts;
	
	/**
	 * inizializza il gruppo con la descrizione
	 * 
	 * @param desc Descrizione
	 */
	public GruppoEstensioni(String desc){
		this.desc = desc;
		this.exts = new ArrayList<String>();
	}
	
	/**
	 * Aggiunge l'estenzione al gruppo.
	 * 
	 * @param ext Estensione
	 */
	public void addEstensione(String ext){
		this.exts.add(ext);
	}
	
	/**
	 * Ritorna l'elenco delle estensioni
	 * 
	 * @return Elenco delle estensioni
	 */
	public ArrayList<String> getEstensioni(){
		return this.exts;
	}
	
	/**
	 * Ritorna la descrizione del gruppo
	 * 
	 * @return Descrizione
	 */
	public String getDescrizione(){
		return this.desc;
	}

	/**
	 * Aggiunge l'estensione al gruppo
	 * 
	 * @param exts Estensione
	 */
	public void addEstensione(String[] exts) {
		for(String str : exts)
			this.addEstensione(str);
	}
	
}
