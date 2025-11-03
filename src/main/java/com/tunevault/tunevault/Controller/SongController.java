package com.tunevault.tunevault.Controller;

import com.tunevault.tunevault.Controller.request.SongRequest;
import com.tunevault.tunevault.Controller.response.SongResponse;
import com.tunevault.tunevault.Entity.Song;
import com.tunevault.tunevault.Mapper.SongMapper;
import com.tunevault.tunevault.Repository.SongRepository;
import com.tunevault.tunevault.Service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;
    private final SongMapper songMapper;


    @GetMapping()
    public List<Song> findAll() {
        return songService.findAll();
    }

    @PostMapping()
    public SongResponse save(@RequestBody SongRequest song) {
        Song toSong = songMapper.toSongEntity(song);
        songService.save(toSong);
        return songMapper.toSongResponse(toSong);
    }
}
