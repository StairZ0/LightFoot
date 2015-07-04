package lightFoot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import utils.Index2D;
import utils.LayeredPane;

public class ContainerPanel extends LayeredPane {
	
	private DraggablePanel draggablePanel;
	private TransparentPanel transparentPanel;
	private EventHandler eventHandler;
	private Pixel lastPixelPosition;
	private int width;
	private int height;

	
	
	public ContainerPanel(int width,int height)
	{
		this.width=width;
		this.height=height;
		draggablePanel = new DraggablePanel(this,width,height);
		transparentPanel = new TransparentPanel(this);
		eventHandler = new EventHandler();
		add(draggablePanel,JLayeredPane.DEFAULT_LAYER);
		add(transparentPanel,JLayeredPane.DRAG_LAYER);
		transparentPanel.addMouseListener(eventHandler);
		transparentPanel.addMouseMotionListener(eventHandler);
	}
	public boolean addPanel(JPanel panel,int x,int y)
	{
		if(x >= width ||y >= height)
		{
			return false;
		}
		else
		{
			return draggablePanel.addPanel(panel,new Index2D(x,y));
		}
	}
	public boolean addPanel(JPanel panel)
	{
		return draggablePanel.addPanel(panel);
	}
	
	
	
	
	protected void sendToTransparentPanel(JPanel panel,Pixel pixel )
	{
		lastPixelPosition = pixel;
		transparentPanel.receive(panel, pixel);
	}
	protected void sendToDraggablePanel(JPanel panel,Pixel pixel)
	{
		draggablePanel.receive(panel, pixel);
	}
	protected Pixel getLastPixelPosition()
	{
		return lastPixelPosition;
	}
	
	
	class EventHandler implements MouseListener,MouseMotionListener
	{

		public void mouseDragged(MouseEvent e) {
			transparentPanel.fireDragEvent(new Pixel(e.getX(),e.getY()));
			
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

		public void mouseReleased(MouseEvent e) {
			transparentPanel.fireMouseReleaseEvent(new Pixel(e.getX(),e.getY()));
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} 

