package utils;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import lightFoot.ContainerPanel;

public class LayeredPane extends JLayeredPane{
	
	public LayeredPane()
	{
		this.setLayout(new LayeredPaneLayout(this));
	}

}
