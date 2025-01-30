package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.services.implementations.DrawService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Pokemon>> tirerCartes() {
        List<Pokemon> cartesTirees = drawService.tirerCartes();
        return new ResponseEntity<>(cartesTirees, HttpStatus.OK);
    }
}