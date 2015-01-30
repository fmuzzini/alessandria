import java.util.ArrayList;
import java.util.Iterator;

/**
 * Raggruppamento di gruppi di estensioni
 * <p>
 * Utilizzato per settare i filtri nelle selezioni di file
 * 
 * @author Filippo Muzzini
 *
 */
public class Estensioni implements Iterable<GruppoEstensioni> {
	
	private boolean altriFile;
	private ArrayList<GruppoEstensioni> gruppi;
	
	/**
	 * Inizializza il ragruppamento
	 */
	public Estensioni(){
		this.altriFile = false;
		this.gruppi = new ArrayList<GruppoEstensioni>();
	}
	
	/**
	 * Aggiunge un gruppo
	 * 
	 * @param gruppo Gruppo da aggiungere
	 */
	public void addGruppo(GruppoEstensioni gruppo){
		this.gruppi.add(gruppo);
	}
	
	/**
	 * Indica se inserire anche il gruppo "Tutti i file"
	 * 
	 * @param file Se True viene inserito il gruppo altri file
	 */
	public void setAltriFile(boolean file){
		this.altriFile = file;
	}
	
	/**
	 * Ritorna il valore di AltriFile
	 * 
	 * @return Valore di ALtriFile
	 */
	public boolean isAltriFile(){
		return this.altriFile;
	}
	
	/**
	 * Ritorna la lista di gruppi
	 * 
	 * @return Lista di gruppi
	 */
	public ArrayList<GruppoEstensioni> getGruppi(){
		return this.gruppi;
	}

	@Override
	public Iterator<GruppoEstensioni> iterator() {
		return this.gruppi.iterator();
	}
	
}
