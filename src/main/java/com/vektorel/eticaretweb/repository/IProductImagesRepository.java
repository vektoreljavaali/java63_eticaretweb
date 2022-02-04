package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductImagesRepository extends JpaRepository<ProductImages,Long> {

    List<ProductImages> findByUrunid(long urunid);
}
