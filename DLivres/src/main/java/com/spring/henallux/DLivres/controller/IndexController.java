package com.spring.henallux.DLivres.controller;


import com.spring.henallux.DLivres.Model.CommandLine;
import com.spring.henallux.DLivres.Model.ConnectionForm;
import com.spring.henallux.DLivres.Model.Customer;
import com.spring.henallux.DLivres.Model.LanguageTranslationWordingOfCategory;
import com.spring.henallux.DLivres.dataAccess.dao.CategoryDAO;
import com.spring.henallux.DLivres.dataAccess.dao.CurrentLanguageDAO;
import com.spring.henallux.DLivres.dataAccess.dao.CustomerDAO;
import com.spring.henallux.DLivres.dataAccess.dao.LanguageTranslationTitleOfBookDAO;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/index")
@SessionAttributes({IndexController.CURRENTUSER, IndexController.CART})
public class IndexController {

    protected static final String CURRENTUSER = "currentUser";

    protected static final String CART = "cart";

    @Autowired
    private CustomerDAO customerDAO = new CustomerDAO();
    @Autowired
    private CategoryDAO categoryDAO = new CategoryDAO();
    @Autowired
    private LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO = new LanguageTranslationTitleOfBookDAO();
    @Autowired
    private ProviderConverter providerConverter;
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CurrentLanguageDAO currentLanguageDAO;

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, Locale locale)
    {


        model.addAttribute(languageTranslationTitleOfBookDAO.getTitleOfBookByLanguage(locale.toString()));

        String langue;
        model.addAttribute("connectionForm", new ConnectionForm());
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

        if(!model.containsAttribute("cart"))
        {
            HashMap<String , CommandLine> commandLine = new HashMap<String, CommandLine>();
            model.addAttribute(CART, commandLine);
        }


        return "integrated:index";
    }

    @RequestMapping(value="/LogIn",method=RequestMethod.POST)
    public String attemptLogIn (Model model,  @ModelAttribute(value="connectionForm") ConnectionForm formConnection, Locale locale) {


        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            Customer user = customerDAO.getCustomerByUserName(formConnection.getUserName());
            if (encoder.matches(formConnection.getPassword(), user.getPassword()))

            {
                model.addAttribute(CURRENTUSER, user);
                return "redirect:/index";
            }
            else{
                throw new Exception();

            }



        }
        catch (Exception e)
        {
            model.addAttribute("errorMessage", e.getMessage());

            model.addAttribute("errorLogin",true);
            model.addAttribute("connectionForm", new ConnectionForm());
            model.addAttribute("MessageToDisplay", messageSource.getMessage("title",null,locale));
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
                HashMap<String , CommandLine> commandLine = new HashMap<>();
                model.addAttribute(CART, commandLine);
            }

            return "integrated:index";
        }
    }

    @RequestMapping(value="/logOut", method=RequestMethod.GET)
    public String disconnect(Model model, SessionStatus status){
        status.setComplete();
        return "redirect:/index";
    }
}
