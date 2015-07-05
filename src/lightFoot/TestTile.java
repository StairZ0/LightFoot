package lightFoot; 

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.Index2D;
import net.miginfocom.swing.MigLayout;

public class TestTile {

	public static void main(String[] args) {
		JFrame principal = new JFrame("Test");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new MigLayout());
		principal.setSize(500, 500);
		principal.setVisible(true);
		principal.setContentPane(panelPrincipal);
		Tile t = new Tile(new Index2D(1,1));
		JButton b = new JButton("test");
		JPanel p = new JPanel();
		p.add(b);
		t.addPanel(p);
		panelPrincipal.add(t,"w 50,h 50");
		principal.pack();
		Pixel pixel = new Pixel(56, 56);
		System.out.println(t.contains(pixel));
		
		
	}

}


