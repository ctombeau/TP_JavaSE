package com.rh.service;

import com.rh.model.Client;
import com.rh.model.Employe;

public class PersonneService {
   
	public <T> double recharge(T obj) {
		if(obj instanceof Employe e) {
			
		}
		else if(obj instanceof Client c) {
			
		}
		return 0;
	}
	
	public void rechargeWithMoney(double montant) {
		
	}
}
