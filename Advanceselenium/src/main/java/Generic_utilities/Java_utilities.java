package Generic_utilities;

import java.util.Random;

public class Java_utilities {
	public int getJavadata()
	{
		Random ran = new Random();
		int randNum = ran.nextInt(2000);
		
		return randNum;
		
	}

}


