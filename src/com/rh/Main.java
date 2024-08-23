package com.rh;

import java.io.InputStream;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.rh.model.Employe;
import com.rh.service.EmployeService;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("********************GESTION DES RH*******************");
		System.out.println("--------------------MENU-----------------------------");
		
		//System.out.println("SVP faites votre choix");
		//System.out.println("SVP faites votre choix");
		 showMenu();
	}
	
	public static void showMenu() 
	{
		int n=0;
		Employe e = new Employe();
		EmployeService empService = new EmployeService();
		
		Scanner sc = new Scanner(System.in);
		//InputStream is = new InputStream();
		
			System.out.println("1.Nouvel Employe");
			System.out.println("2.Liste des Employes");
			System.out.println("3.Afficher Employe");
			System.out.println("4.Supprimer Employe");
			System.out.println("5.Modifier Employe");
		    do {
			       System.out.print("Saisissez le numero de votre choix ici:  ");
			 try {
				 n = sc.nextInt();
				 
			 }catch(InputMismatchException ime) {
				 System.out.println("La valeur saisie doit etre un entier.");
				 
			 }
		 }while(1>n || n>5);
		
		switch(n) {
		case 1:
			empService.AddEmploye(e);
			break;
		case 2:
			empService.listEmploye();
			break;
		case 3:
			empService.showEmploye("");
			break;
		case 4:
			empService.deleteemploye("");
			break;
		case 5:
			empService.updateEmploye("");
			break;
		default:
			System.out.println("Numero par defaut: "+n);
			break;
		}
	}
	
	public static void performAnotherTask() 
	{
		System.out.println("Voulez-vous effectuer une autre action? ");
		System.out.print("O pour Oui - N pour Non : ");
		
		Scanner sc = new Scanner(System.in);
		String response = sc.nextLine();
		if(response.equalsIgnoreCase("o")||response.equalsIgnoreCase("o"))
			showMenu();
		else 
			return;
	}

}
