package com.esther.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esther.lookify.models.Song;
import com.esther.lookify.services.SongService;

@Controller
public class SongsController {
	
	private final SongService songService;
	
	public SongsController (SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/lookify/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/lookify/dashboard.jsp";
		
	}
	
	@RequestMapping("songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/lookify/show.jsp";
	}
	
	@RequestMapping("songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "/lookify/add.jsp";
		
	}
	
	@RequestMapping(value="songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
            return "/lookify/add.jsp";
        } else {
            songService.addSong(song);
            return "redirect:/songs/new";
        }  
	}

}
