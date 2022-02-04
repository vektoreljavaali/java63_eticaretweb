package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
