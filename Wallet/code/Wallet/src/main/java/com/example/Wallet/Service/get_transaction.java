package com.example.Wallet.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Entity.transactions;
import com.example.Wallet.Repository.Transaction_Repo;

@Service
public class get_transaction {

	@Autowired
	private Transaction_Repo trepo;
	
	public List<transactions> get_transac(int Acc){
		List<transactions> trans = new ArrayList<>();
		List<transactions> list = trepo.findAll();
		
		for(transactions t:list) {
			if(t.getA_No() == Acc) {
				trans.add(t);
			}
		}
		
		Collections.reverse(trans);
		return trans;
	}
	

}
