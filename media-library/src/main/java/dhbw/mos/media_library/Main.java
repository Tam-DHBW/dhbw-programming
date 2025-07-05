package dhbw.mos.media_library;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Person person = new Person("a", "a", null, new ArrayList<>());
        Work work = new Book("asdasd", new ArrayList<>(), "asdasd");
        person.works().add(work);
        work.getAuthors().add(person);
    }

    void tets(int[] arr) {

    }
}