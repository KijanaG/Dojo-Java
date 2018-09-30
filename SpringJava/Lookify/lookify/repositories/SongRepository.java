package com.garrett.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garrett.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

	List<Song> findAll();
	List<Song> findAllByArtistContaining(String artist);
	List<Song> findTop10ByOrderByRatingDesc();
}
