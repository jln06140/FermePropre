package co.simplon.fermepropre;

import java.util.ArrayList;
import java.util.Collections;

public class Ferme {
	
	private Fermier fermier;
	private Terrain[] terrain;
	private ArrayList<Integer>initNbSouris = new ArrayList<Integer>();
	protected static int souris=1500;
	private int nbJournee=0;
	
	public int getNbJournee() {
		return nbJournee;
	}


	public void setNbJournee(int nbJournee) {
		this.nbJournee = nbJournee;
	}


	public Ferme(Fermier fer) {
		this.fermier = fer;
		this.terrain= new Terrain[4];
	}
	
	
	public void initialiseJournee(){
		repartitionSouris(initNbSouris,souris);
		//Création des terrains
		creationTerrain();
	}
	
	public static ArrayList<Integer> repartitionSouris(ArrayList<Integer> initNbSouris, int nbSouris) {
		initNbSouris.add((int) (Math.random()*nbSouris+1));
		initNbSouris.add((int) (Math.random()*(nbSouris-(double)initNbSouris.get(0))+1));
		initNbSouris.add((int) (Math.random()*(nbSouris-(double)initNbSouris.get(0)-(double)initNbSouris.get(1))+1));
		initNbSouris.add(nbSouris-initNbSouris.get(0)-initNbSouris.get(1)-initNbSouris.get(2));
		Collections.shuffle(initNbSouris);
		return initNbSouris;
	}
	
	public void creationTerrain() {
		terrain[0] = new Terrain ('A', initNbSouris.get(0));
		terrain[1] = new Terrain ('B', initNbSouris.get(1));
		terrain[2] = new Terrain ('C', initNbSouris.get(2));
		terrain[3] = new Terrain ('D', initNbSouris.get(3));
	}
	
	public void journee() {
			fermier.tirageAleatoireChat(fermier.getGroupe());
			fermier.placeChat(fermier.getGroupe());
			for (Chat c : fermier.getGroupeChat()) {
				c.chasse(terrain);
			}
			changementZoneSouris();
			nbJournee++;
			System.out.println("journee " +getNbJournee()+" :");
			fermier.rapportChat();
	}
	
	
	public void changementZoneSouris() {
		int [] temp = new int[4];
		for (int i =0;i<4;i++) {
			temp[i]= terrain[i].getNbsouris()/2;
		}
		for (int i =1;i<4;i++) { //On ne boucle que dans les 3 dernieres zones. La zone D allant dans A on la fait à part.
			terrain[i].setNbsouris((terrain[i].getNbsouris()/2)+temp[i-1]);
		}
		terrain[0].setNbsouris((terrain[0].getNbsouris()/2)+temp[3]); //Ajout de D dans A.
	}
	
	public ArrayList<Integer> getInitNbSouris() {
		return initNbSouris;
	}
	
	public void rapportFin() {
		System.out.println("la chasse a dur�e "+ getNbJournee() + " jours" );
		System.out.println("il reste "+ souris + " souris");
		fermier.rapportFinal();
	}


	public Fermier getFermier() {
		return fermier;
	}


	public void setFermier(Fermier fermier) {
		this.fermier = fermier;
	}


	public Terrain[] getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain[] terrain) {
		this.terrain = terrain;
	}


	public static int getSouris() {
		return souris;
	}


	public static void setSouris(int souris) {
		Ferme.souris = souris;
	}


	public void setInitNbSouris(ArrayList<Integer> initNbSouris) {
		this.initNbSouris = initNbSouris;
	}
}
	
