package com.rh.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employe extends Personne implements Serializable {
	private double salaire;
    
    public Employe() {
       super();
    }
    
    public Employe(String phone, String nom, String prenom, Sexe sexe, 
    		LocalDate dateNaissance,double salaire) {
    	super(phone,nom,prenom, sexe, dateNaissance);
    	this.salaire=salaire;
    }
    
    @Override
    public String toString() {
    	//Employe emp = new Employe();
    	String result = this.nom + ";"+ this.prenom + ";"+ this.sexe + ";"+ this.dateNaissance;
    	return result;
    }
    
    public double getSalaire() {
    	return this.salaire;
    }
    
    public void setSalaire(double salaire) {
    	this.salaire = salaire;
    }
}
