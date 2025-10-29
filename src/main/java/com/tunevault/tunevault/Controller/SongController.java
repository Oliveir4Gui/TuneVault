package com.tunevault.tunevault.Controller;

import com.tunevault.tunevault.Entity.Song;
import com.tunevault.tunevault.Repository.SongRepository;
import com.tunevault.tunevault.Service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    @GetMapping()
    public List<Song> findAll() {
        return songService.findAll();
    }
}
