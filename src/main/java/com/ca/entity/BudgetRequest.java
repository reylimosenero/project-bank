package com.ca.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BudgetRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clientName;
    private String projectName;
    private String requestType;
    private String supplierName;
    private String bankDetails;
    private String wallet;
    private double totAmount;
    @JsonFormat(pattern="MM-dd-yyyy")
    private LocalDate requestDate;
    private double downPayment;
    @JsonFormat(pattern="MM-dd-yyyy")
    private LocalDate dpDate;
    private double balance;
    @JsonFormat(pattern="MM-dd-yyyy")
    private LocalDate paidDate;
    private String status;


}
