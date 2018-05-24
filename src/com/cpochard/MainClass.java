package com.cpochard;

public class MainClass {

	public static void main(String[] args) {

		Heros h = new Heros ("Tintin", 50, 50, 5, 2, 2, 1, 4);
		Monstres m = new Monstres ("Rasputin", 30, 30, 4,2, 1, 6);
		/*	Combat c = new Combat (hero, monstre);
		Combat c2 = new Combat (hero, monstre);
		Combat c3 = new Combat (hero, monstre);
		Combat c4 = new Combat (hero, monstre);
		Combat c5 = new Combat (hero, monstre);


System.out.println(c.combattre());	
System.out.println(c2.combattre());
System.out.println(c3.combattre());
System.out.println(c4.combattre());
System.out.println(c5.combattre());
		 */

		AfficherJeu fenetre = new AfficherJeu (h, m);

	}

}
