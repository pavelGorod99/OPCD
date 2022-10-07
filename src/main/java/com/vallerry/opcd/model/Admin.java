package com.vallerry.opcd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
}
