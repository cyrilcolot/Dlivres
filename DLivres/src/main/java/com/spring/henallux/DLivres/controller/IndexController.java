package com.spring.henallux.DLivres.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/index")

public class IndexController {

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model)
    {
        return "integrated:index";
    }
}
