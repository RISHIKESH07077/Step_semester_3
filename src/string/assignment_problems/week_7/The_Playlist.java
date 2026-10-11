package string.assignment_problems.Week_7;

import java.util.Arrays;

public class The_Playlist {

    static class Playlist {
        private final String[] songs;
        private int songCount;

        public Playlist(int capacity) {
            songs = new String[Math.max(0, capacity)];
            songCount = 0;
        }

        public boolean addSong(String song) {
            if (song == null || songCount >= songs.length) {
                return false;
            }

            songs[songCount++] = song;
            return true;
        }

        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}