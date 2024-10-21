package com.example.batch_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@AllArgsConstructor
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "dob", nullable = false)
    private String dob;

    public Customer() {
    }
}
