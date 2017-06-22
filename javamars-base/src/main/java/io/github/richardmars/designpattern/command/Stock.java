package io.github.richardmars.designpattern.command;

public class Stock {
	private String name = "ABC";
	private int quatity = 10;
	
	public void buy() {
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quatity + " ] bought");
	}
	
	public void sell() {
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quatity + " ] sold");
	}
}
