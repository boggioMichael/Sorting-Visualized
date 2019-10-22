package sortVisualization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import mediaManagement.Renderer;
import mediaManagement.SoundHelper;
import sorts.GraphicSorter;
import sorts.MergeSort;

public class SortScreen extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread panelThread;
	
	private RandArrayManager arrayManager;
	//random array of heights of rectangles
	
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
	//height and width
	//TO UNDERSTAND WHY THE WIDTH IS CALCULATED LIKE THAT
	//GO TO 	
	
	//timer related
	private int frame_delay_ms = 10;
	
	GraphicSorter sorter;
	
	public SortScreen()
	{
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(SortScreen.WIDTH, SortScreen.HEIGHT));
		//setting panel prop.
		
		arrayManager = new RandArrayManager();
		//setting the array manager and generating random array.
		//for the list of the swapped and random rectangles
		
		this.sorter = new MergeSort(arrayManager, this);	
		//sort of sorter we want
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(this.sorter.isSorted())
		{
			if(!Renderer.drawEndArray(g, this.arrayManager))
			{
				this.frame_delay_ms = 100; //for the computer not getting too hot!
			}
		}
		else
		{
			Renderer.drawArray(g, this.arrayManager);
			this.sorter.paintPointers(g);
			this.sorter.makeSound();
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	public synchronized void start()
	{
		this.panelThread = new Thread(this);
		this.panelThread.start();
	}	
	
	public synchronized void stop()
	{
		try 
		{
			SoundHelper.soundManager.close();
			this.panelThread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public void run() {
		try {
			
			while(!sorter.isSorted()) {
				sorter.sort();
			}
			
			while(true)
			{
				sleepAndDraw();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sleepAndDraw() throws InterruptedException
	{
		Thread.sleep(this.frame_delay_ms);
		this.repaint();
	}
	
	
}
