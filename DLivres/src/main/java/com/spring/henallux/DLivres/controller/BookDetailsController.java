package com.spring.henallux.DLivres.controller;


import com.spring.henallux.DLivres.Model.*;
import com.spring.henallux.DLivres.dataAccess.dao.CategoryDAO;
import com.spring.henallux.DLivres.dataAccess.dao.LanguageTranslationTitleOfBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/bookDetails")
@SessionAttributes({IndexController.CURRENTUSER, IndexController.CART})
public class BookDetailsController {


    private final MessageSource messageSource;
    @Autowired
    private LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO;
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    public BookDetailsController(MessageSource messageSource,LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO,CategoryDAO categoryDAO)
    {
        this.messageSource = messageSource;
        this.languageTranslationTitleOfBookDAO = languageTranslationTitleOfBookDAO;
        this.categoryDAO = categoryDAO;
    }


    @RequestMapping(value = "/{book}", method = RequestMethod.GET)
    public  String displayBookDetails(@PathVariable("book") Integer book_id, Model model, Locale locale)
    {
        LanguageTranslationTitleOfBook titleOfBook = new LanguageTranslationTitleOfBook();
        titleOfBook = languageTranslationTitleOfBookDAO.getTitleOfBookByIsbn(book_id);

        model.addAttribute("booksPromo", languageTranslationTitleOfBookDAO.getTitleOfBookByLanguage(locale.toString()));
        model.addAttribute("connectionForm", new ConnectionForm());
        model.addAttribute("addToCartForm", new AddToCartForm());
        model.addAttribute("book", titleOfBook);

        ArrayList<LanguageTranslationWordingOfCategory> allCategories = new ArrayList<LanguageTranslationWordingOfCategory>(categoryDAO.getAllCategories());
        ArrayList<LanguageTranslationWordingOfCategory> categoriesToDisplay = new ArrayList<LanguageTranslationWordingOfCategory>();

        for (LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory : allCategories)
        {
            if(languageTranslationWordingOfCategory.getCurrentLanguageId().getCurrentLanguageId().equals(locale.toString()))
            {
                categoriesToDisplay.add(languageTranslationWordingOfCategory);
            }
        }
        model.addAttribute("categories", categoriesToDisplay);

        if(!model.containsAttribute("cart"))
        {
            HashMap<String , CommandLine> commandLine = new HashMap<String, CommandLine>();
            model.addAttribute("cart", commandLine);
        }

        return "integrated:bookDetails";
    }


    @RequestMapping(value="/send",method=RequestMethod.POST)
    public String getAddCartFormData (Model model, @ModelAttribute(value="addToCartForm") AddToCartForm form, @ModelAttribute(value="cart") HashMap<Integer, CommandLine> hashMapCommandLine)
    {

        Integer quantity;
        CommandLine lineToAdd = new CommandLine();
        if(hashMapCommandLine.containsKey(form.getIsbn()))
        {
            quantity = hashMapCommandLine.get(form.getIsbn()).getQuantity() + form.getNumberOfBook();
            lineToAdd.setBook(hashMapCommandLine.get(form.getIsbn()).getBook());

        }
        else
        {
            quantity = form.getNumberOfBook();
            lineToAdd.setBook(languageTranslationTitleOfBookDAO.getTitleOfBookByIsbn(form.getIsbn()).getBook_id());

        }


        lineToAdd.setQuantity(quantity);
        hashMapCommandLine.put(form.getIsbn(), lineToAdd);
        model.addAttribute("cart", hashMapCommandLine);


        return "redirect:/bookDetails/"+form.getIsbn();
    }

}
