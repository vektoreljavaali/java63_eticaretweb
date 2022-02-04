package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.repository.IProductImagesRepository;
import com.vektorel.eticaretweb.repository.entity.ProductImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImagesService {

    @Autowired
    IProductImagesRepository repository;

    public void save(ProductImages item){
        repository.save(item);
    }
    public List<ProductImages> findByProductid(long urunid)
    {
        return repository.findByUrunid(urunid);
    }

}
