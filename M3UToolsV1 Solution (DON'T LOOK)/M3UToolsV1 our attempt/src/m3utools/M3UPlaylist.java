/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jamie
 */
public class M3UPlaylist {

    public Boolean save(String filename){
       //Not yet implemented
       return false;
    }
    
    private List<M3UTrack> tracks;

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
        if(this.tracks.equals(other.tracks)==false)
        {
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
