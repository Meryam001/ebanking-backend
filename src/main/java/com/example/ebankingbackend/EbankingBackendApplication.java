package com.example.ebankingbackend;

import com.example.ebankingbackend.dtos.BankAccountDTO;
import com.example.ebankingbackend.dtos.CurrentBankAccountDTO;
import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.dtos.SavingBankAccountDTO;
import com.example.ebankingbackend.entities.*;
import com.example.ebankingbackend.enums.AccountStatus;
import com.example.ebankingbackend.enums.OperationType;
import com.example.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.example.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;
import com.example.ebankingbackend.reposotitories.AccountOperationRepository;
import com.example.ebankingbackend.reposotitories.BankAccountRepository;
import com.example.ebankingbackend.reposotitories.CustomerRepository;
import com.example.ebankingbackend.services.BankAccountService;
import com.example.ebankingbackend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(EbankingBackendApplication.class, args);
    }
    @Bean

    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
                  Stream.of("Hassan","Imane","Mohammed").forEach(name->{
                      CustomerDTO customer=new CustomerDTO();
                      customer.setName(name);
                      customer.setEmail(name+"@gmail.com");
                      bankAccountService.saveCustomer(customer);
                  });
                  bankAccountService.listCustomer().forEach(customer->{
                      try {
                          bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
                          bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5, customer.getId());


                      } catch (CustomerNotFoundException e) {
                          e.printStackTrace();
                      }


                  });


        };
    }
    //@Bean
    CommandLineRunner star(CustomerRepository customerRepository,
                           BankAccountRepository bankAccountRepository,
                           AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Hassan","Yassine","AICHA").forEach(name->{
                Customer customer=new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);

            });
            customerRepository.findAll().forEach(cust->{
                CurrentAccount currentAccount=new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreatedAT(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount=new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreatedAT(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);

            });
            bankAccountRepository.findAll().forEach(acc->{
                for (int i=0;i<10;i++){
                    AccountOperation accountOperation=new AccountOperation();
                    accountOperation.setOperation(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }

            });
        };
    }

}
