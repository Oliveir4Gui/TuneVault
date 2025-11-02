package com.tunevault.tunevault.Controller.request;

import com.tunevault.tunevault.Entity.Song;

import java.util.List;

public record ArtistRequest(
        Long id,
        String name,
        List<Long> songs
) {
}
