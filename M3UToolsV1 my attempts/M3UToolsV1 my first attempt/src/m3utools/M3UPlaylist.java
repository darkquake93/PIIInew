/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jamie
 */
public class M3UPlaylist {

    private List<M3UTrack> tracks;

    public int add(String playlistFilename) {
        File file = new File(playlistFilename);
        M3UPlaylist pl = M3UReader.getPlaylist(file);
        try {
            for (M3UTrack track : pl.tracks) {
                pl.tracks.add(track);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return 0;
        }
        return 5;
    }

public M3UTrack getNextTrack() throws IOException {
        int trackIndex = 0;
        M3UTrack trackItem = new M3UTrack();
        if (trackItem.getTrackName() != null && tracks.get(trackIndex) != null) {

            trackItem = tracks.get(trackIndex);
            System.out.println(trackItem);
        }

        if (trackItem.getTrackName() == null) {
            return null;
        }
        trackIndex += 1;
        System.out.println(trackIndex);
        IOException ex = new IOException();
        return trackItem;

    }

    public Boolean save(String filename) {
        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            for (M3UTrack track : this.tracks) {
                String line = track.getArtistName() + " - "
                        + track.getTrackDuration() + " - "
                        + track.getTrackName() + " - "
                        + track.getTrackFilename();
                writer.println(line);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return false;
        }
        return true;
    }

    public List<M3UTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<M3UTrack> tracks) {
        this.tracks = tracks;
    }

    public M3UPlaylist() {
        this.tracks = new ArrayList<>();
    }

    public void addTrack(M3UTrack thisTrack) {
        this.tracks.add(thisTrack);
    }

    @Override
        public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final M3UPlaylist other = (M3UPlaylist) obj;
        if (this.tracks.equals(other.tracks) == false) {
            return false;
        }
        return true;
    }

    @Override
        public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.tracks);
        return hash;
    }

}
