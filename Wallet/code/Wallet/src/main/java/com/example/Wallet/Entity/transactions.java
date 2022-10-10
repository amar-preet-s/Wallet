package com.example.Wallet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class transactions {
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int s_no;
	
	@Column(name="Account_No")
	private int A_No;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="Time")
	private String time;
	
	@Column(name="Credit")
	private int credit;
	
	@Column(name="Debit")
	private int debit;
	
	@Column(name="Curr_Bal")
	private int Avail_balance;

	public transactions() {
		super();
	}

	public transactions(int a_No, String date, String time, int credit, int debit, int avail_balance) {
		this.A_No = a_No;
		this.date = date;
		this.time = time;
		this.credit = credit;
		this.debit = debit;
		this.Avail_balance = avail_balance;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public int getA_No() {
		return A_No;
	}

	public void setA_No(int a_No) {
		A_No = a_No;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public int getAvail_balance() {
		return Avail_balance;
	}

	public void setAvail_balance(int avail_balance) {
		Avail_balance = avail_balance;
	}

}
