package sortVisualization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class SortScreen extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RandArrayManager arrayManager;
	//random array of heights of rectangles
	
	
	private int greenRectLength = 0;
	//logic and graphics related 
	
	public static final int SPACING_WIDTH = 0;
	public static final int WIDTH = 600;
	public static final int HEIGHT = SortScreen.WIDTH / 9 * 6;
	//height and width
	//TO UNDERSTAND WHY THE WIDTH IS CALCULATED LIKE THAT
	//GO TO 	
	
	//timer related
	private static final int FRAME_DELAY_MS = 3;
	
	GraphicSorter sorter;
	
	public SortScreen()
	{
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(SortScreen.WIDTH, SortScreen.HEIGHT));
		//setting panel prop.
		
		arrayManager = new RandArrayManager();
		//setting the array manager and generating random array.
		//for the list of the swaped and random rectangles
		
		this.sorter = new BubbleSort(arrayManager, this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(this.sorter.isSorted())
		{
			this.drawEndArray(g);
		}
		else
		{
			this.drawArray(g);
			this.sorter.paintPointers(g);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void drawArray(Graphics g)
	{	
		for (int i = 0; i < this.arrayManager.getLength(); i++) {
			
			drawArrayElement(i, g, Color.GRAY);
		}
		
	}
	
	public void drawEndArray(Graphics g)
	{
		if(this.greenRectLength < this.arrayManager.getLength())
			this.greenRectLength++;
		
		for (int i = 0; i < this.greenRectLength; i++) {
			
			drawArrayElement(i, g, Color.green);
		}
		
		for (int i = this.greenRectLength; i < this.arrayManager.getLength(); i++) {			
			drawArrayElement(i, g, Color.GRAY);
		}
	}

	public int drawArrayElement(int i, Graphics g, Color c)
	{
		//calculating dependent values
		int height = this.arrayManager.rArray[i];
		int y= SortScreen.HEIGHT - this.arrayManager.rArray[i];
		
		int x = SortScreen.SPACING_WIDTH * (i+1) + RandArrayManager.ELEMENT_WIDTH * i;
		
		
		g.setColor(c);
		g.fillRect(x, y, RandArrayManager.ELEMENT_WIDTH, height);
		g.setColor(Color.white);
		g.drawRect(x, y, RandArrayManager.ELEMENT_WIDTH, height);
		
		return x;
	}
	
	public void start()
	{
		(new Thread(this)).start();
	}	
	
	@Override
	public void run() {
		try {
			
			while(true) {
				sorter.sort();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sleepAndDraw() throws InterruptedException
	{
		
		Thread.sleep(SortScreen.FRAME_DELAY_MS);
		this.repaint();
	}
	
	
}
