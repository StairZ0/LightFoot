package lightFoot;

import java.awt.Rectangle;

import javax.swing.JPanel;

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
		this.content = content;
		this.index = index;
	}
	
	/**
	 * Constructeur
	 * @param index : index de la tile dans la grille
	 */
	public Tile(Index2D index) {
		this.index = index;
		this.content = null;
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
			this.add(content);
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

}
