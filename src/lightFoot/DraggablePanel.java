package lightFoot;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedHashMap;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLPanel;
import utils.Index2D;
/**
 * 
 * @author Thomas
 *
 */

public class DraggablePanel extends JPanel {


	private LinkedHashMap<Index2D, Tile> hashTile;
	private int nMaxTile;
	private int nTileFilled;
	private ContainerPanel contPane;
	private SLPanel slPanel = new SLPanel();
	private int width, height;
	private SLConfig currentConfig;
	public DraggablePanel(ContainerPanel cPane, int width, int height){
		this.width = width;
		this.height = height;
		nMaxTile = width*height;
		nTileFilled = 0;
		contPane = cPane;
		
		
		currentConfig = createConfig();
		setLayout(new MigLayout("insets 0 0 0 0"));
		hashTile = new LinkedHashMap<Index2D, Tile>();
		initializeHashTile(width,height);
		add(slPanel,"w 100%,h 100%");
		slPanel.setVisible(true);
		slPanel.initialize(currentConfig);
		slPanel.setTweenManager(SLAnimator.createTweenManager());
		setVisible(true);
		setBackground(Color.black);
	}



	public boolean isFull(){
		return !(nTileFilled < nMaxTile);
	}

	public void receive(JPanel panel, Pixel pixel){

			Tile t = pixelToTile(pixel);
		
			if(t != null && t.isEmpty()){
				t.addPanel(panel);
				nTileFilled++;
			}
			else{
				
				t = pixelToTile(contPane.getLastPixelPosition());
				if(t != null){
					t.addPanel(panel);
					nTileFilled++;
				}
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
	 * Public Method : fireMousePressedEvent
	 * @param pixel
	 * Send panel from the clicked tile by converting pixel location
	 * remove panel from tile
	 */
	public void fireMousePressedEvent(Pixel pixel){
		Tile t = pixelToTile(pixel);
		if(t != null && !t.isEmpty()){
			contPane.sendToTransparentPanel(t.getContent(), new Pixel(t.getX(),t.getY()));
			t.removePanel();
			t.repaint();
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
	 * @throws Exception 
	 */
	private Tile pixelToTile(Pixel pixel){

		for(Tile t : hashTile.values()){
			if(t.contains(pixel)){
				return t;
			}
		}
		return null;
		//throw new Exception();
	}

	private void initializeHashTile(int width, int height){

		for(int i = 0; i < height ; i++){
			for(int j = 0; j < width; j++){
				Index2D ij = new Index2D(i,j);
				Tile t = new Tile(ij);
				hashTile.put(ij,t);	
				currentConfig.place(ij.getI(), ij.getJ(), t);
			}
		}
	}
	private SLConfig createConfig()
	{
		SLConfig newCfg = new SLConfig(slPanel);
		newCfg.gap(5, 5);
		for(int i = 0;i<height;i++)
		{
			newCfg.row(1f);
		}
		for(int j =0;j < width;j++)
		{
			newCfg.col(1f);
		}
		return newCfg;
	}


}
