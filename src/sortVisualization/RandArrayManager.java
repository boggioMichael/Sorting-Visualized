package sortVisualization;

import java.util.Random;

public class RandArrayManager {

	public int[] rArray;
	private Random rnd;
	
	public static final int NO_ELEMENTS = 100;
	public static final int MAX_HEIGHT = SortScreen.HEIGHT - 100;
	
	public static final int ELEMENT_WIDTH = SortScreen.WIDTH / NO_ELEMENTS - 1;
	
	public RandArrayManager()
	{
		this.rnd = new Random();
		this.rArray = new int[RandArrayManager.NO_ELEMENTS];
		this.generateRandArray();
	}
	
	public int getLength()
	{
		return this.rArray.length;
	}
	
	
	private void generateRandArray()
	{
		
		//every element is increased by the multiple of 3 for the last one to be at the MAX_HEIGHT 
		for (int i = 0; i < this.rArray.length; i++) {
			this.rArray[i] = (i + 1) * RandArrayManager.MAX_HEIGHT / RandArrayManager.NO_ELEMENTS;
		}
		//generate
		
		for(int i = this.rArray.length - 1; i >= 0; i--)
		{
			int randIndex = rnd.nextInt(this.rArray.length);
			int temp = this.rArray[randIndex];
			this.rArray[randIndex] = this.rArray[i];
			this.rArray[i] = temp;
		}
		//shuffle
		
	}
	
	public void swap(int i, int j)
	{
		int temp = this.rArray[i];
		this.rArray[i] = this.rArray[j];
		this.rArray[j] = temp;
	}
	
	public void reset()
	{
		generateRandArray();
	}
}
