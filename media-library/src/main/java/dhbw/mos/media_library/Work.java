package dhbw.mos.media_library;

import java.util.List;

public class Work {
    private String title;
    private List<Person> authors;

    public Work(String title, List<Person> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Work{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
