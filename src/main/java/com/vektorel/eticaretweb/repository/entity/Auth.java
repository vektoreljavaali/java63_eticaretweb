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
@Entity
@Table(name = "tblauth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long userid;
    /**
     * 0- Müşteri
     * 1- Personel
     * 2- İnsan Kaynakları
     * 3- Muhasebe
     * 99- Admin
     */
    int yetki;
}
