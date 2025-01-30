package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Echange;
import fr.efrei.pokemon_tcg.services.implementations.EchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/echange")
public class EchangeController {

    private final EchangeService echangeService;

    public EchangeController(EchangeService echangeService) {
        this.echangeService = echangeService;
    }

    @PostMapping
    public ResponseEntity<Echange> echangerCartes(
            @RequestParam String dresseur1Id,
            @RequestParam String dresseur2Id,
            @RequestParam String carte1Id,
            @RequestParam String carte2Id) {
        Echange echange = echangeService.echangerCartes(dresseur1Id, dresseur2Id, carte1Id, carte2Id);
        return new ResponseEntity<>(echange, HttpStatus.OK);
    }
}