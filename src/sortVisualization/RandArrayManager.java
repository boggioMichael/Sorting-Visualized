package sortVisualization;

import java.util.Random;

public class RandArrayManager {

	public int[] rArray;
	private Random rnd;
	
	public static final int NO_ELEMENTS = 100;
	private static final int MAX_HEIGHT = SortScreen.HEIGHT -1;
	/*
	 * shorter than SortScreen.HEIGHT
	 * and there for the length of each element will not 
	 * exceed the height of the window
	 */
	

	public static final int ELEMENT_WIDTH = (SortScreen.WIDTH - (RandArrayManager.NO_ELEMENTS + 1) * SortScreen.SPACING_WIDTH) 
																			/ 
															   RandArrayManager.NO_ELEMENTS;
	/*
	 * the width and the number of elements must align in order for the 
	 * equation to work, since it relays on the fact the the upper component
	 * of the equation is divisible with no reminder by the number of elements.
	 * 
	 * because we have 1+no_elements of spacing , the amount of width we have for 
	 * the elements them selves is: width - that
	 * and here is the calculation of 1 element, so /= no_elements
	 * for graphics use.
	 */
	
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
		//the highest will be 100 - (2 * 50 = 100) 
		for (int i = 0; i < this.rArray.length; i++) {
			this.rArray[i] = (MAX_HEIGHT / NO_ELEMENTS)*(i+1);
		}
		
		for(int i = this.rArray.length - 1; i >= 0; i--)
		{
			int randIndex = rnd.nextInt(this.rArray.length);
			int temp = this.rArray[randIndex];
			this.rArray[randIndex] = this.rArray[i];
			this.rArray[i] = temp;
		}
		
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
