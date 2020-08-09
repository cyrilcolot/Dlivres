package com.spring.henallux.DLivres.Model;

public class LanguageTranslationTitleOfBook {
    private Integer languageTranslationTitleOfBook_id;
    private String translationTitleOfBook;
    private CurrentLanguage currentLanguage_id;
    private Book book_id;

    public LanguageTranslationTitleOfBook(){}
    public Integer getLanguageTranslationTitleOfBook_id() {
        return languageTranslationTitleOfBook_id;
    }
    public void setLanguageTranslationTitleOfBook_id(Integer languageTranslationTitleOfBook_id) {
        this.languageTranslationTitleOfBook_id = languageTranslationTitleOfBook_id;
    }
    public String getTranslationTitleOfBook() {
        return translationTitleOfBook;
    }
    public void setTranslationTitleOfBook(String translationTitleOfBook) {
        this.translationTitleOfBook = translationTitleOfBook;
    }
    public CurrentLanguage getCurrentLanguage_id() {
        return currentLanguage_id;
    }
    public void setCurrentLanguage_id(CurrentLanguage currentLanguage_id) {
        this.currentLanguage_id = currentLanguage_id;
    }
    public Book getBook_id() {
        return book_id;
    }
    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }
}
