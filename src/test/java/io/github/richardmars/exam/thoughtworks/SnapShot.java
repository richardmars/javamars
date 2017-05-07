package io.github.richardmars.exam.thoughtworks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SnapShot {

	private String id;

	private Date date;
	private List<AnimalPostion> animalPostions = new ArrayList<>();
	private SnapShot lastSnapShot;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<AnimalPostion> getAnimalPostions() {
		return animalPostions;
	}

	public void setAnimalPostions(List<AnimalPostion> animalPostions) {
		this.animalPostions = animalPostions;
	}

	public SnapShot getLastSnapShot() {
		return lastSnapShot;
	}

	public void setLastSnapShot(SnapShot lastSnapShot) {
		this.lastSnapShot = lastSnapShot;
	}
}
