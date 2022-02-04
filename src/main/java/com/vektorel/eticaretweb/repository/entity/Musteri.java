package com.vektorel.eticaretweb.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblmusteri")
@Entity
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String ad;
    String soyad;
    String adres;


}
