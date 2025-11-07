package com.tunevault.tunevault.Mapper;


import com.tunevault.tunevault.Controller.request.ArtistRequest;
import com.tunevault.tunevault.Controller.response.ArtistResponse;
import com.tunevault.tunevault.Controller.response.SongResponse;
import com.tunevault.tunevault.Entity.Artist;
import com.tunevault.tunevault.Entity.Song;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


@UtilityClass
public class ArtistMapper {

    public static Artist toArtist (ArtistRequest request){

        List<Song> list = new ArrayList<>();

        if (request.songs() != null) {
            list = new ArrayList<>( request.songs().stream().map(songId-> Song.builder()
                    .id(songId).build()).toList());
        }

        return Artist.builder()
                .id(request.id())
                .name(request.name())
                .songs(list)
                .build();
    }

    public static ArtistResponse toArtistResponse (Artist artist) {
        List<SongResponse> list = artist.getSongs() != null
                ? artist.getSongs().stream().map(song -> SongResponse.builder().build())
                .toList() : Collections.emptyList();

        return ArtistResponse.builder()
                .name(artist.getName())
                .songs(list)
                .build();

    }
}
