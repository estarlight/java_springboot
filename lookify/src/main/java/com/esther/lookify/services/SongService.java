package com.esther.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.lookify.models.Song;
import com.esther.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	public Song addSong(Song song) {
		return songRepo.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if (song.isPresent()) {
			return song.get();
		} else {
			return null;
		}
	}
	
	public Song updateSong(Song song) {
		
		songRepo.save(song);
		return song;
	}
	
	public void deleteSongk(Long id) {
		songRepo.deleteById(id);
	}
	
	

}
