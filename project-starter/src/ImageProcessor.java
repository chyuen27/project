import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class ImageProcessor {
	
	// Create a clone of a buffered image
	// (The BufferedImage class describes an Image with an accessible buffer of image data.)
	public static BufferedImage copy(BufferedImage img) {
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		return bi;
	}

	// Create a clone of a buffered image
	// (Another implementation)
/*
	public static BufferedImage copy(BufferedImage img) {
		 ColorModel cm = img.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = img.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
*/
	
	// Convert an input color image to grayscale image
	public static BufferedImage convertToGrayScale(BufferedImage src) {
		// Make a copy of the source image as the target image
		BufferedImage target = copy(src);
		int width = target.getWidth();
		int height = target.getHeight();
		
		// Scan through each row of the image
		for (int j = 0; j < height; j++) {
			// Scan through each column of the image
			for (int i = 0; i < width; i++) {
				// Get an integer pixel in the default RGB color model
				int pixel = target.getRGB(i, j);
				// Convert the single integer pixel value to RGB color
				Color oldColor = new Color(pixel);

				int red = oldColor.getRed(); 	// get red value
				int green = oldColor.getGreen();	// get green value
				int blue = oldColor.getBlue(); 	// get blue value

				// Convert RGB to grayscale using formula
				// gray = 0.299 * R + 0.587 * G + 0.114 * B
				double grayVal = 0.299 * red + 0.587 * green + 0.114 * blue;

				// Assign each channel of RGB with the same value
				Color newColor = new Color((int) grayVal, (int) grayVal, (int) grayVal);

				// Get back the integer representation of RGB color and assign it back to the original position
				target.setRGB(i, j, newColor.getRGB());
			}
		}
		// return the resulting image in BufferedImage type
		return target;
	}

	// Invert the color of an input image
	public static BufferedImage invertColor(BufferedImage src) {
		BufferedImage target = copy(src);
		int width = target.getWidth();
		int height = target.getHeight();
		
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				int pixel = target.getRGB(i, j);
				Color oldColor = new Color(pixel);

				int red = oldColor.getRed();
				int green = oldColor.getGreen();
				int blue = oldColor.getBlue();
				
				// invert the color of each channel
				Color newColor = new Color(255 - red, 255 - green, 255 - blue);
				
				target.setRGB(i, j, newColor.getRGB());
			}
		}
		return target;
	}

	// Adjust the brightness of an input image
	public static BufferedImage adjustBrightness(BufferedImage src, int amount) {
		BufferedImage target = copy(src);
		int width = target.getWidth();
		int height = target.getHeight();
		
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				int pixel = target.getRGB(i, j);
				Color oldColor = new Color(pixel);

				int red = oldColor.getRed();
				int green = oldColor.getGreen();
				int blue = oldColor.getBlue();

				int newRed = (red + amount > 255) ? 255 : red + amount;
				int newGreen = (green + amount > 255) ? 255 : green + amount;
				int newBlue = (blue + amount > 255) ? 255 : blue + amount;

				newRed = (newRed < 0) ? 0 : newRed;
				newGreen = (newGreen < 0) ? 0 : newGreen;
				newBlue = (newBlue < 0) ? 0 : newBlue;

				Color newColor = new Color(newRed, newGreen, newBlue);

				target.setRGB(i, j, newColor.getRGB());
			}
		}
		return target;
	}

	// Apply a blur effect to an input image by random pixel movement
	public static BufferedImage blur(BufferedImage src, int offset) {
		
		// TODO: add your implementation
		
		return null; // temporary for passing compilation (remove it after added your code)
	}

	// Scale (resize) an image
	public static BufferedImage scale(BufferedImage src, int tWidth, int tHeight) {

		// TODO: add your implementation
		
		return null; // temporary for passing compilation (remove it after added your code)
	}
	
	// Rotate an image by angle degrees clockwise
	public static BufferedImage rotate(BufferedImage src, double angle) {

		// TODO: add your implementation
		
		return null; // temporary for passing compilation (remove it after added your code)
	}
	
	// Apply a swirl effect to an input image
	public static BufferedImage swirl(BufferedImage src, double degree) {
		
		// TODO: add your implementation
		
		return null; // temporary for passing compilation (remove it after added your code)
	}

	// Apply an effect to preserve partial colors of an image 
	public static BufferedImage preserveColor(BufferedImage src, boolean[][] mask, int colorVal, 
			int rgValue, int gbValue, int brValue) {
		
		// TODO: add your implementation
		
		return null; // temporary for passing compilation (remove it after added your code)
	}

	// Perform edge detection for an input image
	public static BufferedImage detectEdges(BufferedImage src) {
		
		// TODO: add your implementation
		
		return null; // temporary for passing compilation (remove it after added your code)
	}
}