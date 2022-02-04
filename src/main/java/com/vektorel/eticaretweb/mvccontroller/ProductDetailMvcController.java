package com.vektorel.eticaretweb.mvccontroller;

import com.vektorel.eticaretweb.repository.entity.Product;
import com.vektorel.eticaretweb.service.ProductImagesService;
import com.vektorel.eticaretweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductDetailMvcController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductImagesService productImagesService;

    @GetMapping("/urundetay/{id}")
    public Object urundetay(@PathVariable long id){
        ModelAndView model = new ModelAndView();
        model.setViewName("urundetay");
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            model.addObject("urun",product.get());
            model.addObject("resimler",
                    productImagesService.findByProductid(product.get().getId()));
        }else
            return "redirect:/notfoundproduct";

        return model;
    }
}
