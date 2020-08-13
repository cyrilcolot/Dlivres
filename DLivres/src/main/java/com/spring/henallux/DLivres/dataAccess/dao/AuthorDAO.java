package com.spring.henallux.DLivres.dataAccess.dao;


import com.spring.henallux.DLivres.Model.Author;
import com.spring.henallux.DLivres.dataAccess.entity.AuthorEntity;
import com.spring.henallux.DLivres.dataAccess.repository.AuthorRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorDAO {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ProviderConverter providerConverter;

    public ArrayList<Author> getAllAuthors()
    {
        ArrayList<Author> authors = new ArrayList<>();
        List<AuthorEntity> authorEntities = authorRepository.findAll();
        for(AuthorEntity authorEntity: authorEntities)
        {
            authors.add(providerConverter.authorEntityToAuthor(authorEntity));
        }
        return authors;
    }

}
