package com.garrett.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garrett.lookify.models.Song;
import com.garrett.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
		System.out.println("Why NOT? SERVICE*&*&*&*");
	}
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public List<Song> findBySearch(String artist) {
		return songRepo.findAllByArtistContaining(artist);
	}
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	public void updateSong(Song song) {
		songRepo.save(song);
	}
	public List<Song> orderSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
}
