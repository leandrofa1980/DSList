package com.leandrofa1980.DSList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrofa1980.DSList.dto.GameListDTO;
import com.leandrofa1980.DSList.dto.GameMinDTO;
import com.leandrofa1980.DSList.dto.ReplacementDTO;
import com.leandrofa1980.DSList.services.GameListService;
import com.leandrofa1980.DSList.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		service.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}

}
