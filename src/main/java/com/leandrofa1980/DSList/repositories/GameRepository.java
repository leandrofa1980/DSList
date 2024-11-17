package com.leandrofa1980.DSList.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leandrofa1980.DSList.entities.Game;
import com.leandrofa1980.DSList.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

}
// Foi criado uma consulta sql personalizada para o spring, para utilizar o nativeQuery o resultado da 
// consulta precisaser uma interfaceque no spring é chamada de projection, por isso foi criada a inteface 
// GameMinProjection no subpacote projections e colocamos métodos gets conrrespondentes a consulta 
