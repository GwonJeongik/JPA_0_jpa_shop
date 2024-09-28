package jpabook.jpashop;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item{

    private Long isbn;
    private String author;
}
