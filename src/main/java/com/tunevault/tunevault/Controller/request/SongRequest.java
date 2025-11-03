package com.tunevault.tunevault.Controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tunevault.tunevault.Entity.Playlist;

import java.util.List;

public record SongRequest(
        Long id,
        String title,
        Integer duration,
        @JsonProperty("artist_id")
        Long artist_id,
        List<Long>playlists
) {
}
