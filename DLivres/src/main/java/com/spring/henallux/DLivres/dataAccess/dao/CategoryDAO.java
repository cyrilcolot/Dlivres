package com.spring.henallux.DLivres.dataAccess.dao;


import com.spring.henallux.DLivres.Model.Category;
import com.spring.henallux.DLivres.Model.LanguageTranslationWordingOfCategory;
import com.spring.henallux.DLivres.dataAccess.entity.CategoryEntity;
import com.spring.henallux.DLivres.dataAccess.entity.LanguageTranslationWordingOfCategoryEntity;
import com.spring.henallux.DLivres.dataAccess.repository.CategoryRepository;
import com.spring.henallux.DLivres.dataAccess.repository.LanguageTranslationWordingOfCategoryRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryDAO {
    @Autowired
    private LanguageTranslationWordingOfCategoryRepository languageTranslationWordingOfCategoryRepository;
    @Autowired
    private static CategoryRepository categoryRepository;
    @Autowired
    private static ProviderConverter converter = new ProviderConverter();






    public static CategoryEntity findEntityByCode(Integer code)
    {
        return categoryRepository.findByCategoryId(code);
    }

    public ArrayList<LanguageTranslationWordingOfCategory> getAllCategories ()
    {
        ArrayList<LanguageTranslationWordingOfCategory> categories = new ArrayList<LanguageTranslationWordingOfCategory>();
        List<LanguageTranslationWordingOfCategoryEntity> traductionCategoryEntities = languageTranslationWordingOfCategoryRepository.findAll();
        for(LanguageTranslationWordingOfCategoryEntity languageTranslationWordingOfCategoryEntity : traductionCategoryEntities){

            categories.add(converter.languageTranslationWordingOfCategoryEntityToLanguageTranslationWordingOfCategory(languageTranslationWordingOfCategoryEntity));
        }
        return categories;
    }

}