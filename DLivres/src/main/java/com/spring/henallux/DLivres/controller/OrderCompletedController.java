package com.spring.henallux.DLivres.controller;


import com.spring.henallux.DLivres.Model.LanguageTranslationWordingOfCategory;
import com.spring.henallux.DLivres.dataAccess.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value = "/orderCompleted")
@SessionAttributes({IndexController.CURRENTUSER,IndexController.CART})
public class OrderCompletedController {
    @Autowired
    private CategoryDAO categoryDAO = new CategoryDAO();
    @RequestMapping(method = RequestMethod.GET)
    public String orderCompleted(Model model, Locale locale)
    {

        ArrayList<LanguageTranslationWordingOfCategory> allCategories = new ArrayList<>(categoryDAO.getAllCategories());
        ArrayList<LanguageTranslationWordingOfCategory> categoriesToDisplay = new ArrayList<LanguageTranslationWordingOfCategory>();


        for (LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory : allCategories)
        {
            if(languageTranslationWordingOfCategory.getCurrentLanguageId().getCurrentLanguageId().equals(locale.toString()))
            {
                categoriesToDisplay.add(languageTranslationWordingOfCategory);
            }
        }
        model.addAttribute("categories", categoriesToDisplay);
        return "integrated:orderCompleted";
    }

}
