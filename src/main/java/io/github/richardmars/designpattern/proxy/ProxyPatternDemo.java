package io.github.richardmars.designpattern.proxy;

public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");
		
		image.display();
		System.out.println("");
		// image will not be loaded again
		image.display();
	}
}
