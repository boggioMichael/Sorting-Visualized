package mediaManagement;

import java.awt.Color;
import java.awt.Graphics;

import sortVisualization.RandArrayManager;
import sortVisualization.SortScreen;

public class Renderer {

	private static int greenRectLength = 0;
	//logic and graphics related 
	
	private static final int PICTURE_INDICATOR_HEIGHT = RandArrayManager.MAX_HEIGHT / 100;
	//the height of the indicator is to be 1% of the heighest array element.
	
	public static boolean drawImage = true;
	
	public static void drawArray(Graphics g, RandArrayManager arrayManager)
	{	
		for (int i = 0; i < arrayManager.getLength(); i++) {
			
			Renderer.drawArrayElement(i, g, Color.WHITE, arrayManager);
		}
		
	}
	
	public static boolean drawEndArray(Graphics g, RandArrayManager arrayManager)
	{
		if(Renderer.greenRectLength < arrayManager.getLength())
		{
			Renderer.greenRectLength++;
			SoundHelper.soundManager.makeSound(arrayManager.rArray[Renderer.greenRectLength - 1]);	
		}
		
		
		for (int i = 0; i < Renderer.greenRectLength; i++) {
			
			Renderer.drawArrayElement(i, g, Color.green, arrayManager);
		}
		
		for (int i = Renderer.greenRectLength; i < arrayManager.getLength(); i++) {			
			Renderer.drawArrayElement(i, g, Color.WHITE, arrayManager);
		}
		
		return Renderer.greenRectLength < arrayManager.getLength();
	}

	public static int drawArrayElement(int i, Graphics g, Color c, RandArrayManager arrayManager)
	{
		//calculating dependent values
		int height = arrayManager.rArray[i];
		int y= SortScreen.HEIGHT - arrayManager.rArray[i];
		
		int x = (i+1) + RandArrayManager.ELEMENT_WIDTH * i;
		
		g.setColor(c);
		
		if(Renderer.drawImage)
			Renderer.drawImageElement(g, x, y, RandArrayManager.ELEMENT_WIDTH, height);
		else 
			Renderer.drawRegularElement(g, x, y, RandArrayManager.ELEMENT_WIDTH, height);
		return x;
	}
	
	private static void drawImageElement(Graphics g, int x, int y, int width, int height)
	{
		
		if(PictureHelper.isLoaded())
		{
			g.drawImage(PictureHelper.cropImage(x, y, width, height), x, y, width, height, null);
			g.fillRect(x, y, width, PICTURE_INDICATOR_HEIGHT);
			//filling the indecator with the right color.
		}
		else 
		{
			Renderer.drawRegularElement(g, x, y, width, height);
		}
	}
	
	private static void drawRegularElement(Graphics g, int x, int y, int width, int height)
	{
		g.fillRect(x, y, width, height);
	}
	
}
