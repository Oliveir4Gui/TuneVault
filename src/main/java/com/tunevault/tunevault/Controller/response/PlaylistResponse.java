package com.tunevault.tunevault.Controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record PlaylistResponse(
        Long id,
        String name,
        String description,
        List<SongResponse> songs
) {
}
