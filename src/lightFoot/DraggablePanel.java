package lightFoot;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;


public class DraggablePanel extends JPanel {
	
	private HashMap<Pixel, Tile> hashTile;
	private int nMaxTile;
	private int nTile;
	
	public DraggablePanel(int width, int height){
		
		setLayout(new GridLayout(width, height));
		hashTile = new HashMap<Pixel, Tile>();
		nMaxTile = width*height;
		nTile = 0;
	}
	
	public boolean isFull(){
		return !(nTile < nMaxTile);
	}
	
	
	public void addPanel(JPanel panel){
		nTile++;
	}
	
	
	
	
	
	
}
