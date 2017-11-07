import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindKMissingItem {
	public static void main (String[] args) throws IOException {
		//Get the input
		//Read the test case no
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String tcCountString = reader.readLine();
		Integer tcCount = Integer.valueOf(tcCountString);
		for (int i = 0; i < tcCount; i++) {
			String lineN1N2K = reader.readLine();
			String parts[] = lineN1N2K.split(" ");
			Integer n1Count = Integer.parseInt(parts[0]);
			Integer n2Count = Integer.parseInt(parts[1]);
			Integer kCount = Integer.parseInt(parts[2]);

			//Todo: check for input validity (matching the number of the counts)
			
			//n1 line
			String lineN1 = reader.readLine();
			String n1[] = lineN1.split(" ");
			//System.out.println("n1 line is: " + Arrays.toString(n1));
			
			//n2 line
			String lineN2 = reader.readLine();
			String n2[] = lineN2.split(" ");
			//System.out.println("n2 line is: " + Arrays.toString(n2));
			//Todo: convert to integers
			
			Arrays.sort(n2);
			//System.out.println("n2 line is: " + Arrays.toString(n2));
			
			/*
			int index = Arrays.binarySearch(n2, "4");
			System.out.println("index is: " + index);
			*/
			
			//Now search 
			int hitCount = 0;
			String returnValue = "-1";
			for (int j = 0; j < n1.length; j++) {
				if (Arrays.binarySearch(n2, n1[j]) < 0) { //missing item
					hitCount++;
					if (hitCount == kCount) {
						returnValue = n1[j];
						break;
					}
				}
			}
			System.out.println(returnValue);
		}
	}
}