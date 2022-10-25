package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	private String texte;

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

//	public void recevoirCoup(int forceCoup) {
//		assert this.force > 0;
//		int postCondForce = this.force;
//		this.force -= forceCoup;
//
//		if (this.force > 0) {
//			this.parler("Aïe");
//		} else {
//			this.parler("J'abandonne...");
//		}
//		assert this.force < postCondForce;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert this.force > 0;
		int oldForce = this.force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		this.force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		 }
		switch (this.force) {
		case 0:
			this.parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			this.parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert this.force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement saforce est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
