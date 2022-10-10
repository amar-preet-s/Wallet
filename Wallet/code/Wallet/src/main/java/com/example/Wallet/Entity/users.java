package com.example.Wallet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class users {
	@Column(name="Account_No")
	@Id
	private int A_No;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Balance")
	private int balance;
	public users() {
		super();
	}
	public users(int a_No, String password, int balance) {
		super();
		A_No = a_No;
		this.password = password;
		this.balance = balance;
	}
	public int getA_No() {
		return A_No;
	}
	public void setA_No(int a_No) {
		A_No = a_No;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
