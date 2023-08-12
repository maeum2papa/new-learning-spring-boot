package com.example.learning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue //자동으로 1,2,3 ... 이렇게 늘어남
    private Long id;
    
    @Column
    private String searchString;

    public Article(Long id, String searchString){
        this.id = id;
        this.searchString = searchString;
    }

    @Override
    public String toString(){
        return "id="+id+", searchString="+searchString;
    }
}
