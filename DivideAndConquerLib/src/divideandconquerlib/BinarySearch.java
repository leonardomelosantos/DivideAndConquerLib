package divideandconquerlib;

public class BinarySearch {

	/**
	 * Return the position of the number.
	 * 
	 * @param arrayContent
	 * @param numberToFind
	 * @return
	 */
	public static int searchBinary(int[] arrayContent, int numberToFind) {
		
		return searchBinary(arrayContent, numberToFind, 1, arrayContent.length);
	}
	
	private static int searchBinary(int[] arrayContent, int numberToFind, int initialPosition, int finalPosition)
	{
		int returnValue = 0;
		int middleElement = (initialPosition + finalPosition) / 2;
		int middleElementZeroBazed = middleElement--;
		
		if (initialPosition > finalPosition)
		{
			returnValue = 0;
		} else {
			if (numberToFind == arrayContent[middleElementZeroBazed]) {
	            returnValue = middleElementZeroBazed;
	        } else {
	            if (numberToFind < arrayContent[middleElementZeroBazed]) {
	            	returnValue = searchBinary(arrayContent, numberToFind, initialPosition, middleElementZeroBazed-1);
	            } else {
	            	returnValue = searchBinary(arrayContent, numberToFind, middleElementZeroBazed+1, finalPosition);
	            }
	        }
		}
		
		
        return returnValue;
	}
	
}
