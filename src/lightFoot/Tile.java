package lightFoot;

import java.awt.Rectangle;

import javax.swing.JPanel;

import utils.Index2D;

public class Tile extends JPanel {
	
	private JPanel content;
	private Index2D index;
	
	public Tile(JPanel content, Index2D index) {
		this.content = content;
		this.index = index;
	}
	
	public Index2D getIndex() {
		return index;
	}

	public boolean addPanel(JPanel panel) {
		if(!isEmpty()) return false;
		else {
			content = panel;
			this.add(content);
			return true;
		}
		
	}
	public boolean contain(Pixel pixel) {
		Rectangle bounds = this.getBounds();
		return bounds.contains(pixel.getX(), pixel.getY());
	}
	
	public boolean isEmpty() {
		return content == null;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}
	
	public JPanel getContent() {
		return content;
	}

}
