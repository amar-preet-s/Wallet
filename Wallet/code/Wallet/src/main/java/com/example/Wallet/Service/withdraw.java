package com.example.Wallet.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Entity.transactions;
import com.example.Wallet.Entity.users;
import com.example.Wallet.Repository.Transaction_Repo;
import com.example.Wallet.Repository.User_repo;

@Service
public class withdraw {
	
	
	@Autowired
	private User_repo urepo;
	
	@Autowired 
	private Transaction_Repo trepo;
	
	public void withdraw_amount(int Acc_no,int Bal,int Amnt) {
	
		if(Amnt>Bal) {
			return;
		}
		
		Optional<users> user = urepo.findById(Acc_no);
		int cur_balance = 0;
		if(user.isPresent()) {
			users u = user.get();
			u.setBalance(u.getBalance()-Amnt);
			cur_balance = u.getBalance();
			urepo.save(u);
		}
		
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dt.format(now);
		DateTimeFormatter tm = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime nt = LocalDateTime.now();
		String time = tm.format(nt);
		
		
		transactions trans = new transactions(Acc_no,date,time,0,Amnt,cur_balance);
		
		trepo.save(trans);
	}
	

}
