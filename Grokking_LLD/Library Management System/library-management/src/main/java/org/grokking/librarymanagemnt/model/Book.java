package org.grokking.librarymanagemnt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private int bookId;
    private String bookName;
    private Author author;
    private String genre;
    private String publication;
    private double price;
}
