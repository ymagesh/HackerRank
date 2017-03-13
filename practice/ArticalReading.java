package com.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArticalReading {

	static int[] intel ;
	static int[] pages ;
	
	static List<int[]> combinationList = new ArrayList<int[]>() ;
	static List <Integer> intellSum = new ArrayList<>();
	/* 
		arr[]  ---> Input Array
	    data[] ---> Temporary array to store current combination
	    start & end ---> Staring and Ending indexes in arr[]
	    index  ---> Current index in data[]
	    r ---> Size of a combination to be printed 
    */
    private static void combinationUtil(int arr[], int data[], int start,
			int end, int index, int r) {
    	int[] combination = new int[r];
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int j = 0; j < r; j++){
				combination[j] = data[j] ;
				System.out.print(data[j] + " ");
			}
			combinationList.add(combination);
			System.out.println("");
			
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = i;
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
	private static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temporary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

    /*Driver function to check for above function*/
    public static void main (String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
		System.out.println("enter n value");
		int noOfIntell =sc.nextInt();
		System.out.println("enter intellectuals value"); // 1 4 6 3
		intel = new int[noOfIntell];
		scanInput(sc, noOfIntell, intel);
		System.out.println("enter m value");
		int noOfPages= sc.nextInt();
		System.out.println("enter pages value");// 1 2 2 3
		pages = new int[noOfPages];
		scanInput(sc, noOfPages, pages);
		System.out.println("enter max pages to read "); // 9
		int maxPagesRead = sc.nextInt(); 
    	
        //int arr[] = {1, 2, 3, 4, 5};
        //int r = 3;
        //int n = intel.length;
        for(int k = 1; k <= intel.length; k++){
        	printCombination(intel, intel.length, k);
        }
        
        //Iterate the combinationSet.
        //get the pages values corresponding to indices from the combination and sum all the values.
        //compare sum with the maxPagesRead and add to the list. 
        //sort the list and find the max
        findMax(maxPagesRead);
        
    }

	private static void findMax(int maxPagesRead) {
		for (int[] data: combinationList){
			
			int sum = 0;
			sum = sumOfValues(data, sum, pages);
			if((sum*2) <= maxPagesRead){
				int sum2 = 0;
				intellSum.add(sumOfValues(data, sum2, intel));
			}
		}
		Collections.sort(intellSum);
		System.out.println(intellSum);
		System.out.println(intellSum.get(intellSum.size()-1));
	}

	private static int sumOfValues(int[] data, int sum3, int[] arr) {
		for (int l = 0; l < data.length; l++){
			sum3 = sum3 + arr[data[l]];
		}
		return sum3;
	}

	private static void scanInput(Scanner sc, int n, int[] intel) {
		for(int i = 0;i < n;i++){
			intel[i] = sc.nextInt();
		}
	}

}
