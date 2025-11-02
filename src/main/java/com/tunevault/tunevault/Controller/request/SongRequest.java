package com.tunevault.tunevault.Controller.request;

import com.tunevault.tunevault.Entity.Playlist;

import java.util.List;

public record SongRequest(
        Long id,
        String title,
        Integer duration,
        Long artist_id,
        List<Long>playlists
) {
}
