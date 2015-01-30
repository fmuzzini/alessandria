import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Dialog che consente si specificare
 * la cartella dei file da importare e
 * i filtri sui file da importare
 * 
 * @author Filippo Muzzini
 *
 */
public class OpzioniCartella extends JDialog implements ItemListener, ActionListener {
	
	public static final int OK = 1;
	public static final int ANNULLA = 0;
	
	private File cartella;
	private JCheckBox sub;
	private JCheckBox all;
	private ArrayList<JCheckBox> leggibili;
	private JTextField altri;
	private JButton seleziona;
	private JButton annulla;
	private int res;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Inizializza il dialog
	 * 
	 * @param comp Componente padre
	 */
	public OpzioniCartella(Component comp){
		super(SwingUtilities.windowForComponent(comp), "Opzioni slezione", ModalityType.APPLICATION_MODAL);
		this.setLayout(new BorderLayout());
		
		this.leggibili = new ArrayList<JCheckBox>();
		
		JPanel sx = new JPanel();
		sx.setLayout(new BoxLayout(sx, BoxLayout.Y_AXIS));
		this.sub = new JCheckBox("Includi sotto-cartelle");
		this.all = new JCheckBox("Utilizza file di qualsiasi formato");
		this.all.addItemListener(this);
		sx.add(this.sub);
		sx.add(this.all);
		this.add(BorderLayout.WEST, sx);
		
		JPanel dx = new JPanel();
		dx.setLayout(new BoxLayout(dx, BoxLayout.Y_AXIS));
		dx.add(new JLabel("Selezionare formati da utilizzare"));
		for(int i=0; i<Alessandria.libriLeggibili.length; i++){
			JCheckBox c = new JCheckBox(Alessandria.libriLeggibili[i]);
			dx.add(c);
			this.leggibili.add(c);
		}
		dx.add(new JLabel("Specificare eventuali altri formati "));
		this.altri = new JTextField();
		dx.add(this.altri);
		this.add(BorderLayout.EAST, dx);
		
		JPanel foot = new JPanel();
		this.seleziona = new JButton("Seleziona");
		this.annulla = new JButton("Annulla");
		this.seleziona.addActionListener(this);
		this.annulla.addActionListener(this);
		foot.add(seleziona);
		foot.add(annulla);
		this.add(BorderLayout.SOUTH, foot);
		
		this.pack();
	}
	
	/**
	 * Ritorna il tasto premuto
	 * 
	 * @return Tasto Premuto (OK o Annulla)
	 */
	public int getRes(){
		return this.res;
	}
	
	/**
	 * Ritorna il valore di subDir
	 * Indica se bisogna considerare anche le
	 * sottocartelle
	 * 
	 * @return Valore SubDir
	 */
	public boolean isSubDir(){
		return this.sub.isSelected();
	}
	
	/**
	 * Ritorna il valore di AllFile
	 * Indica se bisogna considerare tutti
	 * i file
	 * 
	 * @return Valore di allFile
	 */
	public boolean isAllFile(){
		return this.all.isSelected();
	}
	
	/**
	 * Ritorna la cartella selezionata
	 * 
	 * @return Cartella selezionata
	 */
	public File getCartella(){
		return this.cartella;
	}
	
	/**
	 * Ritorna un filtro adatto a filtrare
	 * secondo i formati selezionati
	 * 
	 * @return Filtro
	 */
	public FiltroEstensioni  getFormati(){
		ArrayList<String> format = new ArrayList<String>();
		
		//Tutti i formati
		if (this.all.isSelected()){
			format.add("*");
			return new FiltroEstensioni(format);
		}
		
		//Aggiunta formati selezionati
		for(int i=0; i<this.leggibili.size(); i++)
			if (this.leggibili.get(i).isSelected())
				format.add(Alessandria.libriLeggibili[i]);
		
		//Aggiunta formati supplementari
		String regex = "[^A-Z\\d]";
		String[] exts = this.altri.getText().toUpperCase().split(regex);
		for (String str : exts){
			if(str.length()<1)
				continue;
			
			format.add(str);
		}
		
		return new FiltroEstensioni(format);
	}

	/**
	 * Se viene selezionato "tutti i file"
	 * si disattivano le selezioni dei formati
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Object source = arg0.getSource();
		
		if (source == this.all){
			boolean sel = !this.all.isSelected();
			this.altri.setEnabled(sel);
			for(JCheckBox c : this.leggibili)
				c.setEnabled(sel);
		}
	}

	/**
	 * Se annulla si chiude la finestra
	 * altrimenti si apre la selezione della cartella
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		
		if(source == this.annulla)
			this.res = OpzioniCartella.ANNULLA;
		
		if(source == this.seleziona){
			ScegliFile chooser = new ScegliFile(new Estensioni());
			chooser.setFileSelectionMode(ScegliFile.DIRECTORIES_ONLY);
			chooser.setMultiSelectionEnabled(false);
			
			int ret = chooser.showOpenDialog(this);
			if(ret == ScegliFile.APPROVE_OPTION){
				this.cartella = chooser.getSelectedFile();
				this.res = OpzioniCartella.OK;
			} else {
				this.res = OpzioniCartella.ANNULLA;
			}
		}
		
		this.setVisible(false);
	}

}
