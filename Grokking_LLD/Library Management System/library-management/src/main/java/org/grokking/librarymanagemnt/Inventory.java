package org.grokking.librarymanagemnt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.grokking.librarymanagemnt.model.Author;
import org.grokking.librarymanagemnt.model.Book;
import org.grokking.librarymanagemnt.model.BookItem;

import java.util.ArrayList;
import java.util.HashMap;

/*
* Initiating it as a singleton class*/
@Getter
@Setter
public class Inventory {

    HashMap<Book, ArrayList<BookItem>> bookList;
    HashMap<Author, ArrayList<Book>> authorList;

    private Inventory(){
        bookList = new HashMap<>();
        authorList = new HashMap<>();
    }

    private static final class InventoryHolder {
        private static final Inventory inventory = new Inventory();
    }

    public static Inventory getInstance(){
        return InventoryHolder.inventory;
    }

    public void addBook(BookItem bookItem){
        // add to both lists
    }

}
