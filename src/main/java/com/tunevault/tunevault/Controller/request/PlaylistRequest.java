package com.tunevault.tunevault.Controller.request;

import com.tunevault.tunevault.Controller.response.SongResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record PlaylistResponse(
        Long id,
        String name,
        String description
        List<SongResponse> song
) {
}
