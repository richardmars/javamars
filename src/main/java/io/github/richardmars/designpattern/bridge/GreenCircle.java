package io.github.richardmars.designpattern.bridge;

public class GreenCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, redius: " + radius + ", x: " + x + ", " + y + "]");
	}

}
