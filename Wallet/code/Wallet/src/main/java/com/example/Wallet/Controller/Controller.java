package com.example.Wallet.Controller;

import java.util.Random;

import com.example.Wallet.Entity.transactions;
import com.example.Wallet.Entity.users;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Wallet.Service.add_user;
import com.example.Wallet.Service.check_user;
import com.example.Wallet.Service.deposit;
import com.example.Wallet.Service.get_bal;
import com.example.Wallet.Service.get_transaction;
import com.example.Wallet.Service.withdraw;
import netscape.javascript.JSObject;

@RestController
public class Controller {
	
	@Autowired
	private check_user chk;
	
	@Autowired
	private get_bal balance;
	
	@Autowired
	private add_user add;
	
	@Autowired
	private withdraw with;
	
	@Autowired
	private get_transaction trans;
	
	@Autowired
	private deposit dp;
	
	private boolean New_Acc = false;
	@RequestMapping("/")
	@ResponseBody
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@PostMapping("/Main")
	public ModelAndView Main(@RequestParam("Account-number") int acc,@RequestParam("password") String pass){
		
		ModelAndView model = new ModelAndView("login");
		if(!New_Acc) {
			if(chk.check(acc, pass)) {
				model = new ModelAndView("main");
				int bal = balance.bal(acc);
				List<transactions> list = trans.get_transac(acc);
				model.addObject("Balance",bal);
				model.addObject("Account_No",acc);
				model.addObject("Transactions",list);
			}
		}else {
			add.add(acc, pass);
			model = new ModelAndView("main");
			int bal = balance.bal(acc);
			List<transactions> list = trans.get_transac(acc);
			System.out.println(list.size());
			model.addObject("Balance",bal);
			model.addObject("Account_No",acc);
			model.addObject("Transactions",list);
			New_Acc = false;
		}
		return model;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public ModelAndView create() {
		ModelAndView model = new ModelAndView("create");
		Random rd = new Random();
		int temp_Acc = 100000 + rd.nextInt(1000000);
		//check if present
		New_Acc = true;
		model.addObject("Account",temp_Acc);
		return model;
	}
	
	@PostMapping("/Deposit")
	public ModelAndView Add(@RequestParam("Account-number") int acc,@RequestParam("Balance") int balnce,@RequestParam("Amount") int Amnt){
		dp.deposit(acc, balnce, Amnt);
		ModelAndView model = new ModelAndView("main");
		List<transactions> list = trans.get_transac(acc);
		int bal = balance.bal(acc);
		model.addObject("Balance",bal);
		model.addObject("Account_No",acc);
		model.addObject("Transactions",list);
		return model;
	}
	
	@PostMapping("/Withdraw")
	public ModelAndView draw(@RequestParam("Account-number") int acc,@RequestParam("Balance") int balnce,@RequestParam("Amount") int Amnt){
		with.withdraw_amount(acc, balnce, Amnt);
		ModelAndView model = new ModelAndView("main");
		List<transactions> list = trans.get_transac(acc);
		int bal = balance.bal(acc);
		model.addObject("Balance",bal);
		model.addObject("Account_No",acc);
		model.addObject("Transactions",list);
		return model;
	}

}
