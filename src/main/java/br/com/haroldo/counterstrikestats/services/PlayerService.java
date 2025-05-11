package br.com.haroldo.counterstrikestats.services;

import br.com.haroldo.counterstrikestats.models.entities.Player;

public interface PlayerService {

    Player save(Player player);

    void validate(Player player);

}
