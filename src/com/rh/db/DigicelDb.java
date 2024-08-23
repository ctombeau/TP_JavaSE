package com.rh.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.rh.Main;
import com.rh.model.Employe;

public class DigicelDb {
    
	public void saveData(String chemin, Object obj) {
		//Path path = Paths.get(chemin);
		
		int nbreLine = countLine(chemin)+1;
		String str;
		try(FileWriter fileOut = new FileWriter(chemin,true);
				BufferedWriter out = new BufferedWriter(fileOut);
				) {
			
            out.write(nbreLine+";"+obj.toString());
            out.newLine();
            System.out.println("Serialized data is saved in "+chemin);
           
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		Main.performAnotherTask();
	}
	
	public void getData(String chemin) {
		Employe emp = null;
		try {
            FileInputStream fileIn = new FileInputStream(chemin);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employe) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + emp.getNom());
        System.out.println("Prenom: " + emp.getPrenom());
        System.out.println("Sexe: " + emp.getSexe());
        System.out.println("Date Naissance: " + emp.getDateNaissance());
    }
	
	public int countLine(String chemin) {
		String str;
		int  nbreLine=0;
		try(FileReader fr = new FileReader(chemin);
			BufferedReader br = new BufferedReader(fr);) {
			while(( str = br.readLine()) != null)
		    {
		        nbreLine++;                  
		    }
			return nbreLine;
		}
		catch(IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
