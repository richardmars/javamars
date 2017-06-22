package io.github.richardmars.exam.thoughtworks;

public class AnimalPostion {
	private String animalId;
	private boolean isFirstAppear;
	private int currentLocationX;
	private int currentLocationY;
	private int lastLocationX;
	private int lastLocationY;
	private int changeX;
	private int changeY;

	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public boolean isFirstAppear() {
		return isFirstAppear;
	}

	public void setFirstAppear(boolean isFirstAppear) {
		this.isFirstAppear = isFirstAppear;
	}

	public int getCurrentLocationX() {
		return isFirstAppear == true ? currentLocationX : lastLocationX + changeX;
	}

	public void setCurrentLocationX(int currentLocationX) {
		this.currentLocationX = currentLocationX;
	}

	public int getCurrentLocationY() {
		return isFirstAppear == true ? currentLocationY : lastLocationY + changeY;
	}

	public void setCurrentLocationY(int currentLocationY) {
		this.currentLocationY = currentLocationY;
	}

	public int getLastLocationX() {
		return lastLocationX;
	}

	public void setLastLocationX(int lastLocationX) {
		this.lastLocationX = lastLocationX;
	}

	public int getLastLocationY() {
		return lastLocationY;
	}

	public void setLastLocationY(int lastLocationY) {
		this.lastLocationY = lastLocationY;
	}

	public int getChangeX() {
		return changeX;
	}

	public void setChangeX(int changeX) {
		this.changeX = changeX;
	}

	public int getChangeY() {
		return changeY;
	}

	public void setChangeY(int changeY) {
		this.changeY = changeY;
	}
}
