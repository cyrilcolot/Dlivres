package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="languagetranslationtitleofbook")
@NamedQueries({
        @NamedQuery(
                name = "findTitleOfBookByCategory",
                query = "select titleOfBook from LanguageTranslationTitleOfBookEntity titleOfBook where titleOfBook.book_id.category.category_id = :category "),
        @NamedQuery(
                name = "findTitleOfBookByIsbn",
                query = "select titleOfBook from LanguageTranslationTitleOfBookEntity titleOfBook where titleOfBook.book_id.isbn = :bookId "),
        @NamedQuery(
                name = "findTitleOfBookByLanguage",
                query = "select titleOfBook from LanguageTranslationTitleOfBookEntity titleOfBook where titleOfBook.currentLanguage_id.currentLanguage_id = :language")
})
public class LanguageTranslationTitleOfBookEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="languagetranslationtitleofbook_id")
    private Integer languageTranslationTitleOfBookid;

    @Column(name="translationtitleofbook")
    private String translationTitleOfBook;

    @JoinColumn(name="book_id", referencedColumnName="isbn")
    @ManyToOne
    private BookEntity book_id;

    @JoinColumn(name="currentlanguage_id", referencedColumnName="currentlanguage_id")
    @ManyToOne
    private CurrentLanguageEntity currentLanguage_id;

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

    public BookEntity getBook_id() {
        return book_id;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }

    public CurrentLanguageEntity getCurrentLanguage_id() {
        return currentLanguage_id;
    }

    public void setCurrentLanguage_id(CurrentLanguageEntity currentLanguage_id) {
        this.currentLanguage_id = currentLanguage_id;
    }
}
