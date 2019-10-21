package sorts;

import java.awt.Graphics;

import sortVisualization.RandArrayManager;
import sortVisualization.SortScreen;

public abstract class GraphicSorter {

	protected RandArrayManager arrayManager;
	protected SortScreen drawPointer;
	
	protected boolean flag;
	
	GraphicSorter(RandArrayManager arrayManager, SortScreen drawPointer)
	{
		this.arrayManager = arrayManager;
		this.drawPointer = drawPointer;
		//Not clone - because I want to change THAT array and a ptr for the panel
		
		this.flag = false;
	}
	
	public boolean isSorted()
	{
		return flag;
	}
	
	public abstract void sort() throws InterruptedException;
	public abstract void paintPointers(Graphics g);
	
}
