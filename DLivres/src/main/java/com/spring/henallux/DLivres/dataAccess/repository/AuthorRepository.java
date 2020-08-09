package com.spring.henallux.DLivres.dataAccess.repository;

import com.spring.henallux.DLivres.dataAccess.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<AuthorEntity,Integer> {
}
