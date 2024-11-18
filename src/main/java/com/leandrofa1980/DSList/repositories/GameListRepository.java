package com.leandrofa1980.DSList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.leandrofa1980.DSList.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

	@Modifying // É usado quando uma consulta não é feita com SELECT usamos essa anotação 
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition); 

}
