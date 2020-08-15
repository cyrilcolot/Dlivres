package com.spring.henallux.DLivres.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value = "/orderCompleted")
@SessionAttributes({IndexController.CURRENTUSER,IndexController.CART})
public class OrderCompletedController {
    @RequestMapping(method = RequestMethod.GET)
    public String orderCompleted(Model model, Locale locale)
    {
        return "integrated:orderCompleted";
    }

}
