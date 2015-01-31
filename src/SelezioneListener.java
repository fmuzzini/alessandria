
/**
 * Interfaccia per gli ascoltatori
 * del cambio di selezione.
 * 
 * @author Filippo Muzzini
 *
 */
public interface SelezioneListener {
	
	/**
	 * Metodo chiamato al cambio di selezione.
	 * 
	 * @param libri Libri selezionati (indice del modello)
	 */
	public void libriSelezionati(int[] libri);

}
