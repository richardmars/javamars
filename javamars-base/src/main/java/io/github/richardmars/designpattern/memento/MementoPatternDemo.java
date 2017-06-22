package io.github.richardmars.designpattern.memento;

public class MementoPatternDemo {
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMememto());
		
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMememto());
		
		originator.setState("State #4");
		careTaker.add(originator.saveStateToMememto());
		System.out.println(" Current State: " + originator.getState());
		
		originator.getStateFromMemento(careTaker.get(0));
		System.err.println(" First saved state: " + originator.getState());
		
		originator.getStateFromMemento(careTaker.get(1));
		System.err.println(" Second saved state: " + originator.getState());
	}
}
