package com.spring.henallux.DLivres.dataAccess.repository;

import com.spring.henallux.DLivres.dataAccess.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

}
