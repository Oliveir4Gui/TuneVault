package com.tunevault.tunevault.Service;

import com.tunevault.tunevault.Entity.Playlist;
import com.tunevault.tunevault.Repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;


    public List<Playlist> findAll(){
        return playlistRepository.findAll();
    }

    public Playlist findById(Long id){
        return playlistRepository.findById(id).orElseThrow(()-> new RuntimeException("Playlist not found"));
    }

    public Playlist save(Playlist playlist){
        return playlistRepository.save(playlist);
    }

    public Playlist update(Playlist playlist){
        Optional<Playlist> optional = playlistRepository.findById(playlist.getId());
        if(optional.isPresent()){
            Playlist playlistToUpdate = optional.get();
            playlistToUpdate.setName(playlist.getName());
            playlistToUpdate.setDescription(playlist.getDescription());
            playlistToUpdate.setSongs(playlist.getSongs());
            return playlistRepository.save(playlistToUpdate);
        }
        return null;
    }

    public void deleteById(Long id){
        playlistRepository.deleteById(id);
    }

}
