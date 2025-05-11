package br.com.haroldo.counterstrikestats.controllers;

import br.com.haroldo.counterstrikestats.exceptions.RegraNegocioException;
import br.com.haroldo.counterstrikestats.models.dtos.PlayerDTO;
import br.com.haroldo.counterstrikestats.models.entities.Player;
import br.com.haroldo.counterstrikestats.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/create")
    public String createPage() {
        return "player/create";
    }
    /**
     * metodo responsavel por salvar um registro
     *
     * @return a ModelAndView
     */
    @PostMapping("/create")
    public ModelAndView create(PlayerDTO playerDTO) {

        final Player player = playerDTO.convertToPlayer();

        try {

            ModelAndView mv = new ModelAndView("player/success");

            Player playerSaved = playerService.save(player);

            mv.addObject("playerName", playerSaved.getName());

            return mv;

        } catch (RegraNegocioException e) {

            ModelAndView mv = new ModelAndView("player/error");

            mv.addObject("mensagem", e.getMessage());

            return mv;

        }

    }
}