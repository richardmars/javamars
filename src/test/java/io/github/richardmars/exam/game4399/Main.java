package io.github.richardmars.exam.game4399;

public class Main {
	
	public static void main(String[] args) {
		int heros[] = {2, 3, 5, 4, 6, 7, 6, 7 ,8};
		int hero1 = 0;
		int hero2 = 6;
		FightResult fightResult = Fire(heros, hero1, hero2);
		System.out.println(fightResult);
	}
	
	public static FightResult Fire(int[] heros, int hero1, int hero2) {
		int level1 = 0, level2 = 0;
		
		while(heros[hero1] != hero1)	{	// 到掌门为止 
			hero1 = heros[hero1];
			level1--;
		}
		while(heros[hero2] != hero2)	{	// 到掌门为止 
			hero2 = heros[hero2];
			level2--;
		}
		
		if(hero1 == hero2) return FightResult.ONE_OF_US;
		else if(level1 > level2) return FightResult.WIN;
		else if(level1 < level2) return FightResult.LOSE;
		else  return FightResult.TIE;
	}
}
