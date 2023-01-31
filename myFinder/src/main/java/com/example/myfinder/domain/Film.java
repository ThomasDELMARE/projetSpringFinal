package com.example.myfinder.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Film {
    // On crée le film avec les propriétés
    @ApiModelProperty(notes = "Titre du film",name="titre",required=true)
    String titre;
    @ApiModelProperty(notes = "Realisateur du film",name="realisateur",required=true)
    String realisateur;
    @ApiModelProperty(notes = "Acteur principal du film",name="acteurPrincipal",required=true)
    Acteur acteurPrincipal;
    @ApiModelProperty(notes = "Date de sortie",name="dateSortie",required=true)
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
