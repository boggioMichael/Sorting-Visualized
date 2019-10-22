package sortVisualization;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import mediaManagement.PictureHelper;
import mediaManagement.Renderer;

public class MainFrame extends JFrame  {

	/**
	 * I have no IDEA why 
	 */
	private static final long serialVersionUID = 1L;
	private SortScreen sortScreen;
	
	public MainFrame()
	{
		this.sortScreen = new SortScreen();
		this.add(sortScreen);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Simulate Bubble Sort");
		this.setResizable(false);
		this.pack();
		//setting important jframe configs.
		
		try {
			PictureHelper.loadImage(this.getClass().getResource("/trees.jpeg").getPath());
		} catch (IOException e) {
			Renderer.drawImage = false;
			JOptionPane.showMessageDialog(null, "Conflict in paths while loading image.\ncontinue without image.");
		}
		
		sortScreen.start();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
	
	public static void main(String[] args) {
		
		//getting and setting the look and feel of system.
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//creating the frame within the context of the GUI's EDT (event dispatch thread)
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				(new MainFrame()).setVisible(true);
			} 
			
		});
		
	}
	
}