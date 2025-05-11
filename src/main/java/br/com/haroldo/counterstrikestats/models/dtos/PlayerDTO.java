package br.com.haroldo.counterstrikestats.models.dtos;

import br.com.haroldo.counterstrikestats.models.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

    private String name;

    public Player convertToPlayer() {
        Player player = new Player();
        player.setName(name);
        return player;
    }
}