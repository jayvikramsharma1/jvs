package com.jvs.ds;

class Node {
	int key;
	Node left;
	Node right;
	Node(int item) {
		this.key = item;
		left = null;
		right = null;
	}
}
public class btree {
	Node root;
	static Node mainRoot;
	btree() {
		root =  null;
	}
	
	btree(int item) {
		root = new Node(item);
		mainRoot = root;
	}
	
	public void addNode(int item) {
		root = insertRec(root, item);
	}
	
	public Node insertRec(Node root, int item) {
		if(root == null) {
			root = new Node(item);
			mainRoot = root;
			return root;
		}
		else {
			if(item <= root.key) {
				System.out.println("Inserting to left");
				root.left = new Node(item);
				return root.left;
			}
			if(item >= root.key) {
				System.out.println("Inserting to right");
				root.right = new Node(item);
				return root.right;
			}
		}
		return root;
	}
	public static void main(String[] args) {
		btree bt = new btree();
		bt.addNode(50);
		bt.addNode(20);
		bt.addNode(40);
		bt.addNode(30);
		bt.addNode(10);
		bt.addNode(60);
		bt.addNode(70);
		bt.addNode(80);
		bt.addNode(90);
		bt.addNode(100);
		bt.addNode(110);
		bt.addNode(120);
		bt.addNode(130);
		bt.addNode(140);
		bt.addNode(150);
		bt.addNode(160);
		bt.addNode(170);
		bt.addNode(180);
		bt.printAllNodes(mainRoot);
	}
	
	public void printAllNodes(Node root) {
		if(root != null) {
			System.out.println(root.key);
			printAllNodes(root.left);
			printAllNodes(root.right);
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	
}
