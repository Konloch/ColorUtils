package com.konloch.utils;

import java.awt.*;

/**
 * @author Konloch
 * @since 04/24/2020
 */
public class ColorUtils
{
	/**
	 * A static value to represent a fully transparent color
	 */
	public static final Color COLOR_TRANSPARENT = new Color(0.0f,0.0f,0.0f,0f);
	
	/**
	 * Set the alpha value of a Color object.
	 *
	 * @param color any Color
	 * @param alpha any int value between 0-255 to represent the alpha value
	 * @return a new Color instance with the specified alpha
	 */
	public static Color setAlpha(Color color, int alpha)
	{
		return new Color(pack(color.getRed(), color.getGreen(), color.getBlue(), alpha), true);
	}
	
	/**
	 * Set the alpha value of a Color object.
	 *
	 * @param color any Color
	 * @param alpha any double value between 0.0-1.0 to represent the alpha value
	 * @return a new Color instance with the specified alpha
	 */
	public static Color setAlpha(Color color, double alpha)
	{
		return setAlpha(color, (int) (alpha * 255));
	}
	
	/**
	 * Pack RGB color values into an integer.
	 *
	 * @param r any integer value between 0-255 to represent the red color value
	 * @param g any integer value between 0-255 to represent the green color value
	 * @param b any integer value between 0-255 to represent the blue color value
	 * @return An integer representing the RGBA values
	 */
	public static int pack(int r, int g, int b)
	{
		return r << 16 | g << 8 | b;
	}
	
	/**
	 * Pack RGB color values into an integer.
	 *
	 *
	 * @param r any double value between 0.0-1.0 to represent the red color value
	 * @param g any double value between 0.0-1.0 to represent the green color value
	 * @param b any double value between 0.0-1.0 to represent the blue color value
	 * @return An integer representing the RGB values
	 */
	public static int pack(double r, double g, double b)
	{
		return (int) (r * 255) << 16 | (int) (g * 255) << 8 | (int) (b * 255);
	}
	
	/**
	 * Pack RGBA color values into an integer.
	 *
	 * @param r any integer value between 0-255 to represent the red color value
	 * @param g any integer value between 0-255 to represent the green color value
	 * @param b any integer value between 0-255 to represent the blue color value
	 * @param alpha any integer value between 0-255 to represent the alpha value
	 * @return An integer representing the RGBA values
	 */
	public static int pack(int r, int g, int b, int alpha)
	{
		return alpha << 24 | r << 16 | g << 8 | b;
	}
	
	/**
	 * Pack RGBA color values into an integer.
	 *
	 * @param r any double value between 0.0-1.0 to represent the red color value
	 * @param g any double value between 0.0-1.0 to represent the green color value
	 * @param b any double value between 0.0-1.0 to represent the blue color value
	 * @param alpha any double value between 0.0-1.0 to represent the alpha value
	 * @return An integer representing the RGBA values
	 */
	public static int pack(double r, double g, double b, double alpha)
	{
		return (int) (alpha * 255) << 24 | (int) (r * 255) << 16 | (int) (g * 255) << 8 | (int) (b * 255);
	}
	
	/**
	 * Compare two colors and return the difference between the color values.
	 *
	 * @param colorA any Color to compare against
	 * @param colorB any Color to compare against
	 * @return returns a double between 0.0-767.0
	 */
	public static double getDifference(Color colorA, Color colorB)
	{
		long rmean = ((long) colorA.getRed() + (long) colorB.getRed() ) / 2;
		long r = (long) colorA.getRed() - (long) colorB.getRed();
		long g = (long) colorA.getGreen() - (long) colorB.getGreen();
		long b = (long) colorA.getBlue() - (long) colorB.getBlue();
		
		return Math.sqrt((((512 + rmean) * r * r) >> 8) + 4 * g * g + (((767 - rmean) * b * b) >>8));
	}
	
	/**
	 * Generate a hex color code from a Color object.
	 *
	 * @param color any Color
	 * @return the hex value of the Color
	 */
	public static String getHex(Color color)
	{
		return getHex(color.getRGB());
	}
	
	/**
	 * Generate a hex color code from an RGB integer
	 *
	 * @param rgbColor any RGB integer
	 * @return the hex value of the RGB integer
	 */
	public static String getHex(int rgbColor)
	{
		return "#" + Integer.toHexString(rgbColor).toUpperCase();
	}
	
	/**
	 * Alert that this is a library
	 *
	 * @param args program launch arguments
	 */
	public static void main(String[] args)
	{
		throw new RuntimeException("Incorrect usage - for information on how to use this correctly visit https://konloch.com/ColorUtils/");
	}
}