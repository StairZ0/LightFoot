package utils;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import lightFoot.ContainerPanel;

public class LayeredPane extends JLayeredPane{
	
	@Override
	public Component add(Component component,int layer)
	{
		component.setBounds(0, 0, this.getWidth(), this.getHeight());
		return super.add(component,layer);
	}

}
