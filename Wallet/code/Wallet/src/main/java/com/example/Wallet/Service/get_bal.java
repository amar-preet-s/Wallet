package com.example.Wallet.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Entity.users;
import com.example.Wallet.Repository.User_repo;

@Service
public class get_bal {

	@Autowired
	private User_repo urepo;
	
	public int bal(int A_no) {
		// TODO Auto-generated constructor stub
		
		Optional<users> A_user = urepo.findById(A_no);
		if(A_user.isPresent()) {
			users a = A_user.get();
			return a.getBalance();
			
		}
		
		return -1;	
	}

}
