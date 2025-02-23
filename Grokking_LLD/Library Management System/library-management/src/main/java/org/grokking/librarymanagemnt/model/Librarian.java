package org.grokking.librarymanagemnt.model;

public class Librarian extends User{

    public Librarian(String id, Boolean isActive, String username, String password, String name, String address) {
        super(id, isActive, username, password, name, address);
    }

    @Override
    public Boolean resetPassword() {
        return null;
    }

    public void addBook(Book book){

    }

    public BookItem addBookCopy(Book book){
        return new BookItem();
    }

    public void blockMember(Member member){

    }

    public void unblockMember(Member member){}
}
