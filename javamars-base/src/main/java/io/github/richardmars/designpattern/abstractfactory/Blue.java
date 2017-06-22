package io.github.richardmars.designpattern.abstractfactory;

public class Blue implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Blue:fill() method.");
	}

}
