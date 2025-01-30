package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Carte;
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

    @GetMapping("/tirer/{dresseurId}")
    public ResponseEntity<List<Carte>> tirerCartes(@PathVariable String dresseurId) {
        List<Carte> cartes = drawService.tirerCartes(dresseurId);
        return new ResponseEntity<>(cartes, HttpStatus.OK);
    }
}