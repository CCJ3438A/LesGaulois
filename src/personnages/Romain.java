package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert this.force > 0;
		int postCondForce = this.force;
		this.force -= forceCoup;

		if (this.force > 0) {
			this.parler("Aïe");
		} else {
			this.parler("J'abandonne...");
		}
		assert this.force < postCondForce;
	}

	public void sEquiper(Equipement eqi) {
		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (this.equipements[0] == eqi) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + eqi.toString() + ".");
				break;
			}
		default:
			this.equipements[this.nbEquipement] = eqi;
			this.nbEquipement++;
			System.out.println("Le soldat " + this.nom + " s'équipe avec un " + eqi.toString() + ".");
		}
	}

	public static void main(String[] args) {
		Romain soldatouris2 = new Romain("Minus", 6);
		assert soldatouris2.force > 0;

		soldatouris2.prendreParole();
		soldatouris2.parler("EN GAAAAAAAAAAAAAAAAARRRRDE !");
		soldatouris2.recevoirCoup(100);

		Equipement eq = Equipement.BOUCLIER;
		Equipement eq2 = Equipement.CASQUE;

		// System.out.println(eq + "\n" + eq2);

		soldatouris2.sEquiper(eq2);
		soldatouris2.sEquiper(eq2);
		soldatouris2.sEquiper(eq);
		soldatouris2.sEquiper(eq);
	}
}
