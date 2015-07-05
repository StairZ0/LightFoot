package lightFoot;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Le JPanel transparent sur lequel les JPanels vont glisser
 * 
 * @author de le He
 * 
 * @see ContainerPanel, Pixel
 *
 */
public class TransparentPanel extends JPanel {

	private ContainerPanel container;
	
	private JPanel current;
	
	public TransparentPanel (ContainerPanel container){
		this.container=container;
		setOpaque(false);
	}
	
	/**
	 * Copie le JPanel à glisser dans le TransparentPanel
	 * 
	 * @param panel JPanel à faire glisser
	 * @param pixel localisation initiale de panel
	 */
	public void receive(JPanel panel, Pixel pixel){
		Dimension size = panel.getSize();
		current = panel;
		add(current);
		current.setLocation(pixel.getX(), pixel.getY());
		current.setSize(size);
		//current.setBackground(new Color(0,0,0,64)); //Je grise mon Panel pour les distinguer
		
	}
	
	
	/**
	 * Repaint le panel current dans TransparentPanel pendant le drag
	 * 
	 * @param pixel localisation actuelle de la souris
	 */	
	public void fireDragEvent(Pixel pixel){
		current.setLocation(pixel.getX(), pixel.getY());
		repaint();
	}
	
	/**
	 * Remove le panel current du TransparentPanel après la fin du drag
	 * et envoie le JPanel current et pixel au ContainerPanel
	 * 
	 * @param pixel localisation finale de la souris après le drag
	 */	
	public void fireMouseReleaseEvent(Pixel pixel){
		
		container.sendToDraggablePanel(current, pixel);
		remove(current);
		revalidate();
		// container.remove(pixel); container.add(current); conbtainer.repaint();
		repaint(); //container.repaint => container.repaint & this.repaint ???
	}
}
