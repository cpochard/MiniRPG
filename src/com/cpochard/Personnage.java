package com.cpochard;

public class Personnage {

	protected int pointsVieMax;
	protected int pointsVie;
	protected int attaque;
	protected int armure;
	protected int experience;
	protected int or;
	protected int niveau;
	protected int vitesse;

	public Personnage(String tmpNom, int tmpPointsVie, int tmpPointsVieMax, int tmpAttaque, int tmpArmure,
			int tmpExperience, int tmpOr, int tmpVitesse) {
		nom = tmpNom;
		pointsVie = tmpPointsVie;
		pointsVie = pointsVieMax = tmpPointsVieMax;
		attaque = tmpAttaque;
		armure = tmpArmure;
		experience = tmpExperience;
		or = tmpOr;
		vitesse = tmpVitesse;
	}

	public Personnage(String tmpNom, int tmpPointsVie, int tmpPointsVieMax, int tmpAttaque, int tmpArmure,
			int tmpNiveau, int tmpVitesse) {
		nom = tmpNom;
		pointsVie = tmpPointsVie;
		pointsVie = pointsVieMax = tmpPointsVieMax;
		attaque = tmpAttaque;
		armure = tmpArmure;
		niveau = tmpNiveau;
		vitesse = tmpVitesse;
	}

	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getArmure() {
		return armure;
	}
	public void setArmure(int armure) {
		this.armure = armure;
	}

	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getOr() {
		return or;
	}
	public void setOr(int or) {
		this.or = or;
	}

	public int getPointsVie() {
		return pointsVie;
	}
	public void setPointsVie(int newPointsVie) {
		pointsVie = newPointsVie;
	}

	public int getPointsVieMax() {
		return pointsVieMax;
	}
	public void setPointsVieMax(int pointsVieMax) {
		this.pointsVieMax = pointsVieMax;
	}

	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	protected String nom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}