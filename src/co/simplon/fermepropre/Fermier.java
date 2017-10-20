package co.simplon.fermepropre;

import java.util.ArrayList;
import java.util.Collections;

public class Fermier {
	
	private String nom;
	private ArrayList<Chat> groupeChat;
	
	public Fermier (String name) {
		this.nom=name;
		this.creationChat(); //Appel la méthode de création des chats.
	}

	public void creationChat() {
		groupeChat =new ArrayList<Chat>();
		groupeChat.add(new Chat("Nemo",5));
		groupeChat.add(new Chat("Garfield",1));
		groupeChat.add(new Chat("Fripouille",15));
		groupeChat.add(new Chat("Princesse",2));
		groupeChat.add(new Chat("Mimine",7));
	}

	public static char lanceDe() {
		char zone = ' ';
	    final String alphabet = "ABCD";
		int face=(int) (Math.random()*3);

	    for (int i = 0; i < alphabet.length(); i++) {
	        zone = alphabet.charAt(face);
	    }	
		return zone;
	}
	
	public void tirageAleatoireChat(ArrayList<Chat> groupeChat){
		Collections.shuffle(groupeChat);
	}

	public void placeChat(ArrayList<Chat> groupeChat) {
		for (Chat chat : groupeChat) {
			chat.goZone(lanceDe());
		}
	}
	
	public void rapportChat() {
		System.out.println("************");
		
		for(Chat chat : groupeChat) {
			System.out.println(chat.getName() + " a tue " + chat.getProiesNuit() +" souris.");
		}
		System.out.println("**********************");
	}
	

	public void rapportFinal() {
		System.out.println("**********************");
		Collections.sort(groupeChat, Chat.ComparatorProies);
		  
		  System.out.println("liste des Chats par nombres souris tuees:");
		  for(Chat e:groupeChat)
		   System.out.println(e.getName() +" a chasse " +e.getProiesTotal()+" souris");
		
	}
	
	public ArrayList<Chat> getGroupe() {
		return groupeChat;
	}

	public void setGroupe(ArrayList<Chat> groupe) {
		this.groupeChat = groupe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Chat> getGroupeChat() {
		return groupeChat;
	}

	public void setGroupeChat(ArrayList<Chat> groupeChat) {
		this.groupeChat = groupeChat;
	}
	
	
}
