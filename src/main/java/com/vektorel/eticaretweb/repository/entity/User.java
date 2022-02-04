package com.vektorel.eticaretweb.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String password;
    String question;
    String answer;
    String email;
    int state;

}
