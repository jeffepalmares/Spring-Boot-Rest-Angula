package com.test.rest.util;

public enum Priority {

	HIGH(1),MEDIUM(2),LOW(3);
	
	private int value;
	
	private Priority(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
