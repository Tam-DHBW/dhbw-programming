package dhbw.mos.media_library;

import java.util.List;

public class CompactDisk extends Work {
    private List<Song> songs;

    public CompactDisk(String title, List<Person> authors, List<Song> songs) {
        super(title, authors);
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}