package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="languagetranslationwordingofcategory")
public class LanguageTranslationWordingOfCategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="languagetranslationwordingofcategory_id")
    private Integer languageTranslationWordingOfCategory_id;

    @Column(name="translationwordingofcategory")
    private String translationWordingOfCategory;

    @JoinColumn(name="currentlanguage_id", referencedColumnName="currentlanguage_id")
    @ManyToOne
    private CurrentLanguageEntity currentLanguageId;

    @JoinColumn(name="category_id", referencedColumnName="category_id")
    @ManyToOne
    private CategoryEntity category_id;

    public Integer getLanguageTranslationWordingOfCategory_id() {
        return languageTranslationWordingOfCategory_id;
    }


    public String getTranslationWordingOfCategory() {
        return translationWordingOfCategory;
    }


    public void setLanguageTranslationWordingOfCategory_id(Integer languageTranslationWordingOfCategory_id) {
        this.languageTranslationWordingOfCategory_id = languageTranslationWordingOfCategory_id;
    }


    public void setTranslationWordingOfCategory(String translationWordingOfCategory) {
        this.translationWordingOfCategory = translationWordingOfCategory;
    }

    public CurrentLanguageEntity getCurrentLanguageId() {
        return currentLanguageId;
    }

    public void setCurrentLanguageId(CurrentLanguageEntity currentLanguageId) {
        this.currentLanguageId = currentLanguageId;
    }

    public CategoryEntity getCategory_id() {
        return category_id;
    }

    public void setCategory_id(CategoryEntity category_id) {
        this.category_id = category_id;
    }


}
