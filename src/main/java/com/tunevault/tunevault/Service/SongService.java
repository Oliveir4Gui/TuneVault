package com.tunevault.tunevault.Service;

import com.tunevault.tunevault.Entity.Song;
import com.tunevault.tunevault.Repository.SongRepository;
import lombok.RequiredArgsConstructor;
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
}
