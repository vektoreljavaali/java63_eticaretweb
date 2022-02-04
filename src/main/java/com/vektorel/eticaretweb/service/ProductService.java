package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.repository.IProductRepository;
import com.vektorel.eticaretweb.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    IProductRepository repository;


    public void save(Product item){
        repository.save(item);
    }
    public void update(Product item){
        repository.save(item);
    }
    public void delete(long id){
        Product item = repository.getOne(id);
        repository.delete(item);
    }
    public List<Product> findAll(){
        return repository.findAll();
    }
    public Optional<Product> findById(long id){
        return repository.findById(id);
    }

}
