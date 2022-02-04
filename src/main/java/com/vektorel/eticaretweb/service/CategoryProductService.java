package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.repository.ICategoryProductRepository;
import com.vektorel.eticaretweb.repository.IProductRepository;
import com.vektorel.eticaretweb.repository.entity.CategoryProduct;
import com.vektorel.eticaretweb.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryProductService {

    @Autowired
    ICategoryProductRepository repository;

    @Autowired
    IProductRepository productRepository;

    public void save(CategoryProduct item){
        repository.save(item);
    }

    public List<Product> findByCategoryId(long categoryid){
        List<Product> list = new ArrayList<>();
        for (CategoryProduct item:repository.findByCategoryid(categoryid)  ) {
            list.add(
                    productRepository.getOne(item.getProductid())
            );
        }
        return list;
    }
}
