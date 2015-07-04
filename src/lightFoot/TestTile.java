package lightFoot; 

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class TestTile {

	public static void main(String[] args) {
		JFrame principal = new JFrame("Test");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new MigLayout());
		principal.setSize(500, 500);
		principal.setVisible(true);
		principal.setContentPane(panelPrincipal);
		Tile tile = new Tile();
	
		tile.setSize(50, 50);
		Pixel pixel = new Pixel(150, 150);
		System.out.println(tile.contain(pixel));
		
	}

}


