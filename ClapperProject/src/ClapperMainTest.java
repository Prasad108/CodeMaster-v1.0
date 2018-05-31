import java.util.concurrent.CopyOnWriteArrayList;

public class ClapperMainTest {

	public static void main(String[] args) {
		
		int numberOfClappers = 2;
		int numberOfClaps = 3;
		boolean bulbOn = false;
		
		int[] clapperArray = new int[numberOfClappers];
		int[] prevClapperArray = new int[numberOfClappers];
		// making all default as off
		for(int i = 0; i < numberOfClappers; i++) {
			clapperArray[i] = 0;
		}
		
		// 
		for(int i = 0; i < numberOfClaps; i++) {
			
			copyArray(clapperArray, prevClapperArray);
			
			// since first clapper is connected to power supply, it will 
			// always be off/on on each clap
			if(clapperArray[0] == 1) 
				clapperArray[0] = 0;
			else
				clapperArray[0] = 1;
			
			for(int j = 1; j < clapperArray.length; j++) {
				if(prevClapperArray[j-1] == 1) {
					// if previous clapper element was 1, then toggle is possible
					if(clapperArray[j] == 0)
						clapperArray[j] = 1;
					else
						clapperArray[j] = 0;
				}
			}
		}
		
		System.out.println(checkIfAllClappersAreOn(clapperArray));
		
		
	}
	
	private static void copyArray(int[] src, int[] dest) {
		for(int i = 0; i < src.length; i++ ) {
			dest[i] = src[i];
		}
	}
	
	private static boolean checkIfAllClappersAreOn(int[] clapperArray) {
		for(int i = 0; i < clapperArray.length; i++) {
			if(clapperArray[i] == 0)
				return false;
		}
		return true;
	}

}
