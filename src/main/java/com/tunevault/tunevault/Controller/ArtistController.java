package com.tunevault.tunevault.Controller;

import com.tunevault.tunevault.Controller.request.ArtistRequest;
import com.tunevault.tunevault.Controller.response.ArtistResponse;
import com.tunevault.tunevault.Entity.Artist;
import com.tunevault.tunevault.Mapper.ArtistMapper;
import com.tunevault.tunevault.Service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;


    @GetMapping
    public List<ArtistResponse> findAll(){
        return artistService.findAll().stream()
                .map(artist -> ArtistMapper.toArtistResponse(artist)).toList();
    }

    @PostMapping
    public ArtistResponse save(@RequestBody ArtistRequest request) {
     Artist artist = ArtistMapper.toArtist(request);
     artistService.save(artist);
     return ArtistMapper.toArtistResponse(artist);
    }

    @GetMapping("/{id}")
    public ArtistResponse findById(@PathVariable Long id) {
        return artistService.findById(id).stream().map(artist -> ArtistMapper.toArtistResponse(artist)).findFirst()
                .orElse(null);
    }


    @PutMapping("/{id}")
    public ArtistResponse update(@PathVariable Long id, @RequestBody ArtistRequest request) {
        return artistService.update(id, ArtistMapper.toArtist(request))
                .map(artist -> ArtistMapper.toArtistResponse(artist)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found"));
    }




    
}
