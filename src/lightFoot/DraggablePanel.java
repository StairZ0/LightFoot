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
		initializeHashTile(width,height);
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
			fill.addPanel(panel);
			nTileFilled++;
			return true;
		}
	}


/**
 * 
 * @param pixel
 */
	public void fireMousePressedEvent(Pixel pixel){
		Tile t = pixelToTile(pixel);
		if(!t.isEmpty()){
			contPane.sendToTransparentPanel(t.getContent(), pixel);
			t.addPanel(null);
			nTileFilled--;
		}
	}
/**
 * 
 * @param panel
 * @param Index2D ij
 * @return JPanel panel
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
 * @param Pixel pixel
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
		Index2D ij = new Index2D(0,0);
		for(int i = 0; i < height ; i++){
			for(int j = 0; j < width; j++){
				ij.setIJ(i, j);
				hashTile.put(ij,new Tile(ij));
			}
		}
	}
	
	
}
