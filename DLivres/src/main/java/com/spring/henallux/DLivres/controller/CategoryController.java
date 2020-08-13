package com.spring.henallux.DLivres.controller;


import com.spring.henallux.DLivres.Model.*;
import com.spring.henallux.DLivres.dataAccess.dao.BookDAO;
import com.spring.henallux.DLivres.dataAccess.dao.CategoryDAO;
import com.spring.henallux.DLivres.dataAccess.dao.LanguageTranslationTitleOfBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/category")
@SessionAttributes({IndexController.CURRENTUSER})
public class CategoryController {

    @Autowired
    private LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO = new LanguageTranslationTitleOfBookDAO();
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private BookDAO bookDAO;




    @RequestMapping(value = "/{category}", method= RequestMethod.GET)
    public String displayProductOfCategory (@PathVariable("category") Integer category_id, Model model, Locale locale)
    {


        model.addAttribute("connectionForm", new ConnectionForm());


        ArrayList<LanguageTranslationTitleOfBook> allBooks = new ArrayList<LanguageTranslationTitleOfBook>(languageTranslationTitleOfBookDAO.findByCategory(category_id));
        ArrayList<LanguageTranslationTitleOfBook> booksToDisplay = new ArrayList<>();

        for (LanguageTranslationTitleOfBook languageTranslationTitleOfBook : allBooks)
        {
            if(languageTranslationTitleOfBook.getCurrentLanguageId().getCurrentLanguageId().equals(locale.toString()))
            {
                booksToDisplay.add(languageTranslationTitleOfBook);
            }
        }

        ArrayList<LanguageTranslationWordingOfCategory> allCategories = new ArrayList<LanguageTranslationWordingOfCategory>(categoryDAO.getAllCategories());
        ArrayList<LanguageTranslationWordingOfCategory> categoriesToDisplay = new ArrayList<LanguageTranslationWordingOfCategory>();


        for (LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory : allCategories)
        {
            if(languageTranslationWordingOfCategory.getCurrentLanguageId().getCurrentLanguageId().equals(locale.toString()))
            {
                categoriesToDisplay.add(languageTranslationWordingOfCategory);
            }
        }


        model.addAttribute("books", booksToDisplay);
        model.addAttribute("categories", categoriesToDisplay);

        if(!model.containsAttribute("cart"))
        {
            HashMap<String , CommandLine> commandLine = new HashMap<String, CommandLine>();
            model.addAttribute("cart", commandLine);
        }
        return "integrated:book";
    }

}
