package com.example.myMovie.domain;

import java.util.Date;

public class Film {
    // On crée le film avec les propriétés
    String titre, realisateur;
    Acteur acteurPrincipal;
    Date dateDeSortie;

    public Film(String titre, String realisateur, Acteur acteurPrincipal, Date dateDeSortie){
        super();
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteurPrincipal = acteurPrincipal;
        this.dateDeSortie = dateDeSortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(Acteur acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }
}
