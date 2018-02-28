package com.jvs.ll;

public class Sll {
	public static void main(String[] args) {
		SNode sn = new SNode();
		sn.setData(10);
		
		SNode sn1 = new SNode();
		sn1.setData(2);
		sn.setNext(sn1);
		
		sn1.setNext(new SNode(20, new SNode(15, new SNode(50, new SNode(30, null)))));
		
		SNode current = sn;
		while(current.getNext() != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
		
	}
}
