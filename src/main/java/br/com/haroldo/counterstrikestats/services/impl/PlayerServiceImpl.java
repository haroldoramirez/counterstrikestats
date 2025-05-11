package br.com.haroldo.counterstrikestats.services.impl;

import br.com.haroldo.counterstrikestats.exceptions.RegraNegocioException;
import br.com.haroldo.counterstrikestats.models.entities.Player;
import br.com.haroldo.counterstrikestats.models.enums.StatusPlayer;
import br.com.haroldo.counterstrikestats.models.repositories.PlayerRepository;
import br.com.haroldo.counterstrikestats.services.PlayerService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {

        super();
        this.playerRepository = playerRepository;

    }

    @Override
    public Player save(Player player) {

        validate(player);
        player.setRegistrationDate(LocalDateTime.now());
        player.setStatus(StatusPlayer.ATIVO);

        Optional<Player> playerFound = Optional.ofNullable(playerRepository.findByName(player.getName()));

        if (playerFound.isPresent()) {
            throw new RegraNegocioException("Já existe um player cadastrado com o nome " + playerFound.get().getName());
        }

        return playerRepository.save(player);
    }

    @Override
    public void validate(Player player) {

        String errorMsg = "";

        if (StringUtils.isBlank(player.getName())) {
            errorMsg += "Field Name is empty.";
        }

        if (!errorMsg.isEmpty()) {
            throw new RegraNegocioException("Error: " + errorMsg);
        }

    }

}