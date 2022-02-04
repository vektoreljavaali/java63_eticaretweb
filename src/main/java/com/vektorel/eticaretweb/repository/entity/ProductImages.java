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
@Table(name = "tblproductiamges")
@Entity
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long urunid;
    String url;

}
