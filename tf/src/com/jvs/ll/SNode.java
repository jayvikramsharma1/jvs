package com.jvs.ll;

public class SNode {
	int data;
	SNode next;
	public SNode(){}
	public SNode(int data, SNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SNode getNext() {
		return next;
	}
	public void setNext(SNode next) {
		this.next = next;
	}
	
	
}
