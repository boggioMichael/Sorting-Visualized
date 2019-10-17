package sortVisualization;

import java.awt.Color;
import java.awt.Graphics;

public class BubbleSort extends GraphicSorter {
	
	private int greenIndex, redIndex;
	
	BubbleSort(RandArrayManager arrayManager, SortScreen pointer) {
		super(arrayManager, pointer);
	}

	@Override
	public void sort() throws InterruptedException {
		
		for(int i = 0; i < this.arrayManager.getLength(); i++)
		{	
			boolean swapped = false;
		
			for (int j = 0; j < this.arrayManager.getLength() - 1; j++) {
				this.greenIndex = j;
				this.redIndex = j + 1;
				
				if(this.arrayManager.rArray[this.greenIndex] > this.arrayManager.rArray[this.redIndex])
				{
					this.arrayManager.swap(this.greenIndex, this.redIndex);
					swapped = true;
				}
				
				this.drawPointer.sleepAndDraw();
				
			}
			
			if(!swapped) break;
		}
		
		this.flag = true;
	}
	

	@Override
	public void paintPointers(Graphics g) {
		
		this.drawPointer.drawArrayElement(greenIndex, g, Color.green);
		
		this.drawPointer.drawArrayElement(redIndex, g, Color.black);
	}	
	
	
}
