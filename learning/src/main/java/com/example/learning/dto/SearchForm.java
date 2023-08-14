package com.example.learning.dto;

import com.example.learning.entity.Article;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class SearchForm {
    
    private String searchString;

    public Article toEntity(){
        return new Article(null, searchString);
    }
    
}
