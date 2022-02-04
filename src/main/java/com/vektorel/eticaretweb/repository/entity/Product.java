package com.vektorel.eticaretweb.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tblproduct")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String ad;
    double fiyat;
    String onecikanresim;
    int state;
    @Column(length = 5000)
    String aciklama; // html bilgisi girilebilir.
    int miktar;
    int kdv;
    double indirimlifiyat;


}
