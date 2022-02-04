package com.vektorel.eticaretweb.mvccontroller;

import com.vektorel.eticaretweb.repository.entity.Product;
import com.vektorel.eticaretweb.repository.entity.ProductImages;
import com.vektorel.eticaretweb.service.CategoryService;
import com.vektorel.eticaretweb.service.ProductImagesService;
import com.vektorel.eticaretweb.service.ProductService;
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
public class ProductMvcController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductImagesService productImagesService;

    @GetMapping("/urunekleme")
    public ModelAndView urunekleme(){
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/urunekleme");
        model.addObject("kategoriler",categoryService.findAll());
        model.addObject("urunlistesi",productService.findAll());
        return model;
    }

    @PostMapping("/urunekle")
    public String urunekle(String ad, double fiyat, double indirimlifiyat,
                           String aciklama, MultipartFile resim_1,MultipartFile resim_2
                           ,MultipartFile resim_3,MultipartFile resim_4,
                           MultipartFile resim_5){
        try {
            // İki adımda gerçekleşecek.
            // 1. Ürün kayıt edilecek,
            String filename = UUID.randomUUID().toString();
            File file = new File("src\\main\\resources\\public\\productimages\\"+filename+".png");
            resim_1.transferTo(file);
            Product product =   Product.builder()
                    .ad(ad)
                    .fiyat(fiyat)
                    .indirimlifiyat(indirimlifiyat)
                    .aciklama(aciklama)
                    .onecikanresim("/"+filename+".png")
                    .build();
            productService.save(product);
           // Ürün kayıt edildikten sonra ürünün id olşur.
            // 2. olarakta ürüne ait resimler kayıt edilir ve db ye yazılır.
            filename = UUID.randomUUID().toString();
            file = new File("src\\main\\resources\\public\\productimages\\"+filename+".png");
            resim_2.transferTo(file);
            productImagesService.save(
                    ProductImages.builder()
                            .urunid(product.getId())
                            .url("/"+filename+".png")
                            .build()
            );
            filename = UUID.randomUUID().toString();
            file = new File("src\\main\\resources\\public\\productimages\\"+filename+".png");
            resim_3.transferTo(file);
            productImagesService.save(
                    ProductImages.builder()
                            .urunid(product.getId())
                            .url("/"+filename+".png")
                            .build()
            );
            filename = UUID.randomUUID().toString();
            file = new File("src\\main\\resources\\public\\productimages\\"+filename+".png");
            resim_4.transferTo(file);
            productImagesService.save(
                    ProductImages.builder()
                            .urunid(product.getId())
                            .url("/"+filename+".png")
                            .build()
            );
            filename = UUID.randomUUID().toString();
            file = new File("src\\main\\resources\\public\\productimages\\"+filename+".png");
            resim_5.transferTo(file);
            productImagesService.save(
                    ProductImages.builder()
                            .urunid(product.getId())
                            .url("/"+filename+".png")
                            .build()
            );
        }catch (Exception exception){
            System.out.println("Hata.. ProductMvcController(40)..: "+ exception.toString());
        }
        return "redirect:/admin/urunekleme";
    }

}
