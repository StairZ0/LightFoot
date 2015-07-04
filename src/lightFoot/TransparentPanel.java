package lightFoot;

import java.awt.Dimension;

import javax.swing.JPanel;


public class TransparentPanel extends JPanel {
	
	private ContainerPanel container;
	
	private JPanel current;
	
	TransparentPanel (ContainerPanel container){
		container = this.container;
		setOpaque(false);
	}

	public void receive(JPanel panel, Pixel pixel){
		Dimension size = panel.getSize();
		current = panel;
		add(current);
		current.setLocation(pixel.getX(), pixel.getY());
		current.setSize(size);
		
	}
	
	public void fireDragEvent(Pixel pixel){
		current.setLocation(pixel.getX(), pixel.getY());
		repaint();
	}
	
	public void fireMouseReleaseEvent(Pixel pixel){
		remove(current);
		container.sendToDraggablePanel(current, pixel);
		revalidate();
		// container.remove(pixel); container.add(current); conbtainer.repaint();
		repaint();
	}
}
