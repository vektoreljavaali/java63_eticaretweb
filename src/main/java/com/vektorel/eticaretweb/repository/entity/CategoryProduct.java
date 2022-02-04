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
@Table(name = "tblcategoryproduct")
@Entity
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long categoryid;
    long productid;

}
