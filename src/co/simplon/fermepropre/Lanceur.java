package co.simplon.fermepropre;


public class Lanceur {
	
	
	public static boolean sourisVivante() {
		boolean retour = false;
		if(Ferme.souris <= 0) {
			retour = true;
		}
		return retour;
	}

	public static void main(String[] args) {
		Fermier fermier1 = new Fermier("bebert");
		Ferme ferme1 = new Ferme(fermier1);
		ferme1.initialiseJournee();
		while (sourisVivante() == false) {
			ferme1.journee();
		}
		System.out.println();
		ferme1.rapportFin();
	}
}
