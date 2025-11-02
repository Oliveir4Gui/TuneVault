package com.tunevault.tunevault.Controller.response;

import com.tunevault.tunevault.Entity.Song;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.util.List;


@Builder
public record ArtistResponse(
        String name,
        List<SongResponse> songs
) {
}
