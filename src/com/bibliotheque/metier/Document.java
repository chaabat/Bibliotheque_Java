package com.bibliotheque.metier;

import java.time.LocalDate;

public abstract class Document {
    protected int id;
    protected String titre;
    protected String auteur;
    protected LocalDate datePublication;
    protected int nombreDePages;
    protected boolean emprunte ; // attribut pour indiquer si le document est deja emprunté


    // Constructeur

    public Document(int id,String titre,String auteur ,LocalDate datePublication,int nombreDePages){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.emprunte = false; // état initiale pour un document n'est pas emprunté

    }

    //Getters
    public int getID(){
        return id;
    }

    public String getTitre(){
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    // Getter et Setter pour emprunte
    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }

// Les méthodes abstraites

   public abstract void emprunter();

   public abstract void retourner();

   public abstract void afficherDetails();

}
