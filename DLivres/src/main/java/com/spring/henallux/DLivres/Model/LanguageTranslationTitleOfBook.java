package com.spring.henallux.DLivres.Model;

public class LanguageTranslationTitleOfBook {
    private Integer languageTranslationTitleOfBook_id;
    private String translationTitleOfBook;
    private CurrentLanguage currentLanguageId;
    private Book bookId;

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
    public CurrentLanguage getCurrentLanguageId() {
        return currentLanguageId;
    }
    public void setCurrentLanguageId(CurrentLanguage currentLanguageId) {
        this.currentLanguageId = currentLanguageId;
    }
    public Book getBookId() {
        return bookId;
    }
    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
}
