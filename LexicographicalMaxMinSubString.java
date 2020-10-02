import java.util.Scanner;

/* Lexicographicaly Order Means alphabetic or dictionary order
 *   A < B < C < .... <Y < Z < a < b < c < .... < y < z 
 *  ball < cat, dog < dorm, Happy < happy, Zoo < ball     
 */  


public class LexicographicalMaxMinSubString {

    public static String getSmallestAndLargest(String string, int subStringSize) {
        String smallest = "";
        String largest = "";
        
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        // z is the biggest char in Lexicographical order 
        smallest = new String(new char[subStringSize]).replace("\0", "z");
        
        // A is the smallest char in Lexicographical order 
        largest = new String(new char[subStringSize]).replace("\0", "A");

        String[] subStringArray = new String[string.length()-subStringSize+1];
        for(int i = 0; i < (string.length()-subStringSize+1); i++) {
        	subStringArray[i] = string.substring(i, i + subStringSize);
        }
        
        for(int i = 0; i < subStringArray.length;i++) {
    		
        	
        	if(smallest.compareTo(subStringArray[i]) > 0) {
        		// replace smallest if smaller string found
        		smallest = subStringArray[i];
        	}
        	if(largest.compareTo(subStringArray[i])<0) {
        		// replace largest if larger string found
        		largest = subStringArray[i];
        	}
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.next();
        int lengthOfSubString = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(string, lengthOfSubString));
    }
    
}
