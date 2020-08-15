package com.spring.henallux.DLivres.controller;


import com.spring.henallux.DLivres.Model.*;
import com.spring.henallux.DLivres.dataAccess.dao.CategoryDAO;
import com.spring.henallux.DLivres.dataAccess.dao.CustomerDAO;
import com.spring.henallux.DLivres.dataAccess.dao.LanguageTranslationTitleOfBookDAO;
import com.spring.henallux.DLivres.dataAccess.entity.CustomerEntity;
import com.spring.henallux.DLivres.dataAccess.util.ProviderEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value ="/inscription")
public class InscriptionController {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private CategoryDAO categoryDAO = new CategoryDAO();
    @Autowired
    private LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO = new LanguageTranslationTitleOfBookDAO();

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ProviderEncoder encoder;



    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model, Locale locale)
    {
        model.addAttribute("booksPromo", languageTranslationTitleOfBookDAO.getTitleOfBookByLanguage(locale.toString()));
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
        model.addAttribute("connectionForm", new ConnectionForm());
        model.addAttribute("inscriptionForm", new InscriptionForm());
        model.addAttribute("MessageToDisplay", messageSource.getMessage("titleInscription",null,locale));
        return "integrated:inscription";

    }

    @RequestMapping(value="/send",method=RequestMethod.POST)
    public String getSignUpFormData (Model model, @Valid @ModelAttribute(value="inscriptionForm") InscriptionForm formInscription, final BindingResult errors, Locale locale) {

        if(!errors.hasErrors()&& formInscription.getPassword().equals(formInscription.getConfirmPassword()))
        {

            model.addAttribute("connectionForm", new ConnectionForm());
            model.addAttribute("inscriptionForm", formInscription);
            model.addAttribute("MessageToDisplay", messageSource.getMessage("titleInscription",null,locale));

            if(!model.containsAttribute("cart"))
            {
                HashMap<String , CommandLine> commandLine = new HashMap<String, CommandLine>();
                model.addAttribute("cart", commandLine);
            }

            return "integrated:inscription";

        }
        else{

            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setUsername(formInscription.getUserName());
            customerEntity.setPassword(new BCryptPasswordEncoder().encode(formInscription.getPassword()));
            customerEntity.setEmail(formInscription.getEmail());
            customerEntity.setBirthDate(formInscription.getBirthDate());
            customerEntity.setFirstName(formInscription.getFirstName());
            customerEntity.setName(formInscription.getName());
            customerEntity.setCity(formInscription.getCity());
            customerEntity.setCountry(formInscription.getCountry());
            customerEntity.setPostalCode(formInscription.getPostalCode());
            customerEntity.setStreet(formInscription.getStreet());
            customerEntity.setStreetNumber(formInscription.getStreetNumber());
            customerEntity.setPhoneNumber(formInscription.getPhoneNumber());


            customerEntity.setAuthorities("ROLE_USER");
            customerEntity.setAccountNonExpired(true);
            customerEntity.setAccountNonLocked(true);
            customerEntity.setCredentialsNonExpired(true);
            customerEntity.setEnabled(true);




            if(customerDAO.save(customerEntity))

                return "redirect:/index";
            else
                return "integrated:inscription";

        }
    }


}
