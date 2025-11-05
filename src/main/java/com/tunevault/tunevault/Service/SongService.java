package com.tunevault.tunevault.Service;

import com.tunevault.tunevault.Entity.Song;
import com.tunevault.tunevault.Repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.SpecialOneToOneType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SongService {

    private final SongRepository repository;

    public List<Song> findAll() {
        return repository.findAll();
    }
    public Song findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Song save(Song song) {
        return repository.save(song);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Song> update(Long id, Song song) {
        Optional<Song> optional = repository.findById(id);
        if (optional.isPresent()) {
            Song entity = optional.get();
            entity.setTitle(song.getTitle());
            entity.setDuration(song.getDuration());
            entity.setArtist(song.getArtist());
            entity.setPlaylists(song.getPlaylists());
            repository.save(entity);
            return Optional.of(entity);
        }


        return Optional.empty();
    }
}
