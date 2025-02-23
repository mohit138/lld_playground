package org.grokking.librarymanagemnt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookItem {
    private int id;
    private Rack rack;
    private Book book;
    private Boolean isIssued;
    private Member issuedTo;

}
