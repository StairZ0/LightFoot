package lightFoot;

import java.awt.Rectangle;

import javax.swing.JPanel;

public class Tile extends JPanel {
	
	private JPanel content;
	
	public void addPanel(JPanel panel) {
		this.add(panel);
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
