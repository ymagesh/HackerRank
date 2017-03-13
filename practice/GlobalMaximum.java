package com.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class GlobalMaximum {

	static int[] inputArray ;
	static int globalMax = 0;
	
	static List<int[]> combinationList = new ArrayList<int[]>() ;
	static List<int[]> pairList = null ;
	static SortedSet<Integer> globalMaxSet = new TreeSet<>();
	/* 
		arr[]  ---> Input Array
	    data[] ---> Temporary array to store current combination
	    start & end ---> Staring and Ending indexes in arr[]
	    index  ---> Current index in data[]
	    r ---> Size of a combination to be printed 
    */
    private static void combinationUtil(int arr[], int data[], int start,
			int end, int index, int r, List<int[]> combList) {
    	int[] combination = new int[r];
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int j = 0; j < r; j++){
				combination[j] = data[j] ;
				System.out.print(data[j] + " ");
			}
			combList.add(combination);
			System.out.println("");
			
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r,combList);
		}
	}

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
	private static void subSequenceCombination(int arr[], int n, int r, List<int[]> combList) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temporary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r, combList);
	}
	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
		System.out.println("enter n value");
		int noOfArrayElements =sc.nextInt();
		System.out.println("enter array value"); // 1 4 6 3
		inputArray = new int[noOfArrayElements];
		scanInput(sc, noOfArrayElements, inputArray);
		System.out.println("enter subseq value m: "); // 9
		int subSeq = sc.nextInt(); 
		
		subSequenceCombination(inputArray, inputArray.length, subSeq, combinationList);
		for(int[] subSeqArray: combinationList){
			System.out.println("combinationList==> "+combinationList.size());
			findGlobalMax(subSeqArray);
		}
		System.out.println("Global Maximum ===>> "+ globalMaxSet);
		System.out.println("Global Maximum ===>> "+ globalMaxSet.last());
	}
	
	private static void findGlobalMax(int[] subSeqArray) {
		pairList = new ArrayList<>();
		findPairs(subSeqArray, subSeqArray.length, 2, pairList);
		System.out.println("pairList => " + pairList.size());
		int currMin = 10 ^ 18;
		for (int[] pairs : pairList) {

			int absDiff = Math.abs(pairs[0] - pairs[1]);
			if (absDiff < currMin) {
				currMin = absDiff;
			}
		}

		if (globalMax < currMin) {
			globalMax = currMin;
		}
		globalMaxSet.add(globalMax);
		System.out.println("globalMax ==> "+globalMax);
	}

	private static void findPairs(int[] subSeqArray, int length, int i, List<int[]> pairList2) {
		
		subSequenceCombination(subSeqArray, subSeqArray.length, 2, pairList);
	}

	private static void scanInput(Scanner sc, int n, int[] intel) {
		for(int i = 0;i < n;i++){
			intel[i] = sc.nextInt();
		}
	}
	
}
