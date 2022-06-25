package com.example.ebankingbackend.reposotitories;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
