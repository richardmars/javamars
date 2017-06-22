package io.github.richardmars.designpattern.frontcontroller;

public class FrontControllerPatternDemo {
	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		frontController.dispatchRequest("STUDENT");
		frontController.dispatchRequest("HOME");
	}
}
