package com.practice2;

import java.util.ArrayList;
import java.util.Scanner;

public class PriceDiscount {
	//static int[] _prices ;
	
	public static void finalPrice(int[] prices){
		int[] discount = new int[prices.length];
		for (int j = 0; j < prices.length-1; j++) {
			if ((j + 1) > prices.length) {
				discount[j] = 0;
			} else if (prices[j] >= prices[j + 1]) {
				discount[j] = prices[j + 1];
			} else if (prices[j] < prices[prices.length-1]) {
				discount[j] = 0;
			} else {
				discount[j] = prices[prices.length-1];
			}
			
		}
		discount[prices.length-1] = 0;
		
		int sum=0;
		ArrayList<Integer> indexes= new ArrayList<>();
		for(int k =0; k< discount.length; k++){
			sum=sum+ (prices[k]-discount[k]);
			if(discount[k]==0){
				indexes.add(k);
			}
		}
		System.out.println(sum);
		for(int ks=0;ks<indexes.size();ks++){
			System.out.print(indexes.get(ks)+" ");			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter n value");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] _prices = new int[n];
		for(int i =0;i<_prices.length;i++){
			_prices[i]=sc.nextInt();
		}
		//discount = new int[n];
		finalPrice(_prices);		
				
		
	}
}
