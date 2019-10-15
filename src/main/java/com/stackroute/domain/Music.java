package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Music {

    @Id
    int trackId;
    String trackName;
    String comment;

    public Music() {
    }

    public Music(int trackId, String trackName, String comment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comment = comment;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Music{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
