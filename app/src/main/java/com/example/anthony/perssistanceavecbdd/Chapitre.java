package com.example.anthony.perssistanceavecbdd;

/**
 * Created by anthony on 15/03/2017.
 */

public class Chapitre {
    private int id;
    private String nom, description;

    public Chapitre(){
        id =0;
        nom ="";
        description="";
    };

    public Chapitre(String n,String desc){
        nom = n;
        description = desc;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nom du chapitre = "+ nom+"\n" + "Description du chapitre "+ description);
        return  sb.toString();
    }
}



