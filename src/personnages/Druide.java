package personnages;

import java.util.Random;

public class Druide {

	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin
				+ " à " + effetPotionMax + ".");
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + this.nom + " : ";
	}

	public void preparerPotion() {
		Random force = new Random();
		do {
			this.forcePotion = force.nextInt(this.effetPotionMax);
		} while (this.forcePotion < this.effetPotionMin);

		if (this.forcePotion > 7) {
			this.parler("J'ai préparé une super potion de force " + this.forcePotion + ".");
		} else {
			this.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + this.forcePotion
					+ ".");
		}
	}

	public void booster(Gaulois gau) {
		if (gau.getNom() == "Obélix") {
			this.parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gau.boirePotion(this.forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);

		panoramix.preparerPotion();
	}
}
