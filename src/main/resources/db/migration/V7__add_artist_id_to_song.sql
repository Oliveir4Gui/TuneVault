ALTER TABLE song
    ADD COLUMN artist_id BIGINT,
ADD CONSTRAINT fk_song_artist FOREIGN KEY (artist_id) REFERENCES artist(id) ON DELETE SET NULL;
