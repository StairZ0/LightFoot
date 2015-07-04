package lightFoot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import utils.LayeredPane;

public class ContainerPanel extends LayeredPane {
	
	private DraggablePanel draggablePanel;
	private TransparentPanel transparentPanel;
	
	
	public ContainerPanel(int width,int height)
	{
		draggablePanel = new DraggablePanel(this,width,height);
		transparentPanel = new TransparentPanel(this);
		add(draggablePanel,JLayeredPane.DEFAULT_LAYER);
		add(transparentPanel,JLayeredPane.DRAG_LAYER);
	}
	
	
	
	
	
	
	protected void sendToTransparentPanel(JPanel panel,Pixel pixel )
	{
		transparentPanel.receive(panel, pixel);
	}
	protected void sendToDraggablePanel(JPanel panel,Pixel pixel)
	{
		draggablePanel.receive(panel, pixel);
	}
	
	
	class EventHandler implements MouseListener,MouseMotionListener
	{

		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			draggablePanel.fireMousePressedEvent(new Pixel(e.getX(),e.getY()));
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} 

