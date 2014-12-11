package com.zerono.essencecraft.utility;

public class MathHelperEC 
{
	public static int lastDigit(int number)
	{
		return number%10;
	}
	
	public static int firstDigit(int number)
	{
		int first;
		if (number < 10)
		{
			first = 0;
		}
		else
		{
			char temp = Integer.toString(number).charAt(0);
			String tempFirst = Character.toString(temp);
			first = Integer.parseInt(tempFirst);
		}
		return first;
	}
}
