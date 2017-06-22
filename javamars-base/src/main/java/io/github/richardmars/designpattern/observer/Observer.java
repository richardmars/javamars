package io.github.richardmars.designpattern.observer;

public abstract class Observer {
	public Subject subject;
	public abstract void update();
}
