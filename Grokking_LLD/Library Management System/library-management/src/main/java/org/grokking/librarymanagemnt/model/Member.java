package org.grokking.librarymanagemnt.model;

import java.util.Date;
import java.util.HashSet;

public class Member extends User{

    private Date joinedOn;
    private Date membershipRenewOn;
    private String libraryCardId;
    HashSet<IssuedBook> issuedBooks;

    public Member(String id, Boolean isActive, String username, String password, String name, String address) {
        super(id, isActive, username, password, name, address);
    }


    @Override
    public Boolean resetPassword() {
        return null;
    }

    public void addToIssuedBook(IssuedBook issuedBook){
        issuedBooks.add(issuedBook);
    }

    public void removeFromIssuedBooks(IssuedBook issuedBook){
        issuedBooks.remove(issuedBook);
    }

    public void renewMembership(){

    }
}
