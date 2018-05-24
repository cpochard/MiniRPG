package com.cpochard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherCombat extends JFrame {
	Heros h;
	Monstres m;
	JPanel panneau;
	JLabel labelHero;
	JLabel labelMonstre;
	JLabel labelResultat;
	JButton boutonQuitter;

	public AfficherCombat (Heros h, Monstres m) {
		this.h=h;
		this.m=m;
		this.setTitle("Faire un combat");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panneau = new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);

		labelHero = new JLabel ();
		labelHero.setBounds(5, 20, 250, 300);
		panneau.add(labelHero);

		labelMonstre = new JLabel ();
		labelMonstre.setBounds(255, 20, 250, 300);
		panneau.add(labelMonstre);

		labelResultat = new JLabel();
		labelResultat.setBounds(5, 350, 250, 300);
		panneau.add(labelResultat);
	}

	public JButton getBoutonQuitter() {
		return boutonQuitter;
	}

	public void combatAffiche (Combat c) {
		labelHero.setText("<html>Nom du Hero : " + h.getNom() + "<br>Points de vie : "+h.getPointsVie() + "<br>Points de vie Max : "+ h.getPointsVieMax() + "<br>Attaque : "+h.getAttaque()+"<br>Armure : "+h.getArmure()+"<br>Expérience : "+h.getExperience()+"<br>Or : "+h.getOr()+"<br>Vitesse : "+h.getVitesse());
		labelMonstre.setText("<html>Nom du Monstre : " + m.getNom() + "<br>Points de vie : "+m.getPointsVie() + "<br>Points de vie Max : "+ m.getPointsVieMax()+"<br>Attaque : "+m.getAttaque()+"<br>Armure : "+m.getArmure()+"<br>Niveau : "+m.getNiveau()+"<br>Vitesse : "+m.getVitesse());
		labelResultat.setText(c.combattre());
		boutonQuitter = new JButton();
		boutonQuitter.setText("Fin du combat");
		boutonQuitter.setBounds(255, 350, 250, 300);
		boutonQuitter.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				c.getFenetre().setVisible(false);
				labelHero.setText("<html>Nom du Hero : " + h.getNom() + "<br>Points de vie : "+h.getPointsVie() + "<br>Points de vie Max : "+ h.getPointsVieMax() + "<br>Attaque : "+h.getAttaque()+"<br>Armure : "+h.getArmure()+"<br>Expérience : "+h.getExperience()+"<br>Or : "+h.getOr()+"<br>Vitesse : "+h.getVitesse());
			}
		}
				);
		panneau.add(boutonQuitter);
		panneau.repaint();
	}

}
