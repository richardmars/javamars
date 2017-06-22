package io.github.richardmars.designpattern.interceptfilter;

public class DebugFilter implements Filter{

	@Override
	public void execute(String request) {
		System.out.println("request log: " + request);
	}

}
