package com.jvs.ll;

public class Dll {
	public static void main(String[] args) {
		Dll dll = new Dll();
		int[] arr = {3,4,2,52,6,36,3,7,36,43};
		DNode root = dll.generateDoublyLinkList(arr);
		dll.getSizeOfLinkList(root);
		dll.printAllNodes(root);
	}
	
	public void getSizeOfLinkList(DNode root) {
		DNode current = root;
		int counter = 0;
		while(current.getNext() != null) {
			counter++;
			current = current.getNext();
		}
		System.out.println("Size of Linklist :: " + counter);
	}
	public void printAllNodes(DNode root) {
		DNode current = root;
		while(current.getNext() != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	public DNode generateDoublyLinkList(int arr[]) {
		DNode root = new DNode();
		
		root.setData(arr[0]);
		root.setPrev(null);
		DNode prev = root;
		for(int i: arr) {
			DNode dn =  new DNode();
			dn.setData(i);
			dn.setPrev(prev);
			prev.setNext(dn);
			prev = dn;
		}
		return root;
	}
}


/*DNode root = new DNode();
root.setData(50);
root.setPrev(null);


DNode n1 = new DNode();
n1.setData(20);
n1.setPrev(root);


DNode n2 = new DNode();
n2.setData(30);
n2.setPrev(n1);

DNode n3 = new DNode();
n3.setData(100);
n3.setPrev(n2);

root.setNext(n1);
n1.setNext(n2);
n2.setNext(n3);*/