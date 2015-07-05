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
		
		setLayout(new MigLayout("h 100%, w 100%, wrap "+width));
		
		hashTile = new HashMap<Index2D, Tile>();
		initializeHashTile(width,height);
		nMaxTile = width*height;
		nTileFilled = 0;
		contPane = cPane;
		this.width = width;
		this.height = height;
	}
	
	public DraggablePanel(int width, int height){

		setLayout(new MigLayout("wrap "+width));
		hashTile = new HashMap<Index2D, Tile>();
		initializeHashTile(width,height);
		nMaxTile = width*height;
		nTileFilled = 0;
		this.width = width;
		this.height = height;
		System.out.println("done \n" + hashTile.values().toString() + "\n" + hashTile.keySet().toString() + "\n");
		
	}
	
	
	
	public boolean isFull(){
		return !(nTileFilled < nMaxTile);
	}
	
	public void receive(JPanel panel, Pixel pixel){
		Tile t = pixelToTile(pixel);
		if(t.isEmpty()){
			t.addPanel(panel);
			nTileFilled++;
		}
		else{
			t = pixelToTile(contPane.getLastPixelPosition());
			t.addPanel(panel);
			nTileFilled++;
		}
	}
	
	public boolean addPanel(JPanel panel){
		if(isFull()){
			return false;	
		}
		else{
			Tile fill = firstTileFillable();
			System.out.println(fill.getIndex().getI() + " " + fill.getIndex().getJ());
			System.out.println(panel.getName());
			fill.addPanel(panel);
			nTileFilled++;
			return true;
		}
	}


/**
 * Public Method : fireMousePressedEvent
 * @param pixel
 * Send panel from the clicked tile by converting pixel location
 * remove panel from tile
 */
	public void fireMousePressedEvent(Pixel pixel){
		Tile t = pixelToTile(pixel);
		if(!t.isEmpty()){
			contPane.sendToTransparentPanel(t.getContent(), pixel);
			t.removePanel();
			nTileFilled--;
		}
	}
/**
 * Public Method : addPanel
 * @param panel
 * @param ij
 * @return JPanel panel
 * 
 */
	
	public boolean addPanel(JPanel panel, Index2D ij){
		if(!hashTile.get(ij).isEmpty()){
			return false;
		}
		hashTile.get(ij).addPanel(panel);
		
		nTileFilled++;
		return true;
	}
	
/**
 * Private Method : firstTileFillable()
 * @return Tile t
 * return the first tile which can filled
 */
	
	private Tile firstTileFillable(){
		for(Tile t : hashTile.values()){
			if(t.isEmpty()){
				return t;
			}
		}
		return null;
	}
	
	
/**
 * Private Method : pixelToTile
 * @param pixel
 * @return Tile
 * Check in which tile the click has been done
 * return the tile if there's a panel in it.
 */
	private Tile pixelToTile(Pixel pixel){
		for(Tile t : hashTile.values()){
			if(t.contains(pixel)){
				return t;
			}
		}
		return null;
	}
	
	private void initializeHashTile(int width, int height){
	
		for(int i = 0; i < height ; i++){
			for(int j = 0; j < width; j++){
				Index2D ij = new Index2D(i,j);
				Tile t = new Tile(ij);
				hashTile.put(ij,t);
				this.add(t, "cell "+ i + " " + j);
			}
		}
	}
	
	
}
