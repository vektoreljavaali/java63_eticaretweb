package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryProductRepository extends JpaRepository<CategoryProduct,Long> {

    // categoryid
    // findByCategoryid
    // categoryId
    // findByCategoryId
    List<CategoryProduct> findByCategoryid(long id);

    // ilk 4 ürünü getir.
    List<CategoryProduct> findTop4ByCategoryid(long id);
}
