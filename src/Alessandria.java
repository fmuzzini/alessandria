import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Alessandria {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Biblioteca a = new Biblioteca();
		a.aggiungiLibro(new LibroProva("Uno studio in rosso", "Doyle", "..", 1880, 200));
		a.aggiungiLibro(new LibroProva("aUno studio in rosso", "eDoyle", "..", 1887, 100));
		a.aggiungiLibro(new LibroProva("..", "..","..", 0, 0));
		
		/*JFrame f = new JFrame();
		JPanel frame = new JPanel();
		f.add(frame);
		
		frame.setLayout(new BorderLayout());
		
		f.setJMenuBar(new BarraMenu());
		frame.add(BorderLayout.CENTER, new PannelloCentrale(a));
		frame.add(BorderLayout.SOUTH, new PannelloFooter(a));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);*/
		
		Finestra finestra = new Finestra(a);
		finestra.setVisible(true);
		
	}

}
