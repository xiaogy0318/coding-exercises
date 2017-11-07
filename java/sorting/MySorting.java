import java.util.*;

public class MySorting {
	public static ArrayList mergeTwoOrderedList(ArrayList list1, ArrayList list2) {
		int index1 = 0;
		int index2 = 0;
		
		if (0 == list1.size()) {
			return list2;
		}
		
		if (0 == list2.size()) {
			return list1;
		}
		
		ArrayList resultList = new ArrayList();
		for (int i = 0; i < list1.size() + list2.size(); i++) {
			if ((int)list1.get(index1) <= (int)list2.get(index2)) {
				resultList.add(list1.get(index1));
				index1++;
				if (index1 == list1.size()) {
					while (index2 < list2.size()) {
						resultList.add(list2.get(index2));
						index2++;
					}
					break;
				}
			}
			else {
				resultList.add(list2.get(index2));
				index2++;
				
				if (index2 == list2.size()) {
					while (index1 < list1.size()) {
						resultList.add(list1.get(index1));
						index1++;
					}
					break;
				}				
			}
		}
		return resultList;
	}
	
	public static ArrayList mergeSort(ArrayList list) {
		System.out.println(list.size());
		if (0 == list.size() || 1 == list.size()) {
			return list;
		}
		
		if (2 == list.size()) {
			if ((int)list.get(0) <= (int)list.get(1)) {
				return list;
			}
			else {
				int temp = (int)list.get(0);
				list.set(1, list.get(1));
				list.set(0, temp);
				return list;
			}
		}
		
		//Split the array into two halves
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		
		int halfPoint = list.size()/2;
		
		for (int i = 0; i < list.size(); i++) {
			if (i <= halfPoint) {
				list1.add(list.get(i));
			}
			else {
				list2.add(list.get(i));
			}
		}
		

		return mergeTwoOrderedList(mergeSort(list1), mergeSort(list2));
	}


	public static ArrayList mergeTwoSequentialList(ArrayList list1, ArrayList pivotList, ArrayList list2) {
		System.out.println("mergeTwoSequentialList() list1: " + list1);
		System.out.println("mergeTwoSequentialList() pivotList: " + pivotList);
		System.out.println("mergeTwoSequentialList() list2: " + list2);
		
		int index1 = 0;
		int index2 = 0;
			
		ArrayList resultList = new ArrayList();
		for (int i = 0; i < list1.size(); i++) {
			resultList.add((int)list1.get(i));
		}
		for (int i = 0; i < pivotList.size(); i++) {
			resultList.add((int)pivotList.get(i));
		}
		for (int i = 0; i < list2.size(); i++) {
			resultList.add((int)list2.get(i));
		}
		
		
		return resultList;
	}
	
	public static ArrayList quickSort(ArrayList list) {
		System.out.println("quickSort(): " + list);
		if (0 == list.size() || 1 == list.size()) {
			return list;
		}
		
		if (2 == list.size()) {
			if ((int)list.get(0) <= (int)list.get(1)) {
				return list;
			}
			else {
				int temp = (int)list.get(0);
				list.set(1, list.get(1));
				list.set(0, temp);
				return list;
			}
		}
		
		//Pick the element in the middle as the pivot, and divide the list into two lists.
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList pivotList = new ArrayList();
		
		int halfPoint = list.size()/2;
		int pivot = (int)list.get(halfPoint);
		
		for (int i = 0; i < list.size(); i++) {
			if ((int)list.get(i) < pivot) {
				list1.add(list.get(i));
			}
			else if ((int)list.get(i) > pivot) {
				list2.add(list.get(i));
			}
			else {
				pivotList.add(pivot);
			}
			
			/*
			//make sure no empty list
			if(0 == list1.size()) {
				int temp = (int)list2.get(0);
				list1.add(temp);
				list2.remove(0);
			}
			if(0 == list2.size()) {
				int temp = (int)list1.get(0);
				list2.add(temp);
				list1.remove(0);
			}
			*/

		}
		

		return mergeTwoSequentialList(quickSort(list1), pivotList, quickSort(list2));
	}
	
	public static void main(String[] args) {
		/*
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		
		ArrayList list2 = new ArrayList();
		list2.add(2);
		list2.add(4);
		list2.add(6);

		//System.out.println(mergeTwoOrderedList(list1, list2));
		System.out.println(mergeTwoSequentialList(list1, list2));
		*/
		
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(6);		
		System.out.println(quickSort(list));
		
		

	}
}