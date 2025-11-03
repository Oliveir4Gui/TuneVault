package com.tunevault.tunevault.Mapper;

import com.tunevault.tunevault.Controller.request.SongRequest;
import com.tunevault.tunevault.Controller.response.SongResponse;
import com.tunevault.tunevault.Entity.Artist;
import com.tunevault.tunevault.Entity.Playlist;
import com.tunevault.tunevault.Entity.Song;
import com.tunevault.tunevault.Repository.SongRepository;
import com.tunevault.tunevault.Service.ArtistService;
import com.tunevault.tunevault.Service.SongService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SongMapper {

    private final ArtistService artistService;

    public Song toSongEntity(SongRequest songRequest) {
        Artist artist = artistService.findById(songRequest.artist_id())
                .orElseThrow(() -> new RuntimeException("Artist not found with id: " + songRequest.artist_id()));
        List<Playlist> playlists = songRequest.playlists().stream().map(playlist -> Playlist.builder().id(playlist).build()).toList();
        return Song.builder()
                .title(songRequest.title())
                .duration(songRequest.duration())
                .artist(artist)
                .playlists(playlists)
                .build();
    }

    public SongResponse toSongResponse(Song song) {
       List<Long> playlists = song.getPlaylists() != null ? song.getPlaylists().stream().map(playlist -> playlist.getId())
               .toList() : Collections.emptyList();

        String artistName = song.getArtist() != null
                ? song.getArtist().getName()
                : "Artista Desconhecido";

       Artist artist = song.getArtist();
        return SongResponse.builder()
                .title(song.getTitle())
                .duration(song.getDuration())
                .artistName(artist.getName())
                .playlists(playlists)
                .build();
    }
}
