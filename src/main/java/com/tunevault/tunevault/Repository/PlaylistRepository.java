package com.tunevault.tunevault.Repository;


import com.tunevault.tunevault.Controller.request.PlaylistRequest;
import com.tunevault.tunevault.Entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
