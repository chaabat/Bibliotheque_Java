package com.bibliotheque.metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Document> documents;
    private HashMap<String,Document> recherche;
    private int nextId; // Gérer les Ids des document

    public Bibliotheque(){
        documents = new ArrayList<>();
        recherche = new HashMap<>();
        nextId = 1; // état initial de l'Ids
    }

    public int getNextId(){
        return nextId++; // obtenir le prochain Id unique
    }

    public void ajouterDocument(Document doc){
        documents.add(doc);
        recherche.put(doc.getTitre(),doc);// Utiliser le getter pour le titre
    }

    public void emprunterDocument(int id){
        Document doc =rechercherDocumentParId(id); // recherche par Id
        if (doc != null){
            doc.retourner();
        }else{
           System.out.println("Document non trouvé.");
        }
    }
    public Document rechercherDocument(String critere){
        return recherche.get(critere);
    }

    //Méthode pour rechercher un document par ID
    public Document rechercherDocumentParId(int id){
        for (Document doc : documents){
            if(doc.getId() ==id){
                return doc ;
            }
        }
        return null ; // retourne null si le document n'est pas trouvé
    }

    // Méthode pour obtenir la liste des documents

    public ArrayList<Document> getDocuments{
        return documents;
    }
}
