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

import java.util.List;
import java.util.Optional;

@Component
public class SongMapper {

    private ArtistService artistService;

    public Song toSongEntity(SongRequest songRequest) {
        Optional<Artist> artist =artistService.findById(songRequest.artist_id());
        List<Playlist> playlists = songRequest.playlists().stream().map(playlist -> Playlist.builder().id(playlist).build()).toList();
        return Song.builder()
                .title(songRequest.title())
                .duration(songRequest.duration())
                .artist(artist.orElse(null))
                .playlists(playlists)
                .build();
    }

    public static SongResponse toSongResponse(Song song) {
       List<Long> playlists = song.getPlaylists().stream().map(playlist -> playlist.getId()).toList();
        return SongResponse.builder()
                .title(song.getTitle())
                .duration(song.getDuration())
                .artistName(song.getArtist().getName())
                .playlists(playlists)
                .build();
    }
}
