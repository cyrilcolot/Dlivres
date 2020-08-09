package com.spring.henallux.DLivres.Model;

public class LanguageTranslationWordingOfCategory {
    private Integer languageTranslationWordingOfCategory_id;
    private String translationWordingOfCategory;
    private CurrentLanguage currentLanguage_id;
    private Category category_id;

    public LanguageTranslationWordingOfCategory(){}

    public Integer getLanguageTranslationWordingOfCategory_id() {
        return languageTranslationWordingOfCategory_id;
    }

    public void setLanguageTranslationWordingOfCategory_id(Integer languageTranslationWordingOfCategory_id) {
        this.languageTranslationWordingOfCategory_id = languageTranslationWordingOfCategory_id;
    }

    public String getTranslationWordingOfCategory() {
        return translationWordingOfCategory;
    }

    public void setTranslationWordingOfCategory(String translationWordingOfCategory) {
        this.translationWordingOfCategory = translationWordingOfCategory;
    }

    public CurrentLanguage getCurrentLanguage_id() {
        return currentLanguage_id;
    }

    public void setCurrentLanguage_id(CurrentLanguage currentLanguage_id) {
        this.currentLanguage_id = currentLanguage_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
