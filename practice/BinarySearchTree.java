package com.practice2;

class Node1 {

    int data;
    Node1 left, right;

    Node1(int d) {
        data = d;
        left = right = null;
    }
}

class Index {

    int index = 0;
}

public class BinarySearchTree {
	Index index = new Index();
    int counter = 0;
    // A recursive function to construct Full from pre[]. preIndex is used
    // to keep track of index in pre[].
    Node1 constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {
        
        // Base case
        if (preIndex.index >= size || low > high) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at
        // preIndex from pre[] and make it root, and increment preIndex
        Node1 root = new Node1(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        // If the current subarry has only one element, no need to recur
        if (low == high) {
            return root;
        }

        // Search for the first element greater than root
        int i;
        for (i = low; i <= high; ++i) {
            
            if (pre[i] > root.data) {
            	++counter;
                break;
            }
            
        }
        
        // Use the index of element found in preorder to divide preorder array in
        // two parts. Left subtree and right subtree
        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
        System.out.println("===>"+preIndex.index);
        root.right = constructTreeUtil(pre, preIndex, i, high, size);
        //System.out.println("===>"+preIndex.index);
        return root;
    }

    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    Node1 constructTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size - 1, size);
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node1 node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.println(node.data + " ");
        printInorder(node.right);
        
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int pre[] = new int[]{2,1,3}; 
        //int pre[] = new int[]{1,2,3};
        int size = pre.length;
        Node1 root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

}

