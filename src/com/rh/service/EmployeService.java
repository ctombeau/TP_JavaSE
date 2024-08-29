package com.rh.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.rh.db.DigicelDb;
import com.rh.model.Employe;
import com.rh.model.Sexe;

public class EmployeService {
    UtilsService utilsService = new UtilsService();
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Employe emp = new Employe();
    
	public void AddEmploye(Employe e) {
		
		System.out.println("\n*****************************Ajout d'un employe*************************************\n ");
		System.out.print("Nom :");
		Scanner scNom = new Scanner(System.in);
		emp.setNom(scNom.nextLine()); 
		
		System.out.print("Prenom :");
		Scanner scPrenom = new Scanner(System.in);
		emp.setPrenom(scNom.nextLine());
		
		String dateNaissance="";
		do {
			System.out.print("Date Naissance (jj-mm-aaaa) :");
			Scanner scDateNaissance = new Scanner(System.in);
			dateNaissance = scDateNaissance.nextLine();
		}while(!dateNaissance.contains("-"));
		setDate(dateNaissance,emp);
		
		Character c=null;
		do {
			System.out.print("Sexe (F ou M) :");
			Scanner scSexe = new Scanner(System.in);
			c = scSexe.next().charAt(0); 
		}while(c!='F' && c!='M');
		setSexe(c,emp);
		
		DigicelDb digicelDb = new DigicelDb();
		digicelDb.saveData("C:/RH/Employe.txt", emp);
		
	}
	
	public void listEmploye()
	{
		DigicelDb digicelDb = new DigicelDb();
		digicelDb.getData("C:/RH/Employe.txt");
	}
	
	public Employe updateEmploye(String code) {
		return null;
	}
	
	public void showEmploye(String code) {
		DigicelDb digicelDb = new DigicelDb();
		digicelDb.getEmploye("C:/RH/Employe.txt",code);
	}
	
	public void deleteemploye(String code) {
		
	}
	
	public void setDate(String date,Employe emp) {
		LocalDate dateLocale=null;
		try {
			dateLocale = LocalDate.parse(date,dtf);
		}
		catch(DateTimeParseException ex) {
			ex.getMessage();
		}
		finally {
			
			emp.setDateNaissance(dateLocale);
		}
	}
	
	public void setSexe(Character c,Employe emp) {
		if(c=='F') {
			emp.setSexe(Sexe.F);
		}	
		else if(c=='M') {
			emp.setSexe(Sexe.M);
		}
			
	}
}
