package co.simplon.fermepropre;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Chat {
	
	private String name;
	private int age;
	private int proiesNuit;
	private int proiesTotal;
	private char zone=' ';
	
	public Chat(String n, int a) {
		this.name=n;
		this.age=a;
		this.proiesNuit=0;
		this.proiesTotal=0;
		this.zone=' ';
	}

	public void goZone(char zone) {
		this.zone= zone;
	}

	public void chasse(Terrain[] t) {
		int i=0;
		setProiesNuit(0);
		while (this.zone!=t[i].getNom()) {   // TODO A transformer en objet.
			i++;
		}
		
		//Proies suivant l'age du chat
		setProiesNuit(nbSourisAChasser());
		
		if (this.age>10) {
			setProiesNuit((int)Math.ceil((double)getProiesNuit()/3));
		}
		if (this.age<3) {
			setProiesNuit((int)Math.ceil((double)getProiesNuit()/4));
		}
		else {
			setProiesNuit((int)Math.ceil((double)getProiesNuit()/2));
		}
		
		setProiesTotal(getProiesTotal() + getProiesNuit());
		
		t[i].setNbsouris(t[i].getNbsouris()-getProiesNuit());
		Ferme.souris-=getProiesNuit();
	}
	
	public int nbSourisAChasser() {
		int retour=0;
		if(Ferme.souris >=30) {
			retour=ThreadLocalRandom.current().nextInt(15, 30 + 1);
		}
		else if(Ferme.souris > 15) {
			retour =ThreadLocalRandom.current().nextInt(15, Ferme.souris+ 1);
		}
		else {
			retour = Ferme.souris;
		}
		return retour;
	}
	
	public static Comparator<Chat> ComparatorProies = new Comparator<Chat>() {     
        @Override
        public int compare(Chat e1, Chat e2) {
            return (int) (e1.getProiesTotal() - e2.getProiesTotal());
        }
    };
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getProiesNuit() {
		return proiesNuit;
	}

	public void setProiesNuit(int proiesNuit) {
		this.proiesNuit = proiesNuit;
	}

	public int getProiesTotal() {
		return proiesTotal;
	}

	public void setProiesTotal(int proiesTotal) {
		this.proiesTotal = proiesTotal;
	}

	public char getZone() {
		return zone;
	}

	public void setZone(char zone) {
		this.zone = zone;
	}


}
