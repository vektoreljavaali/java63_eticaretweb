package com.vektorel.eticaretweb.mvccontroller;

import com.vektorel.eticaretweb.repository.entity.Campaingns;
import com.vektorel.eticaretweb.service.CampaignsService;
import com.vektorel.eticaretweb.service.CategoryService;
import com.vektorel.eticaretweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class Homecontroller {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    CampaignsService campaignsService;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView();
        model.addObject("categorylist",
                categoryService.findByParentId(0));
        List<Campaingns> kampanyalistesi = campaignsService.findAllActive();
        model.addObject("kampanyalistesi", kampanyalistesi);
        model.addObject("urunlistesi",productService.findAll());
        model.addObject("populerkategoriler",categoryService.categoryTabList());
        model.setViewName("index");
        return model;
    }


}
