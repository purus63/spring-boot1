
package com.stackroute.controller;

import com.stackroute.domain.Music;
import com.stackroute.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class MusicController {   // @RestController annotation is a responsible for returning the data by directly writing the data into http response as JSON

    MusicService musicService;

    public MusicController(MusicService musicService){
        this.musicService = musicService;
    }

    @PostMapping("music")  //resource name is user
    public ResponseEntity<?> saveMusic(@RequestBody Music music){     // handler method to handle post request to save a user
        ResponseEntity responseEntity;
        try{
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);        // in the try block we created a responseEntity object (the first parameter is a string message to be sent back as response and the second parameter is the http status code)
        }
        catch(Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;          // we returned a responseEntity from saveUser method in spring REST a respoonseEntity represents a complete http response including response body, status code and headers.
    }

    @GetMapping("music")// handler method to retrieve all users
    public ResponseEntity<?> getAllMusics(){
        ResponseEntity responseEntity;
        try{
            musicService.getAllMusics();
            responseEntity = new ResponseEntity<List<Music>>(musicService.getAllMusics(), HttpStatus.OK);
        }
        catch(Exception ex1){
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("music")
    public ResponseEntity<?> deleteMusic(@RequestBody Music music){
        ResponseEntity responseEntity;
        try{
            musicService.deleteMusic(music);
            responseEntity = new ResponseEntity<String>( "Deleted Successfully", HttpStatus.OK);
        }
        catch(Exception ex1){
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("music")
    public ResponseEntity<?> updateMusic(@RequestBody Music music){
        ResponseEntity responseEntity;
        try{
            musicService.updateMusic(music);
            responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
        }
        catch(Exception ex1){
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
