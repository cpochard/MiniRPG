package com.cpochard;

public class Heros extends Personnage {

	public Heros(String tmpNom, int tmpPointsVie, int tmpPointsVieMax, int tmpAttaque, int tmpArmure, int tmpExperience, int tmpOr, int tmpVitesse) {
		super(tmpNom, tmpPointsVie, tmpPointsVieMax, tmpAttaque, tmpArmure, tmpExperience, tmpOr, tmpVitesse);
	}

	public void gagnerNiveau() {
		int niveauHero =0;
		int newNiveau;
		//Faire niveau +1 et calculer XP n�cessaire pour passer au niveau d'apr�s en fonction de ce nouveau niveau
		do {
			niveauHero++;
			newNiveau = 10*((int)Math.pow(2,niveauHero));
			//J'augmente aussi les PVMax, les points d'armure et d'attaque
			this.setPointsVieMax((int)(this.getPointsVieMax()*1.02));
			this.setArmure((int)(this.getArmure()*1.02));
			this.setAttaque((int)(this.getAttaque()*1.02));
			//tant que niveau d'apr�s inf�rieur ou �gal au points d'XP du h�ro
		} while(newNiveau<=this.getExperience());
		System.out.println("Le niveau du h�ro est de : " + niveauHero);
	}



}