package lightFoot;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class DraggablePanel extends JPanel {
	
	private HashMap<Pixel, Tile> hashTile;
	private int nMaxTile;
	private int nTile;
	private ContainerPanel contPane;
	
	public DraggablePanel(ContainerPanel cPane, int width, int height){
		
		setLayout(new MigLayout("wrap "+width));
		hashTile = new HashMap<Pixel, Tile>();
		nMaxTile = width*height;
		nTile = 0;
		contPane = cPane;
	}
	
	
	
	public boolean isFull(){
		return !(nTile < nMaxTile);
	}
	
	public void receive(JPanel panel, Pixel pixel){
		
	}
	
	public boolean addPanel(JPanel panel){
		return false;
	}
	
	public void fireMousePressedEvent(Pixel pixel){
		
	}
	
	
	public boolean addPanel(JPanel panel, int x, int y){
		if(isFull()){
			return false;
		}
		else{
			add(panel, " cell "+ x + " " + y);
			nTile++;
			return true;
		}
	}
	
	
	
	
	
	
	
	
}
