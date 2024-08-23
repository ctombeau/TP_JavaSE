package com.rh.model;

import java.time.LocalDate;

public class Personne {
	protected String phone;
	protected String nom;
	protected String prenom;
	protected Sexe sexe;
	protected LocalDate dateNaissance;
	
	public Personne() {
		
	}
	
	public Personne(String phone,String nom, String prenom, Sexe sexe, LocalDate dateNaissance) {
		super();
		this.phone = phone;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
		
		return this.nom + " " + this.prenom + " " + this.sexe + " " + this.dateNaissance+ " " + this.phone;
	}
	
	public String fullName() {
		return this.prenom+" "+this.nom.toUpperCase();
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
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		//if(dateNaissance)
		this.dateNaissance = dateNaissance;
	}
}
