package com.vektorel.eticaretweb.mvccontroller;

import com.vektorel.eticaretweb.repository.entity.User;
import com.vektorel.eticaretweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping("/index/{id}")
    public Object index(@PathVariable long id){
        ModelAndView model = new ModelAndView();
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            model.addObject("user",user.get());
            model.setViewName("/users/index");
            return model;
        }else{
            model.setViewName("/login");
            return model;
        }

    }
}
