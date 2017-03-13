package com.practice2;

import java.util.Scanner;

class Node {

	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
	
}

public class MyBinarySearch {
	 Node root;
	 int counter = 0;

	public MyBinarySearch() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insertRoot(int data) {
		root = createNode(root, data);
	}

	private Node insertNode(Node node, int key) {
		counter++;
		if(key < node.data){
			if(node.left == null){
				node.left = createNode(node, key);
			}else{
				 insertNode(node.left, key);
			}
		}else{
			if(node.right == null){
				node.right = createNode(node, key);
			}else{
				insertNode(node.right, key);
			}
		}
		return node;
	}

	private Node createNode(Node node, int data) {
		node = new Node(data);
		return node;
	}

	private static void createBST(int[] arrays) {
		MyBinarySearch bst = new MyBinarySearch();
		for(int j = 0; j< arrays.length; j++){
			if(bst.root == null){
				bst.insertRoot(arrays[j]);
			}else{
				bst.insertNode(bst.root, arrays[j]);
			}
			System.out.println(bst.counter);
		}
	}

	public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
 		System.out.println("enter n value");
 		int noOfArrayElements =sc.nextInt();
 		System.out.println("enter array value"); // 1 4 6 3
 		int[] inputArray = new int[noOfArrayElements];
 		scanInput(sc, noOfArrayElements, inputArray);
 		
 		createBST(inputArray);
 		
     }
	private static void scanInput(Scanner sc, int n, int[] intel) {
		for (int i = 0; i < n; i++) {
			intel[i] = sc.nextInt();
		}
	}
}
