package com.example.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.learning.dto.SearchForm;
import com.example.learning.entity.Article;
import com.example.learning.respository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j //로그를 위한 이노테이션
public class SearchController {


    @Autowired //스프링부트에서 자동으로 객체 가져다가 연결
    private ArticleRepository articleRepository;
    
    @PostMapping("/search")
    public String search(SearchForm form){
        // System.out.println(form.toString());
        log.info(form.toString());

        //1. DTO를 Entity로 변환
        Article article = form.toEntity();
        // System.out.println(article.toString());
        log.info(article.toString());

        //2. Entity를 Repository를 통해 database로 
        Article saved = articleRepository.save(article);
        // System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }
}
