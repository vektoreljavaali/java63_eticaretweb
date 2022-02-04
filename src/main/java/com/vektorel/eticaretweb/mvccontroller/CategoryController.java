package com.vektorel.eticaretweb.mvccontroller;

import com.vektorel.eticaretweb.repository.entity.Category;
import com.vektorel.eticaretweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @GetMapping("/kategori")
    public ModelAndView kategori(){
        ModelAndView model = new ModelAndView();
        model.addObject("parentkategoriler",categoryService.findByParents());
        model.addObject("kategoriler",categoryService.findAll());
        model.setViewName("admin/kategoriler");
        return model;
    }

    @PostMapping("/kategorisave")
    public String savekategori(long id,String ad, long parent, MultipartFile img_kategori){
        try {
            if(id==0){
                String filename = UUID.randomUUID().toString();
                File file = new File("C:\\inetpub\\wwwroot\\img\\"+filename+".png");
                img_kategori.transferTo(file);
                categoryService.save(
                        Category.builder()
                                .ad(ad)
                                .parentid(parent)
                                .image("http://localhost/img/"+filename+".png")
                                .build()
                );
            }else{
                String filename = UUID.randomUUID().toString();
                File file = new File("C:\\inetpub\\wwwroot\\img\\"+filename+".png");
                img_kategori.transferTo(file);
                categoryService.save(
                        Category.builder()
                                .id(id)
                                .ad(ad)
                                .parentid(parent)
                                .image("http://localhost/img/"+filename+".png")
                                .build()
                );
            }


        }catch (Exception exception){
            System.out.println("Hataaaaaa oldu...: "+ exception.toString());
        }
        return "redirect:/admin/kategori";
    }

    @PostMapping("/deletekategori")
    public String deletekategori(long id){
        categoryService.delete(id);
        return "redirect:/admin/kategori";
    }
}
