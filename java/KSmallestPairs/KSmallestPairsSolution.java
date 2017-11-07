import java.util.*;

public class KSmallestPairsSolution {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList result = new ArrayList(); // holding the result
        
        int curr1 = 0;
        int curr2 = 0;
        int p1 = 0;
        int p2 = 0;

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return result;
        }
        
        // Add the first value on index (0, 0)
        //ArrayList value = new ArrayList(); 
        //value.add(nums1[0]);
        //value.add(nums2[0]);
        //result.add(value);
        
        int counter = 0; 
        while (counter < k) {
            ArrayList value = new ArrayList(); // holding the sum of the resulting arrays
            if (curr1 == p1 && curr2 == p2) { // same index, just need to add once
            
                value.add(nums1[curr1]);
                value.add(nums2[curr2]);
                result.add(value);
                
                p1++;
                if (p1 == nums1.length) {
                    p1 = 0;
                    curr2++;
                    if (curr2 == nums2.length) {
                        break;
                    }
                }

                p2++;
                if (p2 == nums2.length) {
                    p2 = 0;
                    curr1++;
                    if (curr1 == nums1.length) {
                        break;
                    }
                }
                counter++;
                continue;
            }
            
            // both arrays have space to expand, compare to find the minumum value
            if (nums1[curr1] + nums2[p2] < nums1[p1] + nums2[curr2]) {
                value.add(nums1[curr1]);
                value.add(nums2[p2]);
                result.add(value);

                p2++;
                if (p2 == nums2.length) {
                    p2 = 0;
                    curr1++;
                    if (curr1 == nums1.length) {
                        break;
                    }
                }
            }
            else {
                value.add(nums1[p1]);
                value.add(nums2[curr2]);
                result.add(value);

                p1++;
                if (p1 == nums1.length) {
                    p1 = 0;
                    curr2++;
                    if (curr2 == nums2.length) {
                        break;
                    }
                }
            }
            counter++;
           }
        
        
        return result;
    }
    
	public static void main (String[] args) {
		int[] nums1 = {1, 1, 2};
		int[] nums2 = {1, 2, 3};
		int k = 10;
		
		 
		System.out.println(KSmallestPairsSolution.kSmallestPairs(nums1, nums2, k));
	}
}