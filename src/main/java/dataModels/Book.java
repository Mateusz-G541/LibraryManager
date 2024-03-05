package dataModels;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;



public class Book extends Item{

    private final String ISBN ;
    private final String author ;

    @Builder
    public Book(UUID id, String title, UUID location, LocalDate releaseDate, BigDecimal rating,boolean isAvailable , int amount,String ISBN, String author) {
        super(id, title, location, releaseDate, rating, isAvailable, amount);
        this.ISBN = ISBN;
        this.author = author;
    }

}
