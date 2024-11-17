package com.leandrofa1980.DSList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandrofa1980.DSList.dto.GameListDTO;
import com.leandrofa1980.DSList.entities.GameList;
import com.leandrofa1980.DSList.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = repository.findAll(); // 
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}


}
