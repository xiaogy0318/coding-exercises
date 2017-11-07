import java.util.*;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
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
        VisitSet visitSet = new VisitSet(nums1.length, nums2.length, result);

        while (counter < k) {
            ArrayList value = new ArrayList(); // holding the sum of the resulting arrays
            
			System.out.println("Loop number: " + counter);
			System.out.println("curr1 is " + curr1);
			System.out.println("p2 is " + p2);
			System.out.println("curr2 is " + curr2);
			System.out.println("p1 is " + p1);
            if (nums1[curr1] + nums2[p2] <= nums1[p1] + nums2[curr2]) {
                if (!visitSet.isVisited(curr1, p2)) {
                    visitSet.visit(curr1, p2, nums1[curr1], nums2[p2]);
                    counter++;
                }
                else {//also bump the other set of pointers!!!
                /*
                    p1++;
					System.out.println("p1 is bumped!!!");
					//System.out.println("nums1.length is " + nums1.length);
					
                    if (p1 == nums1.length) {
                        p1 = 0;
                        curr2++;
                        if (curr2 == nums2.length) {
                            break;
                        }
                    }
                    */
                }
                
                p2++;
				System.out.println("p2 is bumped!!!");
                if (p2 == nums2.length) {
                    p2 = 0;
                    curr1++;
                    if (curr1 == nums1.length) {
                        break;
                    }
                }
                
            }
            else {
                if (!visitSet.isVisited(p1, curr2)) {
                    visitSet.visit(p1, curr2, nums1[p1], nums2[curr2]);
                    counter++;
                }
                else { //also bump the other set of pointers!!!
                /*
                    p2++;
					System.out.println("p2 is bumped!!!");
                    if (p2 == nums2.length) {
                        p2 = 0;
                        curr1++;
                        if (curr1 == nums1.length) {
                            break;
                        }
                    }
                    */
                }

                p1++;
				System.out.println("p1 is bumped!!!");

                if (p1 == nums1.length) {
                    p1 = 0;
                    curr2++;
                    if (curr2 == nums2.length) {
                        break;
                    }
                }
           }
        }
        return result;

    }
        
	public static void main (String[] args) {
		int[] nums1 = {-10,-4,0,0,6};
		int[] nums2 = {3,5,6,7,8,100};
		int k = 10;
		
		Solution solution = new Solution(); 
		System.out.println(solution.kSmallestPairs(nums1, nums2, k));
	}

	
	
    private class VisitSet {
        private boolean[][] indexes;
        private int index1Count, index2Count;
        private ArrayList list;
        public VisitSet(int index1Count, int index2Count, ArrayList newList) {
            if (index2Count > 0 && index2Count > 0 && newList != null) {
                indexes = new boolean[index1Count][index2Count];
                this.index1Count = index1Count;
                this.index2Count = index2Count;
                list = newList;
            }
            else {
                System.out.println("Illegal index count(s)!!!");
            }
        }
        
        public boolean isVisited(int index1, int index2) {
			System.out.println("isVisited called");

            if (index1 >= 0 && index1 < index1Count && index2 >= 0 && index2 < index2Count) {
				System.out.println("isVisited returned " + indexes[index1][index2]);
                return indexes[index1][index2];
            }
            else {
                System.out.println("Warning! Wrong index value!");
                return false;
            }
        }
        
        public void visit(int index1, int index2, int value1, int value2) {
			System.out.println("visit called, index1: " + index1 + "; index2: " + index2 + "; value1: " + value1 + "; value2: " + value2);
            if (index1 >= 0 && index1 < index1Count && index2 >= 0 && index2 < index2Count) {
                indexes[index1][index2] = true;
                
                ArrayList temp = new ArrayList();
                temp.add(value1);
                temp.add(value2);
                list.add(temp);
            }
            else {
                System.out.println("Warning! Wrong index value!");
                return;
            }
        }
    }
}



