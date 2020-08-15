package com.spring.henallux.DLivres.dataAccess.repository;


import com.spring.henallux.DLivres.Model.CurrentLanguage;
import com.spring.henallux.DLivres.Model.LanguageTranslationTitleOfBook;
import com.spring.henallux.DLivres.dataAccess.entity.BookEntity;
import com.spring.henallux.DLivres.dataAccess.entity.CurrentLanguageEntity;
import com.spring.henallux.DLivres.dataAccess.entity.LanguageTranslationTitleOfBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public interface LanguageTranslationTitleOfBookRepository extends JpaRepository<LanguageTranslationTitleOfBookEntity,Integer> {


    LanguageTranslationTitleOfBookEntity findByBookIdAndCurrentLanguageId(BookEntity bookEntity,CurrentLanguageEntity currentLanguageEntity);

    ArrayList<LanguageTranslationTitleOfBookEntity> findByCurrentLanguageId(CurrentLanguageEntity currentLanguage);


    ArrayList<LanguageTranslationTitleOfBookEntity> findByBookId_Isbn(Integer bookId);

    ArrayList<LanguageTranslationTitleOfBookEntity> findByBookId_Category_CategoryId(Integer category);

    /*
    @Query("select title from  LanguageTranslationTitleOfBookEntity title where title.currentLanguageId=(:language)")
    List<LanguageTranslationTitleOfBookEntity> findByCurrentLanguageId(@Param("language")String language);





    LanguageTranslationTitleOfBookEntity findByBookAndCurrentLanguage(BookEntity book, CurrentLanguageEntity language);
    ArrayList<LanguageTranslationTitleOfBookEntity> findByLanguage(String language);
    LanguageTranslationTitleOfBookEntity findByBook(Integer idBook);
    */
}