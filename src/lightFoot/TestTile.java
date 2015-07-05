package lightFoot; 

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utils.LayeredPane;
import net.miginfocom.swing.MigLayout;

public class TestTile {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(400,400);
				JPanel test = new JPanel();
				frame.setContentPane(test);
				LayeredPane containerPanel = new LayeredPane();
				test.add(containerPanel);
				JPanel testPanel = new JPanel(new MigLayout());
				
				containerPanel.setPreferredSize(new Dimension(400, 400));
				testPanel.add(new JButton("tes"));
				containerPanel.add(testPanel,JLayeredPane.DEFAULT_LAYER);
				containerPanel.setVisible(true);
				testPanel.setBorder(BorderFactory.createLineBorder(Color.black));
				containerPanel.validate();
				frame.validate();
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				
				
				frame.setVisible(true);
			
				
				
				
			}
			
		});
		
		
		
		
		
		
	}

}


