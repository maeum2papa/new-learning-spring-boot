package com.example.learning.respository;

import org.springframework.data.repository.CrudRepository;

import com.example.learning.entity.Article;

public interface ArticleRepository extends CrudRepository<Article,Long>{
    
}
