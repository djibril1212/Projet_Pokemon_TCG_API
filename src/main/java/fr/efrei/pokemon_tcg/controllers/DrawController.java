package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.services.implementations.DrawService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/draw")
public class DrawController {

    private final DrawService drawService;

    public DrawController(DrawService drawService) {
        this.drawService = drawService;
    }

    @GetMapping("/tirer")
    public List<Pokemon> tirerCartes() {
        return drawService.tirerCartes();
    }
}