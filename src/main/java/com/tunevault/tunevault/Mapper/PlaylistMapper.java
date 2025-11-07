package com.tunevault.tunevault.Mapper;

import com.tunevault.tunevault.Controller.request.PlaylistRequest;
import com.tunevault.tunevault.Controller.response.PlaylistResponse;
import com.tunevault.tunevault.Entity.Playlist;
import com.tunevault.tunevault.Entity.Song;
import com.tunevault.tunevault.Repository.SongRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Component
public class PlaylistMapper {
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public Playlist toPlaylist(PlaylistRequest playlistRequest) {

        List<Song> songs = playlistRequest.songs()!=null? songRepository.findAllById(playlistRequest.songs())
                : new ArrayList<>();

        return Playlist.builder()
                .id(playlistRequest.id())
                .name(playlistRequest.name())
                .description(playlistRequest.description())
                .songs(songs)

                .build();
    }


    public PlaylistResponse toPlaylistResponse(Playlist playlist) {
        return PlaylistResponse.builder()
                .id(playlist.getId())
                .name(playlist.getName())
                .description(playlist.getDescription())
                .songs(playlist.getSongs().stream().map(song -> songMapper.toSongResponse(song)).toList())
                .build();
    }


}
