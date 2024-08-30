package com.bibliotheque.presentation;

import com.bibliotheque.metier.Bibliotheque;
import com.bibliotheque.metier.Document;
import com.bibliotheque.metier.Livre;
import com.bibliotheque.metier.Magazine;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    public ConsoleUI() {
        bibliotheque = new Bibliotheque();
        scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = 0;
        do {
            System.out.println("\n--- Menu Bibliothèque ---");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Emprunter un document");
            System.out.println("3. Retourner un document");
            System.out.println("4. Afficher tous les documents");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Quitter");
            System.out.print("Veuillez entrer votre choix (1-6) : ");
            choix = scanner.nextInt();
            scanner.nextLine();  // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    ajouterDocument();
                    pause();
                    break;
                case 2:
                    emprunterDocument();
                    pause();
                    break;
                case 3:
                    retournerDocument();
                    pause();
                    break;
                case 4:
                    afficherTousLesDocuments();
                    pause();
                    break;
                case 5:
                    rechercherDocument();
                    pause();
                    break;
                case 6:
                    quitter();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    pause();
            }
        } while (choix != 6);
    }

    private void ajouterDocument() {
        System.out.print("Type de document (1 - Livre, 2 - Magazine) : ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("Date de publication (yyyy-mm-dd) : ");
        String dateStr = scanner.nextLine();
        LocalDate datePublication = LocalDate.parse(dateStr);
        System.out.print("Nombre de pages : ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne

        if (type == 1) {
            System.out.print("ISBN : ");
            String isbn = scanner.nextLine();
            Document livre = new Livre(bibliotheque.getNextId(), titre, auteur, datePublication, nombreDePages, isbn);
            bibliotheque.ajouterDocument(livre);
            System.out.println("Livre ajouté avec succès.");
        } else if (type == 2) {
            System.out.print("Numéro de magazine : ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
            Document magazine = new Magazine(bibliotheque.getNextId(), titre, auteur, datePublication, nombreDePages, numero);
            bibliotheque.ajouterDocument(magazine);
            System.out.println("Magazine ajouté avec succès.");
        } else {
            System.out.println("Type invalide.");
        }
    }

    private void emprunterDocument() {
        System.out.print("ID du document à emprunter : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne
        Document doc = bibliotheque.rechercherDocumentParId(id);
        if (doc != null) {
            doc.emprunter();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    private void retournerDocument() {
        System.out.print("ID du document à retourner : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne
        Document doc = bibliotheque.rechercherDocumentParId(id);
        if (doc != null) {
            doc.retourner();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    private void afficherTousLesDocuments() {
        System.out.println("\n--- Liste des documents ---");
        for (Document doc : bibliotheque.getDocuments()) {
            doc.afficherDetails();
        }
    }

    private void rechercherDocument() {
        System.out.print("Titre du document à rechercher : ");
        String titre = scanner.nextLine();
        Document doc = bibliotheque.rechercherDocument(titre);
        if (doc != null) {
            doc.afficherDetails();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    private void quitter() {
        System.out.println("Au revoir !");
    }

    // Méthode pour faire une pause et attendre une entrée de l'utilisateur
    private void pause() {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.afficherMenu();
    }
}
