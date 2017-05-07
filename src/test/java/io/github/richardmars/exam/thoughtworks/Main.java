package io.github.richardmars.exam.thoughtworks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String historyData = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/test/java/com/xic/exam/thoughtworks/historyData.txt"));
			historyData = scanner.useDelimiter("\\Z").next();
			scanner.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		String snapShot = SnapShotUtils.getSnapShot(historyData, "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
		System.out.println(snapShot);
	}
}
