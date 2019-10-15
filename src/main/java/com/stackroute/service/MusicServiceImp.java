package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImp implements MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImp(MusicRepository musicRepository){
        this.musicRepository = musicRepository;               // at runtime spring will provide this service a userRepository object via constructor dependency injection
    }
    @Override
    public Music saveMusic(Music music) {
        Music saveMusic = musicRepository.save(music);      // this save method comes from the jpa repository interface that our user repository interface extends
        return saveMusic;
    }

    @Override
    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }

    @Override
    public Music updateMusic(Music music) {
        //music.setComment("Hello");
        Music m=musicRepository.save(music);
        return m;
    }

    @Override
    public void deleteMusic(Music music) {
        musicRepository.delete(music);
    }
}
