package com.example.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Wallet.Entity.transactions;

@Repository
public interface Transaction_Repo extends JpaRepository<transactions,Integer>{

}
