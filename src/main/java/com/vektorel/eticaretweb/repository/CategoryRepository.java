package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findByParentid(long id);
}
