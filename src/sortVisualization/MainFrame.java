package sortVisualization;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

/*
 * Ball class -
 * main jframe and the start
 * of the program where main()
 * is. 
 * 
 * creates the jframe in the size 
 * and adding the jpannel (Screen) into 
 * it.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainFrame extends JFrame  {

	/**
	 * I have no IDEA why 
	 */
	private static final long serialVersionUID = 1L;
     
	
	public MainFrame()
	{
		SortScreen sortScreen = new SortScreen();
		this.add(sortScreen);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Simulate Bubble Sort");
		this.setResizable(false);
		this.pack();
		//setting important jframe configs.
		
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