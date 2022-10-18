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
		this.villageois[this.nbVillageois] = gau;
		this.nbVillageois++;
	}

	public Gaulois trouverHabitant(int numVillageois) {
		return this.villageois[numVillageois];
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		/* Gaulois gaulois = village.trouverHabitant(30); */
	}

}
