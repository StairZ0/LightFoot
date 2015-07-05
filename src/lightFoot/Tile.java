package lightFoot;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import utils.Index2D;

public class Tile extends JPanel {

	private JPanel content;
	private Index2D index;

	/**
	 * Constructeur
	 * @param content : panel contenu de la tile
	 * @param index	: index de la tile dans la grille
	 */
	public Tile(JPanel content, Index2D index) {
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		this.content = content;
		this.index = index;
		this.setBorder(BorderFactory.createLineBorder(Color.red));

	}
	
	/**
	 * Constructeur
	 * @param index : index de la tile dans la grille
	 */
	public Tile(Index2D index) {
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		this.index = index;
		this.content = null;
		this.setBorder(BorderFactory.createLineBorder(Color.red));

	}


	/**
	 * Méthode qui ajoute le panel comme contenu de la tile si elle n'est pas vide et ne fais rien sinn
	 * @param panel
	 * @return vrai si l'ajout a été effectué avec succès
	 */
	public boolean addPanel(JPanel panel) {
		if(!isEmpty()) return false;
		else {
			content = panel;
			this.add(content,"h 100%, w 100%");
			return true;
		}

	}

	/**
	 * Méthode qui rend vrai si le pixel est contenu dans la tile
	 * @param pixel
	 * @return vrai si le pixel est contenu dans la tile
	 */
	public boolean contains(Pixel pixel) {
		Rectangle bounds = this.getBounds();
		return bounds.contains(pixel.getX(), pixel.getY());
	}

	/**
	 * 
	 * @return return vrai si la tile n'est pas vide faux sinn
	 */
	public boolean isEmpty() {
		return content == null;
	}
	
	public void removePanel() {
		this.remove(content);
		content = null;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}

	public JPanel getContent() {
		return content;
	}

	public Index2D getIndex() {
		return index;
	}
	
	public String toString() {
		String s = index.toString();
		return s;
	}

}
