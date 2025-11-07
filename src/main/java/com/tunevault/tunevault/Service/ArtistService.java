package com.tunevault.tunevault.Service;

import com.tunevault.tunevault.Entity.Artist;
import com.tunevault.tunevault.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    public Optional<Artist> update(Long id, Artist artist) {
        Optional<Artist> optionalArtist = artistRepository.findById(id);
        if (optionalArtist.isPresent()) {
            Artist updatedArtist = optionalArtist.get();
            updatedArtist.setName(artist.getName());
            if (artist.getSongs() != null) {
                updatedArtist.getSongs().clear();
                updatedArtist.getSongs().addAll(new ArrayList<>(artist.getSongs()));
            }
            artistRepository.save(updatedArtist);
           return Optional.of(updatedArtist);
        }
        return Optional.empty();
    }
}
