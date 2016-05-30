package ejemplo.mim.com.libreria;

import java.io.Serializable;
import java.util.List;

import ejemplo.mim.com.libreria.local.Libro;

/**
 * Created by marcoisaac on 5/28/2016.
 */
public class Holder implements Serializable {
    private List<Libro> bookList;

    public List<Libro> getBookList() {
        return bookList;
    }

    public void setBookList(List<Libro> bookList) {
        this.bookList = bookList;
    }
}
