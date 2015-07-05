package lightFoot;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainStairZ {

	public static void main(String[] args) {
		
			SwingUtilities.invokeLater(new Runnable(){

				@Override
				public void run() {
					JFrame frame = new JFrame();
					frame.setSize(400,400);
					ContainerPanel containerPanel = new ContainerPanel(5,5);
					
					
					frame.setContentPane(containerPanel);
					
					for(int i = 0;i<23;i++)
					{
						JPanel testPanel = new JPanel();
						testPanel.add(new JButton("tes"));
						testPanel.setBorder(BorderFactory.createLineBorder(Color.black));
						containerPanel.addPanel(testPanel);
					}
					
					
					//testPanel.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.validate();
					//frame.pack();
					
				}
				
			});
		
	}
	

}
