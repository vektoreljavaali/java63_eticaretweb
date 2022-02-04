package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.repository.CampaignsRepository;
import com.vektorel.eticaretweb.repository.entity.Campaingns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CampaignsService {

    @Autowired
    CampaignsRepository repository;

    public void save(Campaingns campaingns){
        repository.save(campaingns);
    }
    public void update(Campaingns campaingns){
        repository.save(campaingns);
    }
    public void delete(Campaingns campaingns){
        repository.delete(campaingns);
    }
    public List<Campaingns> findAll(){
        return repository.findAll();
    }
    public List<Campaingns> findAllActive(){
        long time =  new Date().getTime();
        List<Campaingns> list = repository.findAll();
        return repository
                .findByFinishGreaterThanAndStartLessThan(time,time);


    }



}
