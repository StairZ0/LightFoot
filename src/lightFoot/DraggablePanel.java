package lightFoot;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import utils.Index2D;
import net.miginfocom.swing.MigLayout;


public class DraggablePanel extends JPanel {
	
	private HashMap<Index2D, Tile> hashTile;
	private int nMaxTile;
	private int nTileFilled;
	private ContainerPanel contPane;
	private int width, height;
	public DraggablePanel(ContainerPanel cPane, int width, int height){
		
		setLayout(new MigLayout("wrap "+width));
		hashTile = new HashMap<Index2D, Tile>();
		nMaxTile = width*height;
		nTileFilled = 0;
		contPane = cPane;
		this.width = width;
		this.height = height;
	}
	
	
	
	public boolean isFull(){
		return !(nTileFilled < nMaxTile);
	}
	
	public void receive(JPanel panel, Pixel pixel){
		
	}
	
	public boolean addPanel(JPanel panel){
		if(isFull()){
			return false;	
		}
		else{
			Tile fill = firstTileFillable();
			fill.addPanel(panel);
			nTileFilled++;
			return true;
		}
	}
	
	public void fireMousePressedEvent(Pixel pixel){
		
	}
	
	
	public boolean addPanel(JPanel panel, Index2D ij){
		if(!hashTile.get(ij).isEmpty()){
			return false;
		}
		hashTile.get(ij).addPanel(panel);
		nTileFilled++;
		return true;
	
	}
	
	private Tile firstTileFillable(){
		for(Tile t : hashTile.values()){
			if(t.isEmpty()){
				return t;
			}
		}
		return null;
	}
	
	
	
	
	
	
}
