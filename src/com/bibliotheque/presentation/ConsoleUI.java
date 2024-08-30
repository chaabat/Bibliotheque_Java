package com.bibliotheque.presentation;


import com.bibliotheque.metier.Bibliotheque;

import java.util.Scanner;

public class ConsoleUI{
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    public ConsoleUI(){
        bibliotheque = new Bibliotheque();
        scanner = new Scanner(System.in);
    }

    public void afficherMenu(){
        int choix = 0;
        do{
            System.out.println("\n--- Menu Bibliothéque ---");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Emprunter un document");
            System.out.println("3. Retourner un document");
            System.out.println("4. Afficher tous les document");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Quitter");
            System.out.println("Veuillez entrer votre choix (1-6) :");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 :
                    ajouterDocument();
                    pause();
                    break;

                case 2 :
                    emprunterDocument();
                    pause();
                    break;

                case 3 :
                    retournerDocument();
                    pause();
                    break;

                case 4 :
                    afficherTousLesDocuments();
                    pause();
                    break;

                case 5 :
                    rechercherDocument();
                    pause();
                    break;

                case 6 :
                    quitter();
                    break;

                default:
                    System.out.println("Choix invalide , veuillez réessayer.");
                    pause();
            }






        }while (choix !=6);
    }


}