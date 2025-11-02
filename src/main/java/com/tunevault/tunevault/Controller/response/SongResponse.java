package com.tunevault.tunevault.Controller.response;

import com.tunevault.tunevault.Entity.Artist;
import lombok.Builder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Builder
public record SongResponse(
        String title,
        Integer duration,
        String artistName,
        List<Long> playlists
) {}

