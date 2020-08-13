package com.spring.henallux.DLivres.dataAccess.repository;

import com.spring.henallux.DLivres.Model.LanguageTranslationWordingOfCategory;
import com.spring.henallux.DLivres.dataAccess.entity.CategoryEntity;
import com.spring.henallux.DLivres.dataAccess.entity.LanguageTranslationWordingOfCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LanguageTranslationWordingOfCategoryRepository extends JpaRepository<LanguageTranslationWordingOfCategoryEntity,Integer> {
   
}
