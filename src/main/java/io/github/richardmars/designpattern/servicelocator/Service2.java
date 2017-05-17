package io.github.richardmars.designpattern.servicelocator;

public class Service2 implements Service {

	@Override
	public String getName() {
		return "Service2";
	}

	@Override
	public void execute() {
		System.out.println("Executing Service2");
	}

}
