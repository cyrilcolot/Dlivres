package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="languagetranslationtitleofbook")


public class LanguageTranslationTitleOfBookEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="languagetranslationtitleofbook_id")
    private Integer languageTranslationTitleOfBookid;

    @Column(name="translationtitleofbook")
    private String translationTitleOfBook;

    @JoinColumn(name="book_id", referencedColumnName="isbn")
    @ManyToOne
    private BookEntity bookId;

    @JoinColumn(name="currentlanguage_id", referencedColumnName="currentlanguage_id")
    @ManyToOne
    private CurrentLanguageEntity currentLanguageId;

    public Integer getLanguageTranslationTitleOfBookid() {
        return languageTranslationTitleOfBookid;
    }

    public void setLanguageTranslationTitleOfBookid(Integer languageTranslationTitleOfBookid) {
        this.languageTranslationTitleOfBookid = languageTranslationTitleOfBookid;
    }

    public String getTranslationTitleOfBook() {
        return translationTitleOfBook;
    }

    public void setTranslationTitleOfBook(String translationTitleOfBook) {
        this.translationTitleOfBook = translationTitleOfBook;
    }

    public BookEntity getBookId() {
        return bookId;
    }

    public void setBook_id(BookEntity bookId) {
        this.bookId = bookId;
    }

    public CurrentLanguageEntity getCurrentLanguageId() {
        return currentLanguageId;
    }

    public void setCurrentLanguageId(CurrentLanguageEntity currentLanguageId) {
        this.currentLanguageId = currentLanguageId;
    }
}
