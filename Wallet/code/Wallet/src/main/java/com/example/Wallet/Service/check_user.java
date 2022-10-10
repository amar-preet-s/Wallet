package com.example.Wallet.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Entity.users;
import com.example.Wallet.Repository.User_repo;



@Service
public class check_user {

	@Autowired
	private User_repo urepo;
	
	public boolean check(int A_no,String pass) {
		// TODO Auto-generated constructor stub
		
		Optional<users> A_user = urepo.findById(A_no);
		if(A_user.isPresent()) {
			users a = A_user.get();
			if(a.getPassword().equals(pass)) {
				return true;
			}
			
		}
		
		return false;	
	}

}
