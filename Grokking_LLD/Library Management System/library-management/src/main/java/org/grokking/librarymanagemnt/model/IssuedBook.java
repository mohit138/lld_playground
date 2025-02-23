package org.grokking.librarymanagemnt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class IssuedBook {
    private String issuedBookId;
    private BookItem linkedBookItem;
    private Date issuedDate;
    private int renewCount;
    private String memberId;
    private String librarianId;

    public void issueBook(BookItem bookItem, Member member, Librarian librarian){

    }

    public void returnBook(){

    }

    public boolean canRenew(){
        return true;
    }

    public void renewBook(){}

    public double getFine(){
        return 0.0;
    }

}
