package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.repository.CategoryRepository;
import com.vektorel.eticaretweb.repository.ICategoryProductRepository;
import com.vektorel.eticaretweb.repository.IProductRepository;
import com.vektorel.eticaretweb.repository.entity.Category;
import com.vektorel.eticaretweb.repository.entity.CategoryProduct;
import com.vektorel.eticaretweb.repository.entity.Product;
import com.vektorel.eticaretweb.viewmodel.CategoryTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    @Autowired
    ICategoryProductRepository iCategoryProductRepository;

    @Autowired
    IProductRepository productRepository;

    public void save(Category category){
        repository.save(category);
    }
    public void update(Category category){
        repository.save(category);
    }
    public void delete(long id){
        Category category = repository.getOne(id);
        repository.delete(category);
    }
    public List<Category> findAll(){
       return   repository.findAll();
    }
    public  List<Category>  findByParentId(long id){
        return repository.findByParentid(id);
    }
    public  List<Category>  findByParents(){
        return repository.findByParentid(0);
    }

    public List<CategoryTab> categoryTabList(){
        List<CategoryTab> list = new ArrayList<>();
        for (Category item: repository.findByParentid(0)) {
            CategoryTab categoryTab = new CategoryTab();
            categoryTab.setAd(item.getAd().replace("ş","s"));
            categoryTab.setListe(findByCategoryId(item.getId()));
            list.add(categoryTab);
        }
        return list;
    }

    public List<Product> findByCategoryId(long categoryid){
        List<Product> list = new ArrayList<>();
        for (CategoryProduct item:iCategoryProductRepository.findTop4ByCategoryid(categoryid)  ) {
            list.add(
                    productRepository.getOne(item.getProductid())
            );
        }
        return list;
    }

}
