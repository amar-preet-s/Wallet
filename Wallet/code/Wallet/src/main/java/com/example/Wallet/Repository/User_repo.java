package com.example.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Wallet.Entity.users;

@Repository
public interface User_repo extends JpaRepository<users,Integer>{

}
