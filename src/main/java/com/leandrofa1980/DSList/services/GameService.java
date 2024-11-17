package com.leandrofa1980.DSList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandrofa1980.DSList.dto.GameDTO;
import com.leandrofa1980.DSList.dto.GameMinDTO;
import com.leandrofa1980.DSList.entities.Game;
import com.leandrofa1980.DSList.projections.GameMinProjection;
import com.leandrofa1980.DSList.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	// Buscar po ID transformando em DTO
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = repository.findById(id).get();// .get() é que o findById retorna do tipo optional e precisa passar o .get() para pegar esse id
		GameDTO dto = new GameDTO(result);
		return dto; // Para reduzir as linhas do código outra forma é subir o return passando o new GameDTO(result);
	}               // Ficaria: return new GameDTO(result);
	
//	public List<Game> findAll(){
//		List<Game> list = repository.findAll();
//		 return list;
//	}
	
// Para retornar uma lista de DTO é preciso utilizar o stream e map que vai transformar a lista de games em DTO
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = repository.findAll(); // Vai buscar a lista da entidade Game
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Transfoma em DTO
		 return dto;
	}
// Outra forma do return pode ser: 	return result.stream().map(x -> new GameMinDTO(x)).toList();
// Colocando o return direto no result

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = repository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
