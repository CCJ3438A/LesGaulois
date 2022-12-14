package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

//	private String prendreParole() {
//		return "Le gaulois " + this.nom + " : ";
//	}

	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

//	public void frapper(Romain romain) {
//		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((this.force / 3) * this.effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans lamâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + this.nom + ", force=" + this.force + "]";
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée. ");
	}

	public static void main(String[] args) {
		Gaulois idefix = new Gaulois("Idéfix", 150);
		System.out.println(idefix);

		System.out.println(idefix.nom);

		idefix.prendreParole();
		idefix.parler("WOUAF WOUAF !");

		idefix.boirePotion(3);

		idefix.frapper(new Romain("soldatouris", 100));
	}
}
