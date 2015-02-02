import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * Pulsante per l'aggiunta di
 * libri alla biblioteca
 * <p>
 * Anche se tale pulsante ha differenze di comportamento
 * rispetto alla superclasse {@link PulsanteLaterale}
 * è stata fatta la scelta di estenderlo comuque da tale
 * poichè vi sono metodi utili.
 * 
 * @author Filippo Muzzini
 *
 */
public class PulsanteAggiungi extends PulsanteLaterale {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il pulsante
	 * 
	 * @param table Tabella
	 */
	public PulsanteAggiungi(TabellaBiblioteca table){
		super(table);
		this.setText("Aggiungi");
		this.setEnabled(true);
		this.addActionListener(this);
	}

	/**
	 * Guida l'utente nella scelta dei file:
	 * Chiede se selezionare cartelle o singoli file
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Crea un dialog per la scelta
		String text = "Si desidera selezionare singoli file o un intera cartella?";
		String[] options = {"Singoli File", "Intera Cartella", "Annulla"};
		int res = JOptionPane.showOptionDialog(this, text, "", JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		
		//Lancia la funzione appropiata
		ArrayList<File> file = null;
		switch(res){
		case JOptionPane.YES_OPTION:
			file = selezionaFile();
			break;
		case JOptionPane.NO_OPTION:
			file = selezionaCartella();
			break;
		default:
			return;
		}
		
		if (file == null)
			return;
		
		Biblioteca biblio = this.getBiblioteca();
		
		//Controlla se il file è gia presente e poi
		//Mostra un dialog per l'iserimento dei dati e aggiunge i libri
		for (File f : file){
			if (biblio.controllaFile(f)){
				JOptionPane.showMessageDialog(this, "Il file:\n" + f.getAbsolutePath() + 
						"\nNon è stato aggiunto perchè già presente");
				continue;
			}
				
			Libro libro = Utilities.istanzaLibro(f);		
			DialogModifica mod = new DialogModifica(libro, this);
			mod.setVisible(true);
			
			//Se premuto Annulla non si aggiungono i libri successivi
			if (mod.getReturn() == DialogModifica.ANNULLA)
				break;
			
			biblio.aggiungiLibro(libro);
		}
		
	}
	
	@Override
	public void libriSelezionati(int[] libri) {
				
	}
	
	/**
	 * Mostra la selezione dei formati da considerare
	 * e successivamente la scelta della cartella
	 * 
	 * @return Lista dei file selezionati
	 */
	private ArrayList<File> selezionaCartella() {
		OpzioniCartella op = new OpzioniCartella(this);
		op.setVisible(true);
		
		if(op.getRes()!=OpzioniCartella.OK)
			return null;
		
		ArrayList<File> file = new ArrayList<File>();
		file.addAll(getFileDaDir(op.isAllFile(), op.getFormati(), op.getCartella(), op.isSubDir()));
		
		return file;
	}

	/**
	 * Crea ricorsivamente una lista di file
	 * figli della cartella considerando i filtri
	 * 
	 * @param allFile Considerare tutti i file
	 * @param filter Filtro dei file
	 * @param dir Cartella
	 * @param sub Considerare sottocartelle
	 * @return Lista dei file
	 */
	private ArrayList<File> getFileDaDir(boolean allFile, FileFilter filter, File dir, boolean sub) {
		ArrayList<File> file = new ArrayList<File>();
		File[] figli;
		
		if (allFile)
			figli = dir.listFiles();
		else
			figli = dir.listFiles(filter);
		
		for(File f : figli){
			if (f.isHidden())
				continue;
			
			if (sub && f.isDirectory())
				file.addAll(getFileDaDir(allFile, filter, f, sub));
			
			if (f.isFile())
				file.add(f);
		}
		
		return file;
	}

	/**
	 * Apre una finestra per la selezione dei file
	 * 
	 * @return Lista dei file selezionati
	 */
	private ArrayList<File> selezionaFile() {
		Estensioni est = new Estensioni();
		GruppoEstensioni g = new GruppoEstensioni("Libri Leggibili");
		g.addEstensione(Utilities.getAllEstLegg());
		est.addGruppo(g);
		est.setAltriFile(true);
		
		ScegliFile chooser = new ScegliFile(est);
		chooser.setMultiSelectionEnabled(true);
		
		int res = chooser.showOpenDialog(this);
		
		if (res != ScegliFile.APPROVE_OPTION)
			return null;
		
		File[] file = chooser.getSelectedFiles();
		ArrayList<File> ret = new ArrayList<File>(Arrays.asList(file));
		return ret;
	}

	

}
