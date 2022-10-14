package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = nbVillageoisMaximum;
		this.villageois = new Gaulois[this.nbVillageois];
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
}
