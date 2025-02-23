package org.grokking.librarymanagemnt;

import lombok.Getter;
import lombok.Setter;
import org.grokking.librarymanagemnt.model.BookItem;
import org.grokking.librarymanagemnt.model.IssuedBook;
import org.grokking.librarymanagemnt.model.Member;

import java.util.Date;

@Getter
@Setter
public class IssuingSystem {
    private String activeLibrarianId;
    private SearchSystem searchSystem;

    IssuingSystem(){
        searchSystem = new SearchSystem();
    }

    public void getMemberInfo(){}

    public void issueBook(Member member){
        try {
            BookItem bookitem = searchSystem.getBookItemFromBook(searchSystem.getBookByName("test"));
            bookitem.setIssuedTo(member);
            IssuedBook issuedBook = new IssuedBook("id1", bookitem, new Date(), 0, member.getId(), activeLibrarianId);
            member.addToIssuedBook(issuedBook);

        } catch (Exception e){
            System.out.println("NO BOOK FOUND !! \n" +  e);
        }

    }

    public void renewBook(){}

    public void returnBook(){}

    public void hasFine(){}

    public void payFine(){}
}
