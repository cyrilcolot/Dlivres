package com.spring.henallux.DLivres.dataAccess.dao;


import com.spring.henallux.DLivres.dataAccess.entity.BookEntity;
import com.spring.henallux.DLivres.dataAccess.entity.CategoryEntity;
import com.spring.henallux.DLivres.dataAccess.repository.BookRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookDAO {


    @Autowired
    private BookRepository bookRepository;

    public BookDAO(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity>findBookbyCategory(CategoryEntity categoryEntity)
    {
        return bookRepository.findBookByCategory(categoryEntity);
    }


}