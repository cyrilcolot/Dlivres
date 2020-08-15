package com.spring.henallux.DLivres.controller;

import com.spring.henallux.DLivres.Model.*;
import com.spring.henallux.DLivres.Service.OrderCustomerService;
import com.spring.henallux.DLivres.dataAccess.dao.CategoryDAO;
import com.spring.henallux.DLivres.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.DLivres.dataAccess.dao.LanguageTranslationTitleOfBookDAO;
import com.spring.henallux.DLivres.dataAccess.dao.OrderCustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({IndexController.CURRENTUSER,IndexController.CART})

public class CartController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CategoryDAO categoryDAO = new CategoryDAO();
    @Autowired
    private LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO = new LanguageTranslationTitleOfBookDAO();
    @Autowired
    private CommandLineDAO commandLineDAO = new CommandLineDAO();
    @Autowired
    private OrderCustomerDAO orderCustomerDAO = new OrderCustomerDAO();
    @Autowired
    private OrderCustomerService orderCustomerService = new OrderCustomerService();


    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, Locale locale, @ModelAttribute(value="cart") HashMap<Integer, CommandLine> hashMapCart)
    {

        double totalPrice;

        totalPrice = orderCustomerService.getTotalOrder(hashMapCart);
        model.addAttribute("totalPrice", totalPrice);



        ArrayList<LanguageTranslationWordingOfCategory> allCategories = new ArrayList<LanguageTranslationWordingOfCategory>(categoryDAO.getAllCategories());
        ArrayList<LanguageTranslationWordingOfCategory> categoriesToDisplay = new ArrayList<LanguageTranslationWordingOfCategory>();
        model.addAttribute("connectionForm", new ConnectionForm());

        //afficher les catégorie
        for (LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory : allCategories)
        {
            if(languageTranslationWordingOfCategory.getCurrentLanguageId().getCurrentLanguageId().equals(locale.toString()))
            {
                categoriesToDisplay.add(languageTranslationWordingOfCategory);
            }
        }


        model.addAttribute("categories", categoriesToDisplay);
        model.addAttribute("books", languageTranslationTitleOfBookDAO.getTitleOfBookByLanguage(locale.toString()));

        //si panier existe si pas ajouter modele
        if(!model.containsAttribute("cart"))
        {
            HashMap<String , CommandLine> commandLine = new HashMap<String, CommandLine>();
            model.addAttribute("cart", commandLine);
        }

        return "integrated:cart";
    }


    @RequestMapping(value = "/delete/{bookId}", method=RequestMethod.GET)
    public String displayProductOfCategory (@PathVariable("bookId") Integer bookId, Model model, @ModelAttribute(value="cart") HashMap<Integer, CommandLine> hashMapCart)
    {
        hashMapCart.remove(bookId);
        return "redirect:/cart";
    }

    @RequestMapping(value="/send",method=RequestMethod.GET)
    public String confirmCommand (Model model, @ModelAttribute(value="cart") HashMap<Integer, CommandLine> hashMapCart, @ModelAttribute(value="currentUser") Customer customer)
    {
        OrderCustomer order = new OrderCustomer();
        order.setCustomer_id(customer);
        order.setOrderCustomerDate(new Date());

        order = orderCustomerDAO.addOrderCustomer(order);
        for (HashMap.Entry<Integer, CommandLine> commandLine : hashMapCart.entrySet()) {
            commandLine.getValue().setOrderCustomer(order);
            commandLineDAO.addCommandeLine(commandLine.getValue());
        }
        hashMapCart.clear();
        return "redirect:/index";
    }
    @RequestMapping(value="/confirm", method=RequestMethod.GET)
    public String confirm (Model model, Locale locale)
    {
        model.addAttribute("booksPromo", languageTranslationTitleOfBookDAO.getTitleOfBookByLanguage(locale.toString()));
        ArrayList<LanguageTranslationWordingOfCategory> allCategories = new ArrayList<LanguageTranslationWordingOfCategory>(categoryDAO.getAllCategories());
        ArrayList<LanguageTranslationWordingOfCategory> categoriesToDisplay = new ArrayList<LanguageTranslationWordingOfCategory>();
        model.addAttribute("connectionForm", new ConnectionForm());
        model.addAttribute("MessageToDisplay", messageSource.getMessage("titleCart",null,locale));


        for (LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory : allCategories)
        {
            if(languageTranslationWordingOfCategory.getCurrentLanguageId().getCurrentLanguageId().equals(locale.toString()))
            {
                categoriesToDisplay.add(languageTranslationWordingOfCategory);
            }
        }
        model.addAttribute("categories", categoriesToDisplay);
        model.addAttribute("books", languageTranslationTitleOfBookDAO.getTitleOfBookByLanguage(locale.toString()));

        if(!model.containsAttribute("cart"))
        {
            HashMap<String , CommandLine> commandLine = new HashMap<>();
            model.addAttribute("cart", commandLine);
        }

        return "integrated:confirmCommand";
    }

}
