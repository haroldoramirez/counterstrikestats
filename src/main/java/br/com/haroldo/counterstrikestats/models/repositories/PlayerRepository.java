package br.com.haroldo.counterstrikestats.models.repositories;

import br.com.haroldo.counterstrikestats.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "select * from player as r where r.name = ?1", nativeQuery = true)
    Player findByName(String name);

    @Query(value = "select * from player as r where r.status = ?1 and DATE(r.registration_date) = ?2", nativeQuery = true)
    Player findByStatusAndRegisteredDate(String status, Date dataCadastro);

    @Query(value = "select * from player as r ORDER BY r.registration_date DESC", nativeQuery = true)
    List<Player> listPlayersByDescendingOrder();
}
