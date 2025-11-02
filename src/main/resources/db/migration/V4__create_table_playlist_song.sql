CREATE TABLE playlist_songs(
                               playlist_id BIGINT NOT NULL,
                               song_id BIGINT NOT NULL,
                               PRIMARY KEY (playlist_id, song_id),
                               CONSTRAINT fk_playlist_songs_playlist
                                   FOREIGN KEY (playlist_id) REFERENCES playlist(id) ON DELETE CASCADE,
                               CONSTRAINT fk_playlist_songs_song
                                   FOREIGN KEY (song_id) REFERENCES song(id) ON DELETE CASCADE
);