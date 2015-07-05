package lightFoot;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utils.ThePanel;
import aurelienribon.slidinglayout.SLAnimator;
import net.miginfocom.swing.MigLayout;

public class MainStairZ {

	public static void main(String[] args) {
		
			SwingUtilities.invokeLater(new Runnable(){

				@Override
				public void run() {
					SLAnimator.start();
					JFrame frame = new JFrame();
					frame.setSize(400,400);
					ContainerPanel containerPanel = new ContainerPanel(2,2);
					
					
					frame.setContentPane(containerPanel);
					
					for(int i = 0;i<3;i++)
					{
					
						ThePanel t = new ThePanel(""+(i+1),"");
						
						
					
						containerPanel.addPanel(t);
					}
				
					
					//testPanel.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.validate();
					containerPanel.revalidate();
					containerPanel.repaint();
					frame.pack();
					//frame.pack();
					
				}
				
			});
		
	}
	

}
