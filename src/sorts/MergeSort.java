package sorts;

import java.awt.Color;
import java.awt.Graphics;

import mediaManagement.Renderer;
import mediaManagement.SoundHelper;
import sortVisualization.RandArrayManager;
import sortVisualization.SortScreen;

public class MergeSort extends GraphicSorter {

	private int mergeFirstIndex, mergeSecondIndex;
	
	
	public MergeSort(RandArrayManager arrayManager, SortScreen drawPointer) {
		super(arrayManager, drawPointer);
		this.mergeFirstIndex = 0;
		this.mergeFirstIndex = 0;
	}

	@Override
	public void sort() throws InterruptedException {
		if(!this.flag)
		{
			int helper[] = this.arrayManager.rArray.clone();
			int toSort[] = this.arrayManager.rArray.clone();
			this.sort(helper, 0, this.arrayManager.getLength(), toSort);
		}
		this.flag = true;
	}

	private void sort(int[] check, int begin, int end, int[] change) throws InterruptedException {
		
		if(end - begin < 2)
			return;
		
		int middle = (end + begin) / 2;
		
		this.sort(change, begin, middle, check);
		this.sort(change, middle, end, check);
		

		this.mergeParts(check, begin, middle, end, change);
	}
	
	private void mergeParts(int[] check, int begin, int middle, int end, int[] change) throws InterruptedException {
		
		int i = begin, j = middle;
		for(int k = begin; k < end; k++)
		{
			this.mergeFirstIndex = i;
			this.mergeSecondIndex = j;
			if(i < middle && (j >= end || check[i] <= check[j]))
			{
				this.arrayManager.rArray[k] = check[i];
				change[k] = check[i]; 
				this.drawPointer.sleepAndDraw();
				i++;
			}
			else 
			{
				this.arrayManager.rArray[k] = check[j];
				change[k] = check[j];
				this.drawPointer.sleepAndDraw();
				j++;
			}			
		}
		
	}

	@Override
	public void paintPointers(Graphics g) {
		if(this.mergeFirstIndex < RandArrayManager.NO_ELEMENTS &&
			this.mergeSecondIndex < RandArrayManager.NO_ELEMENTS)
		{
			Renderer.drawArrayElement(this.mergeFirstIndex, g, Color.red, this.arrayManager);
			Renderer.drawArrayElement(this.mergeSecondIndex, g, Color.red, this.arrayManager);
		}
	}

	@Override
	public void makeSound() {
		if(this.mergeFirstIndex < RandArrayManager.NO_ELEMENTS &&
				this.mergeSecondIndex < RandArrayManager.NO_ELEMENTS)
		{
			SoundHelper.soundManager.makeSound(this.arrayManager.rArray[this.mergeFirstIndex]);
			SoundHelper.soundManager.makeSound(this.arrayManager.rArray[this.mergeSecondIndex]);
		}
	}

	
	
}
