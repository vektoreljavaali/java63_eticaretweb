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
@Table(name = "tblcampaigns")
public class Campaingns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String anabaslik;
    String altbaslik;
    String aciklama;
    String buttontext;
    String buttonlink;
    String anaresimurl;
    String fiyaturl;
    long start;
    long finish;
    int state;
}
