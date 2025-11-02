package com.tunevault.tunevault.Service;

import com.tunevault.tunevault.Entity.Artist;
import com.tunevault.tunevault.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public Artist save(Artist artist){
        return artistRepository.save(artist);
    }


    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    public List<Artist> findAll(){
       return artistRepository.findAll();
    }
}
