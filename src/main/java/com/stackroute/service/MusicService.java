package com.stackroute.service;

import com.stackroute.domain.Music;
import java.util.List;

public interface MusicService {

    public Music saveMusic(Music music);  // method to accept a user object to save and return the saved user object

    public List<Music> getAllMusics();  // returns all user objects stored in the database as a list of user objects

    public  Music updateMusic(Music music);

    public void deleteMusic(Music music);
}
