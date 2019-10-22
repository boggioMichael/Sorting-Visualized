package sorts;

import java.awt.Color;
import java.awt.Graphics;

import mediaManagement.Renderer;
import mediaManagement.SoundHelper;
import sortVisualization.RandArrayManager;
import sortVisualization.SortScreen;

public class BubbleSort extends GraphicSorter {
	
	private int greenIndex, redIndex;
	
	public BubbleSort(RandArrayManager arrayManager, SortScreen pointer) {
		super(arrayManager, pointer);
	}

	@Override
	public void sort() throws InterruptedException {
		
		for(int i = 0; i < this.arrayManager.getLength(); i++)
		{	
			boolean swapped = false;
		
			for (int j = 0; j < this.arrayManager.getLength() - i - 1; j++) {
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
		
		Renderer.drawArrayElement(greenIndex, g, Color.green, this.arrayManager);
		
		Renderer.drawArrayElement(redIndex, g, Color.red, this.arrayManager);
	}

	@Override
	public void makeSound() {
		SoundHelper.soundManager.makeSound(this.arrayManager.rArray[redIndex]);
	}	
	
	
}
