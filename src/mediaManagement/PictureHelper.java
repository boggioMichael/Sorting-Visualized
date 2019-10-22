package mediaManagement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sortVisualization.SortScreen;

public class PictureHelper {

	private static BufferedImage currentImage;
	
	
	public static void loadImage(String path) throws IOException
	{
		if(currentImage != null)
			currentImage.flush();
		PictureHelper.currentImage = new BufferedImage(SortScreen.WIDTH, 
				SortScreen.HEIGHT, BufferedImage.TYPE_INT_ARGB);
				
		BufferedImage temp = ImageIO.read(new File(path));

		Graphics g = PictureHelper.currentImage.createGraphics();
		g.drawImage(temp, 0, 0, SortScreen.WIDTH, 
				SortScreen.HEIGHT, null);
		g.dispose();
		//loading the picture in the resolution of the window.
			
	}
	
	public static boolean isLoaded()
	{
		return currentImage != null;
	}
	
	public static BufferedImage cropImage(int x, int y, int width, int height) 
	{
		BufferedImage dest = null;
		
		if(PictureHelper.isLoaded())
		{ 
			dest = PictureHelper.currentImage.getSubimage(x, y, width, height);
			//cropping the image by returning the sub image.
		}
	    
		return dest; 
	}
}
