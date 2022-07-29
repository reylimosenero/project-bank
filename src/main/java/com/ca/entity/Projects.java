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
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Projects {//should be project singular
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clientName;
    private String projectName;

    private String uom;
    private double quantity;
    private String status;

    @JsonFormat(pattern="MM-dd-yyyy")
    private LocalDate dateInquiry;

    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private LocalDateTime dateTimeStarted;
    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private LocalDateTime dateTimeDelivered;

}
