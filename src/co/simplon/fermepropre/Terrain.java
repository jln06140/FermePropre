package co.simplon.fermepropre;

public class Terrain {
	private char nom = ' ';
	private int nbsouris;
	
	
	
	public Terrain (char nomTerrain, int souris) {
		this.nom = nomTerrain;
		this.nbsouris=souris;
	}



	public char getNom() {
		return nom;
	}



	public void setNom(char nom) {
		this.nom = nom;
	}



	public int getNbsouris() {
		return nbsouris;
	}



	public void setNbsouris(int nbsouris) {
		this.nbsouris = nbsouris;
	}
	
	

}
