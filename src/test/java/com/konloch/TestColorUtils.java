package com.konloch;

import com.konloch.util.ColorUtils;

import java.awt.*;
import java.util.Objects;

/**
 * @author Konloch
 * @since 2/20/2023
 */
public class TestColorUtils
{
	//make sure you're passing -enableassertions
	public static void main(String[] args)
	{
		if(!TestColorUtils.class.desiredAssertionStatus())
			throw new RuntimeException("Enable assertions via `-enableassertions`");
		
		//test the getHex function
		assert ColorUtils.getHex(Color.WHITE).equals("#FFFFFFFF")
				: "getHex function is not returning expected values";
		
		//test the setAlpha function
		assert ColorUtils.getHex(ColorUtils.setAlpha(Color.WHITE, 0.1)).equals("#19FFFFFF")
				: "setAlpha function is not returning expected values";
		
		//test packing the colors
		assert ColorUtils.pack(Color.BLUE.getRed(), Color.BLUE.getGreen(), Color.BLUE.getBlue()) == 255
				: "pack function is not returning expected values";
		
		//TODO fromHex should support #FFFFFFFF
		//test the getHex function
		assert ColorUtils.getHex(Objects.requireNonNull(ColorUtils.fromHex("#FFFFFF"))).equals("#FFFFFFFF")
				: "getHex function is not returning expected values";
		
		System.out.println("All tests passed");
	}
}
