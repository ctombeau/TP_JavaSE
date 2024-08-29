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
import java.util.ArrayList;
import java.util.List;

import com.rh.Main;
import com.rh.model.Employe;

public class DigicelDb {
    
	public void saveData(String chemin, Object obj) {
		
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
		List<String> empAsString = new ArrayList<String>();
		String line ="";
		Employe emp = null;
		try(FileReader fileIn = new FileReader(chemin);
				BufferedReader br = new BufferedReader(fileIn);) {
            while((line = br.readLine())!=null) {
            	String [] empLine = line.split(";");
            	System.out.println("id		:"+empLine[0]);
            	System.out.println("Nom		:"+empLine[1]);
            	System.out.println("Prenom 	:"+empLine[2]);
            	System.out.println("Sexe 	:"+empLine[3]);
            	System.out.println("Date Naissance  :"+empLine[4]);
            	System.out.println("___________________________________________________");
            	empAsString.add(line);
            }
            //System.out.println(empAsString);
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } 
		Main.performAnotherTask();
    }
	
	public void getEmploye(String chemin, String code) {
		String str;
		int  nbreLine=0;
		try(FileReader fr = new FileReader(chemin);
			BufferedReader br = new BufferedReader(fr);) {
			while(( str = br.readLine()) != null)
		    {
		        nbreLine++;  
		        if(nbreLine==Integer.parseInt(code)) {
		        	String [] empLine = str.split(";");
	            	System.out.println("id		:"+empLine[0]);
	            	System.out.println("Nom		:"+empLine[1]);
	            	System.out.println("Prenom 	:"+empLine[2]);
	            	System.out.println("Sexe 	:"+empLine[3]);
	            	System.out.println("Date Naissance  :"+empLine[4]);
	            	break;
		        }
		    }
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Main.performAnotherTask();
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
