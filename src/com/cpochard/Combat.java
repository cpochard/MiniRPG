package com.cpochard;

import java.util.Random;

public class Combat {

	protected Monstres monstre;
	protected Heros hero;
	protected AfficherCombat fenetre;

	public AfficherCombat getFenetre() {
		return fenetre;
	}

	public Combat(Heros tmpHero, Monstres tmpMonstre) {
		hero = tmpHero;
		monstre = tmpMonstre;
		fenetre=new AfficherCombat(hero,monstre);
	}

	public void heroAttaque() {
		Random coupHero = new Random();
		int degatHero = (int) (coupHero.nextInt(hero.getAttaque() + 1));
		int damageToMonstre = (degatHero - monstre.getArmure());
		if (damageToMonstre <= 0) {
			damageToMonstre = 1;
			int PVMonstre = (monstre.getPointsVie() - damageToMonstre);
			if (PVMonstre < 0) {
				PVMonstre = 0;
			}
			monstre.setPointsVie(PVMonstre);
		}
	}

	public void monstreAttaque() {
		Random coupMonstre = new Random();
		int degatMonstre = (int) (coupMonstre.nextInt(monstre.getAttaque() + 1));
		int damageToHero = (degatMonstre - hero.getArmure());
		if (damageToHero <= 0) {
			damageToHero = 1;
			int PVHero = (hero.getPointsVie() - damageToHero);
			if (PVHero < 0) {
				PVHero = 0;
			}
			hero.setPointsVie(PVHero);
		}
	}

	public boolean prio() {
		boolean prio = false;
		if (hero.getVitesse() >= monstre.getVitesse()) {
			prio = true;
		}
		return prio;
	}

	public void attaquer() {
		boolean prio = prio();
		if (prio) {
			// Si true (vitesseHero>=vitesseMonstre) alors hero attaque en premier
			heroAttaque();
			monstreAttaque();	
		} else { // Sinon monstre attaque en premier
			monstreAttaque();
			heroAttaque();
		}
	}

	public String victoire() {
		return "Vous avez gagné !";
	}

	public String defaite() {
		return "Vous avez perdu !";
	}

	public String combattre() {
		hero.setPointsVie(hero.getPointsVieMax());
		monstre.setPointsVie(monstre.getPointsVieMax());
		while (hero.getPointsVie() > 0 && monstre.getPointsVie() > 0) {
			attaquer();
			System.out.println("Il reste " + hero.getPointsVie() + " PV au hero");
			System.out.println("Il reste " + monstre.getPointsVie() + " PV au monstre");
		}
		String s;
		if (monstre.getPointsVie() <= 0) {
			s = victoire();
		} else {
			s = defaite();
		}
		int xpHero = hero.getExperience();
		xpHero = xpHero + 20 * (monstre.getNiveau());
		hero.setExperience(xpHero);
		Random nivMonstre = new Random();
		int newNivMonstre = (int) (nivMonstre.nextInt(10 - monstre.getNiveau()) + 1);
		int orHero = hero.getOr();
		orHero = orHero + (int) Math.sqrt(newNivMonstre);
		hero.setOr(orHero);
		System.out.println(
				"Son expérience est de : " + hero.getExperience() + " et il a " + hero.getOr() + " pièces d'or");
		hero.gagnerNiveau();
		return s;
	}
}
