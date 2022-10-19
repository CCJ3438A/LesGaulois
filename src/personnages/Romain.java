package personnages;

public class Romain {
	private String nom;
	private int force;

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

	public static void main(String[] args) {
		Romain soldatouris2 = new Romain("soldatouris2", 6);
		assert soldatouris2.force > 0;

		soldatouris2.prendreParole();
		soldatouris2.parler("EN GAAAAAAAAAAAAAAAAARRRRDE !");
		soldatouris2.recevoirCoup(100);
	}
}
