/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author ku14009
 */
public class MainClass {

    public void printTrackList() {
        M3UTrack m3uTrack = new M3UTrack();
        System.out.println(m3uTrack.getTrackName());
    }
    
    public void getNextTrack() throws IOException {
        
        M3UPlaylist nextTrackInPlaylist = new M3UPlaylist();
        System.out.println(nextTrackInPlaylist.getNextTrack());
    }

    public static void main(String args[]) {
        String playlistFilename = "test-data/testGetPlaylist/three_tracks.m3u";
        M3UPlaylist list1 = M3UReader.getPlaylist(new File(playlistFilename));
        int numTracks = list1.getTracks().size();
        System.out.println(playlistFilename + "has " + numTracks + "tracks");

        Path pathToLookIn = Paths.get("test-data");
        List<String> listOfPlaylistFilenames = M3UFinder.getPlaylistFilenames(pathToLookIn);
        for (String thisPlayListFilename : listOfPlaylistFilenames) {
            M3UPlaylist thisPlaylist = M3UReader.getPlaylist(new File(thisPlayListFilename));
            int thisNumTracks = thisPlaylist.getTracks().size();
            System.out.println(thisPlayListFilename + "has " + thisNumTracks + "tracks");

        }

    }

}
