package lightFoot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import utils.Index2D;
import utils.LayeredPane;

/**
 * 
 * @author Alan
 *
 */
public class ContainerPanel extends LayeredPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DraggablePanel draggablePanel;
	private TransparentPanel transparentPanel;
	private EventHandler eventHandler;
	private Pixel lastPixelPosition;
	private int width;
	private int height;
	private boolean isDragging = false;
	private Pixel lastRealPixelPosition;

	
	/**
	 * Create a grid layout with the given dimension.
	 * @param width
	 * @param height
	 */
	public ContainerPanel(int width,int height)
	{
		super();
		this.width=width;
		this.height=height;
		draggablePanel = new DraggablePanel(this,width,height);
		transparentPanel = new TransparentPanel(this);
		eventHandler = new EventHandler();
		
		add(draggablePanel,JLayeredPane.FRAME_CONTENT_LAYER);
		add(transparentPanel,JLayeredPane.POPUP_LAYER);
		transparentPanel.addMouseListener(eventHandler);
		transparentPanel.addMouseMotionListener(eventHandler);
	}
	/**
	 * Add given panel to given index.
	 * @param panel
	 * @param x
	 * @param y
	 * @return  <b>true</b> if panel was successfully added.<br>
	 * 		   <b>false</b> if there's already a panel at the given index. 
	 */
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
	/**
	 * Add given panel to the first empty tile it encounters.
	 * @param panel
	 * @return  <b>true</b> if panel was successfully added.<br>
	 * 		   <b>false</b> if grid is already full. 
	 */
	public boolean addPanel(JPanel panel)
	{
		return draggablePanel.addPanel(panel);
	}
	
	
	
	/**
	 * Send selected panel to transparent panel for Dragging.
	 * @param panel
	 * @param pixel The location of the selected panel.
	 */
	protected void sendToTransparentPanel(JPanel panel,Pixel pixel )
	{
		lastPixelPosition = pixel;
		transparentPanel.receive(panel, pixel);
		isDragging = true;
	}
	/**
	 * Send dragged panel to Draggable panel for dropping.
	 * @param panel
	 * @param pixel 
	 */
	protected void sendToDraggablePanel(JPanel panel,Pixel pixel)
	{
		draggablePanel.receive(panel, pixel);
		isDragging = false;
	}
	/**
	 * Return the position of the last panel sent to transparent panel.
	 * @return
	 */
	protected Pixel getLastPixelPosition()
	{
		return lastPixelPosition;
	}
	
	
	class EventHandler implements MouseListener,MouseMotionListener
	{

		public void mouseDragged(MouseEvent e) {
			int x = -lastRealPixelPosition.getX()+e.getX();
			int y = -lastRealPixelPosition.getY()+e.getY();
			if(isDragging)
			transparentPanel.fireDragEvent(new Pixel(x,y));
			
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
			lastRealPixelPosition = new Pixel(e.getX(),e.getY());
			draggablePanel.fireMousePressedEvent(new Pixel(e.getX(),e.getY()));
			
		}

		public void mouseReleased(MouseEvent e) {
			if(isDragging)
			transparentPanel.fireMouseReleaseEvent(new Pixel(e.getX(),e.getY()));
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} 

