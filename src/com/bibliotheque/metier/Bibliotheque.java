package com.bibliotheque.metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Document> documents;
    private HashMap<String, Document> rechercheRapide;
    private int nextId; // Champ pour gérer les IDs des documents

    public Bibliotheque() {
        documents = new ArrayList<>();
        rechercheRapide = new HashMap<>();
        nextId = 1; // Initialiser à 1 ou un autre numéro de départ
    }

    // Méthode pour obtenir le prochain ID unique
    public int getNextId() {
        return nextId++;
    }

    public void ajouterDocument(Document doc) {
        documents.add(doc);
        rechercheRapide.put(doc.getTitre(), doc); // Utiliser le getter pour le titre
    }

    public void emprunterDocument(int id) {
        Document doc = rechercherDocumentParId(id); // Utilisation de la méthode pour rechercher par ID
        if (doc != null) {
            doc.emprunter();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    public void retournerDocument(int id) {
        Document doc = rechercherDocumentParId(id); // Utilisation de la méthode pour rechercher par ID
        if (doc != null) {
            doc.retourner();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    public void afficherTousLesDocuments() {
        for (Document doc : documents) {
            doc.afficherDetails();
        }
    }

    public Document rechercherDocument(String critere) {
        return rechercheRapide.get(critere);
    }

    // Méthode pour rechercher un document par ID
    public Document rechercherDocumentParId(int id) {
        for (Document doc : documents) {
            if (doc.getId() == id) {
                return doc;
            }
        }
        return null; // Retourne null si le document n'est pas trouvé
    }

    // Méthode pour obtenir la liste des documents
    public ArrayList<Document> getDocuments() {
        return documents;
    }
}
