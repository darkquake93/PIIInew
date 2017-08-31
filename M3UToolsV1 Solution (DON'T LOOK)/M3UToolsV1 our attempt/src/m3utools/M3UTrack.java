/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.util.Objects;

/**
 *
 * @author Jamie
 */
public class M3UTrack {

    private String trackFilename;
    private String trackMetaData;
    private int trackDuration;

    public M3UTrack() {
    }

    public String getTrackFilename() {
        return trackFilename;
    }

    public M3UTrack setTrackFilename(String trackFilename) {
        this.trackFilename = trackFilename;
        return this;
    }

    public String getTrackMetaData() {
        return trackMetaData;
    }

    public M3UTrack setTrackMetaData(String trackMetaData) {
        this.trackMetaData = trackMetaData;
        return this;
    }

    public int getTrackDuration() {
        return trackDuration;
    }

    public M3UTrack setTrackDuration(int trackDuration) {
        this.trackDuration = trackDuration;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final M3UTrack other = (M3UTrack) obj;
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.trackFilename);
        hash = 47 * hash + Objects.hashCode(this.trackMetaData);
        hash = 47 * hash + this.trackDuration;
        return hash;
    }
    

}
