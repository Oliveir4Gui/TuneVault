package com.tunevault.tunevault.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;
}
