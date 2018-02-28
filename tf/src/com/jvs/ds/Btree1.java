package com.jvs.ds;


public class Btree1 {
	Node root;
	public Btree1() {
		root = null;
	}
	public Btree1(int item) {
		root.key = item;
	}
	
	public Node addNodes(int item) {
		Node root = insRecNode(this.root, item);
		return root;
	}
	
	public Node insRecNode(Node root, int item) {
		if(root == null) {
			return root = new Node(item);
		}
		else {
			if(item <= root.key) {
				root.left.key = item;
				return root.left;
			}
			if(item >= root.key) {
				root.right.key = item;
				return root.right;
			}
		}
		return root;
	}
	public static void main(String[] args) {
		Btree1 bt = new Btree1();
		Node rootNode = bt.addNodes(50);
		bt.addNodes(49);
		bt.addNodes(20);
	}
}
