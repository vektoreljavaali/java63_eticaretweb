package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.repository.IAuthRepository;
import com.vektorel.eticaretweb.repository.entity.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    IAuthRepository iAuthRepository;

    public void save(Auth auth){
        iAuthRepository.save(auth);
    }
    public void update(Auth auth){
        iAuthRepository.save(auth);
    }
    public void delete(Auth auth){
        iAuthRepository.delete(auth);
    }
    public List<Auth> finfAll(){
        return iAuthRepository.findAll();
    }
    public int getYetki(long userid){
        Optional<Auth> auth = iAuthRepository.findByUserid(userid);
        if(auth.isPresent())
            return auth.get().getYetki();
        return -1;
    }

}
