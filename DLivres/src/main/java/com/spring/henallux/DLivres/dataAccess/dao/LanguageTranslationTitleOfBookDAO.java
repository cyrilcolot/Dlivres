package com.spring.henallux.DLivres.dataAccess.dao;


import com.spring.henallux.DLivres.Model.LanguageTranslationTitleOfBook;
import com.spring.henallux.DLivres.Model.LanguageTranslationWordingOfCategory;
import com.spring.henallux.DLivres.dataAccess.entity.BookEntity;
import com.spring.henallux.DLivres.dataAccess.entity.CategoryEntity;
import com.spring.henallux.DLivres.dataAccess.entity.CurrentLanguageEntity;
import com.spring.henallux.DLivres.dataAccess.entity.LanguageTranslationTitleOfBookEntity;
import com.spring.henallux.DLivres.dataAccess.repository.LanguageTranslationTitleOfBookRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class LanguageTranslationTitleOfBookDAO {

    @Autowired
    private static ProviderConverter providerConverter = new ProviderConverter();
    @Autowired
    private LanguageTranslationTitleOfBookRepository languageTranslationTitleOfBookRepository;
    @Autowired
    private CurrentLanguageDAO currentLanguageDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private LanguageTranslationTitleOfBookDAO languageTranslationTitleOfBookDAO;
    @Autowired
    private BookDAO bookDAO;



    public ArrayList<LanguageTranslationTitleOfBook> getTitleOfBookByCategoryAndLanguage (Integer idCategory,String language)
    {

        ArrayList<LanguageTranslationTitleOfBook> titleOfBooks = new ArrayList<>();

        CategoryEntity categoryEntity = CategoryDAO.findEntityByCode(idCategory);
        CurrentLanguageEntity currentLanguageEntity = currentLanguageDAO.findCurrentLanguageByName(language);
        List<BookEntity> books = bookDAO.findBookbyCategory(categoryEntity);
        for(BookEntity book:books)
        {
            titleOfBooks.add(findByTitleByBookAndLanguage(book,currentLanguageEntity));
        }

        return titleOfBooks;
    }

    public LanguageTranslationTitleOfBook findByTitleByBookAndLanguage( BookEntity bookEntity,CurrentLanguageEntity currentLanguageEntity)
    {
        LanguageTranslationTitleOfBookEntity languageTranslationTitleOfBookEntity = languageTranslationTitleOfBookRepository.findByBookIdAndCurrentLanguageId(bookEntity,currentLanguageEntity);
        return providerConverter.languageTranslationTitleOfBookEntityToLanguageTranslationTitleOfBook(languageTranslationTitleOfBookEntity);
    }


    public ArrayList<LanguageTranslationTitleOfBook> findByCategory(Integer idCategory)
    {
        ArrayList<LanguageTranslationTitleOfBookEntity> languageTranslationTitleOfBooksEntities = new ArrayList<LanguageTranslationTitleOfBookEntity>();

        languageTranslationTitleOfBooksEntities = languageTranslationTitleOfBookRepository.findByBookId_Category_CategoryId(idCategory);

        ArrayList<LanguageTranslationTitleOfBook> languageTranslationTitleOfBooks = new ArrayList<>();

        for(LanguageTranslationTitleOfBookEntity titles : languageTranslationTitleOfBooksEntities)
        {
            LanguageTranslationTitleOfBook languageTranslationTitleOfBook = new LanguageTranslationTitleOfBook();
            languageTranslationTitleOfBook = providerConverter.languageTranslationTitleOfBookEntityToLanguageTranslationTitleOfBook(titles);
            languageTranslationTitleOfBooks.add(languageTranslationTitleOfBook);
        }

        return languageTranslationTitleOfBooks;
    }



    public ArrayList<LanguageTranslationTitleOfBook> getTitleOfBookByLanguage(String language)
    {

        ArrayList<LanguageTranslationTitleOfBookEntity> languageTranslationTitleOfBookEntity = new ArrayList<>();
        CurrentLanguageEntity currentLanguageEntity = currentLanguageDAO.findCurrentLanguageByName(language);


        languageTranslationTitleOfBookEntity = languageTranslationTitleOfBookRepository.findByCurrentLanguageId(currentLanguageEntity);

        ArrayList<LanguageTranslationTitleOfBook> languageTranslationTitleOfBooks = new ArrayList<>();

        for(LanguageTranslationTitleOfBookEntity tittles: languageTranslationTitleOfBookEntity)
        {
            LanguageTranslationTitleOfBook languageTranslationTitleOfBook = new LanguageTranslationTitleOfBook();
            languageTranslationTitleOfBook = providerConverter.languageTranslationTitleOfBookEntityToLanguageTranslationTitleOfBook(tittles);
            languageTranslationTitleOfBooks.add(languageTranslationTitleOfBook);

        }

        return languageTranslationTitleOfBooks;
    }




    public LanguageTranslationTitleOfBook getTitleOfBookByIsbn (Integer idBook)
    {

        LanguageTranslationTitleOfBookEntity languageTranslationTitleOfBookEntity = languageTranslationTitleOfBookRepository.findByBookId(idBook);
        return providerConverter.languageTranslationTitleOfBookEntityToLanguageTranslationTitleOfBook(languageTranslationTitleOfBookEntity);

    }

}
