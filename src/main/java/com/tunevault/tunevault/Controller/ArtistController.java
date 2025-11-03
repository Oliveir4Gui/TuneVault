package com.tunevault.tunevault.Controller;

import com.tunevault.tunevault.Controller.request.ArtistRequest;
import com.tunevault.tunevault.Controller.response.ArtistResponse;
import com.tunevault.tunevault.Entity.Artist;
import com.tunevault.tunevault.Mapper.ArtistMapper;
import com.tunevault.tunevault.Service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    
}
