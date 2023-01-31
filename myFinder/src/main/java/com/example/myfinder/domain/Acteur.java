package com.example.myfinder.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;

public class Acteur {
    @ApiModelProperty(notes = "Nom de l'acteur",name="nom",required=true)
    String nom;
    @ApiModelProperty(notes = "Prenom de l'acteur",name="prenom",required=true)
    String prenom;
    @ApiModelProperty(notes = "Filmographie de l'acteur",name="filmographie",required=true)
    ArrayList<Film> filmographie;
    @ApiModelProperty(notes = "Date de naissance de l'acteur",name="dateNaissance",required=true)
    Date dateDeNaissance;

    public Acteur(String nom, String prenom, ArrayList<Film> filmographie, Date dateDeNaissance){
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.filmographie = filmographie;
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<Film> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(ArrayList<Film> filmographie) {
        this.filmographie = filmographie;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
