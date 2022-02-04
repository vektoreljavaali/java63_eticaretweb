package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.Campaingns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignsRepository extends JpaRepository<Campaingns,Long> {
    //  19:00    <  19:43
    // Başlangıç < Şuandan
    //  21:00 > 19:43
    // Bitiş > Şuandan
    List<Campaingns> findByFinishGreaterThanAndStartLessThan(long currentStartTime,long currentEndTime);
}
