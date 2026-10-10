package encapsulation.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSize) {
        songs = new String[Math.max(0, maximumSize)];
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount++] = song;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        System.out.println(Arrays.toString(copy));
        copy[0] = "Hacked";
        System.out.println("First stored song: " + playlist.getSongs()[0]);
        System.out.println("Song count: " + playlist.getSongCount());
    }
}
