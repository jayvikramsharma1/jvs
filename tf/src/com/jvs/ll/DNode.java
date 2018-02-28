package com.jvs.ll;

public class DNode {
	int data;
	DNode next;
	DNode prev;
	public DNode() {
		
	}
	
	
	public DNode(int data, DNode next, DNode prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}


	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DNode getNext() {
		return next;
	}
	public void setNext(DNode next) {
		this.next = next;
	}
	public DNode getPrev() {
		return prev;
	}
	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	
	
}
