package com.example.ebankingbackend.dtos;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
public class AccountOperationDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operation;
    private double amount;
    private OperationType type;
    private String description;

}
