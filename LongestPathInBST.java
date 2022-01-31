package com.greatlearning.lab3;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}

class BST {
    Node root;

    public void insert(int val) {
        Node newNode = new Node(val);

        // Set starting node as root
        if (root == null) {
            root = newNode;
            return;
        }

        // Prev -> to remember parent
        Node prev = null;
        // To iterate for finding next parent
        Node temp = root;

        // Finding Parent to Add Node
        while (temp != null) {
            prev = temp;
            if (temp.value >= val)
                temp = temp.left;
            else if (temp.value < val)
                temp = temp.right;
        }

        // Deciding whether to store as left | Right Child
        if (prev.value >= val)
            prev.left = newNode;
        else
            prev.right = newNode;
    }

    public Node getRoot() {
        return root;
    }

}

class LongestPathInBST {

    public static ArrayList<Integer> findLongestPath(Node root) {

        // is no root -> return empty list
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> rightSubTree = findLongestPath(root.right);
        ArrayList<Integer> leftSubTree = findLongestPath(root.left);

        if (rightSubTree.size() < leftSubTree.size())
            leftSubTree.add(root.value);
        else
            rightSubTree.add(root.value);

        return leftSubTree.size() > rightSubTree.size() ? leftSubTree : rightSubTree;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BST tree = new BST();

        System.out.println("Insert nodes into the tree: [Press -1 to stop Insert]");
        int insertValue = 0;
        while (insertValue != -1) {
            insertValue = sc.nextInt();
            if (insertValue == -1)
                break;
            tree.insert(insertValue);
        }

        ArrayList<Integer> output = findLongestPath(tree.getRoot());
        int n = output.size();

        System.out.println("Longest Path in the tree is:");
        for (int i = n - 1; i >= 0; i--)
            System.out.print((i != n - 1 ? " -> " : "") + output.get(i));

        sc.close();
    }
}
