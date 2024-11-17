package com.leandrofa1980.DSList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandrofa1980.DSList.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
