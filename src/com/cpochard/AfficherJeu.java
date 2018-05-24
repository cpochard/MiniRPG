package com.cpochard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherJeu extends JFrame{
	private JPanel panneau;
	JLabel label;
	Combat c;
	Heros h;
	Monstres m;

	public AfficherJeu(Heros h, Monstres m) {
		this.h=h;
		this.m=m;
		this.setTitle("Mini RPG");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		afficherCombattre(h,m);
	}

	public void afficherCombattre(Heros h, Monstres m) {
		panneau = new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		label = new JLabel ();
		label.setBounds(5, 20, 800, 300);
		panneau.add(label);
		miseAJourAffichageHero();
		JButton bouton = new JButton ();
		bouton.setText("Combattre");
		bouton.setBounds(400, 20 , 240, 50);
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bouton.setVisible(false);
				c = new Combat (h, m);
				c.getFenetre().combatAffiche(c);
				c.getFenetre().getBoutonQuitter().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miseAJourAffichageHero();
						bouton.setVisible(true);
					}
				}
						);
			}
		}
				);
		panneau.add(bouton);
		panneau.repaint();
	}

	public void miseAJourAffichageHero() {
		label.setText("<html>Nom du Hero : " + h.getNom() + "<br>Points de vie : "+h.getPointsVie() + "<br>Points de vie Max : "+ h.getPointsVieMax() + "<br>Attaque : "+h.getAttaque()+"<br>Armure : "+h.getArmure()+"<br>Expérience : "+h.getExperience()+"<br>Or : "+h.getOr()+"<br>Vitesse : "+h.getVitesse() );
	}
}
