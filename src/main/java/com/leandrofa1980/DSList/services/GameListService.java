package com.leandrofa1980.DSList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandrofa1980.DSList.dto.GameListDTO;
import com.leandrofa1980.DSList.entities.GameList;
import com.leandrofa1980.DSList.projections.GameMinProjection;
import com.leandrofa1980.DSList.repositories.GameListRepository;
import com.leandrofa1980.DSList.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = repository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++){
		    repository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}


	}


}
