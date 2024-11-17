package com.leandrofa1980.DSList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrofa1980.DSList.dto.GameDTO;
import com.leandrofa1980.DSList.dto.GameMinDTO;
import com.leandrofa1980.DSList.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = service.findById(id);
		return result;
	}
	
//	@GetMapping
//	public List<Game> findAll(){
//		List<Game> list = service.findAll();
//		return list;
//	}
	
	//Trocar a lista de Game para GamMinDTO já que no service foi alterado para um DTO
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = service.findAll();
		return result;
	}

}
