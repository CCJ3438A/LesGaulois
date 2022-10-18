package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return this.nom;
	}

	public void ajouterHabitant(Gaulois gau) {
		// if (this.nbVillageois < this.villageois.length) {
		this.villageois[this.nbVillageois] = gau;
		this.nbVillageois++;
		// }
	}

	public Gaulois trouverHabitant(int numVillageois) {
		return this.villageois[numVillageois - 1];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- " + this.trouverHabitant(i + 1).getNom());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		/*
		 * Gaulois gaulois = village.trouverHabitant(30);
		 * 
		 * Car il n'y a pas 31 villageois mais 30, alors des villageois de numéro 0 à 29
		 */
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);

		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		/*
		 * Gaulois gaulois = village.trouverHabitant(1); System.out.println(gaulois);
		 */
		/*
		 * Ce qui est affiché sont les informations du vallageois numéro 1 (indice 0),
		 * ici Astérix
		 */
	}
}
