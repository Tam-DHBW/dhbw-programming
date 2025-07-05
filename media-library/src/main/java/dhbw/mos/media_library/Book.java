package dhbw.mos.media_library;

import java.util.List;

public class Book extends Work {
    private String isbnNr;

    public Book(String title, List<Person> authors, String isbnNr) {
        super(title, authors);
        this.isbnNr = isbnNr;
    }

    public String getIsbnNr() {
        return isbnNr;
    }

    public void setIsbnNr(String isbnNr) {
        this.isbnNr = isbnNr;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNr='" + isbnNr + '\'' +
                '}';
    }
}
