package com.example.learning.dto;

import com.example.learning.entity.Article;

public class SearchForm {
    
    private String searchString;

    public SearchForm(String searchString){
        this.searchString = searchString;
    }

    public Article toEntity(){
        return new Article(null, searchString);
    }

    @Override
    public String toString(){
        return "searchString="+searchString;
    }
}
