package com.example.Wallet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Entity.users;
import com.example.Wallet.Repository.User_repo;

@Service
public class add_user {
	
	@Autowired
	private User_repo urepo;
	
	public boolean add(int A_no,String pass) {
		urepo.save(new users(A_no,pass,0));
		return true;
	}

}
