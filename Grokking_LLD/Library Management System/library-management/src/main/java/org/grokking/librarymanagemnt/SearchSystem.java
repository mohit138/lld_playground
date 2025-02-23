package org.grokking.librarymanagemnt;

import org.grokking.librarymanagemnt.model.Author;
import org.grokking.librarymanagemnt.model.Book;
import org.grokking.librarymanagemnt.model.BookItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchSystem {

    public BookItem getBookItemFromBook(Book book){
        return new BookItem();
    }

    public Book getBookByName(String name) throws Exception {
        Map.Entry<Book, ArrayList<BookItem>> book =  Inventory.getInstance().getBookList().entrySet().stream().filter(bookArrayListEntry -> bookArrayListEntry.getKey().getBookName().equals(name)).findFirst().orElse(null);
        if(book==null){
            throw new Exception("No book with this name");
        }
        return book.getKey();
    }

    public List<Book> getBookByAuthor(Author author) throws Exception{
        return Inventory.getInstance().getAuthorList().getOrDefault(author, new ArrayList<Book>());
    }

}
