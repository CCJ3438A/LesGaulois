package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
		
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
		
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
		+ romain.getNom());
		romain.recevoirCoup((force / 3) * this.effetPotion);
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est "+ this.effetPotion +" fois décuplée. ");
	}
	
	public static void main(String[] args) {
		Gaulois idefix = new Gaulois("Idéfix",150);
		System.out.println(idefix);
		
		System.out.println(idefix.nom);
		
		idefix.prendreParole();
		idefix.parler("WOUAF WOUAF !");
		
		idefix.boirePotion(3);
		
		idefix.frapper(new Romain("soldatouris",100));
	}
}
