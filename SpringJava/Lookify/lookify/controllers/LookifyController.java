package com.garrett.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garrett.lookify.models.Song;
import com.garrett.lookify.services.SongService;

@Controller
public class LookifyController {
	private final SongService songServ;
	public LookifyController(SongService songServ) {
		this.songServ = songServ;
	}
	
	@GetMapping("/")
	public String main() {
		return "/songs/main.jsp";
	}
	
	@GetMapping("/dashboard")
	public String index(Model model) {
		List<Song> songs = songServ.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/index.jsp";
	}
	
	@GetMapping("/search")
	public String searchArtist(@RequestParam("artist") String artist, Model model) {
		if(artist == "") {
			return "redirect:/dashboard";
		}
		List<Song> songs = songServ.findBySearch(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "/songs/search.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}
	
	@PostMapping("/song/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		} else {
			songServ.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songServ.findSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/ratings")
	public String ratings(Model model) {
		List<Song> songs = songServ.orderSongs();
		model.addAttribute("songs", songs);
		return "/songs/ratings.jsp";
	}
}
