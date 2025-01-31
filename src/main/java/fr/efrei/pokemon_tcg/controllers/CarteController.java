package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.services.implementations.CarteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartes")
public class CarteController {

    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    @GetMapping
    public ResponseEntity<List<Carte>> getCartesParDresseur(@RequestParam String dresseurId) {
        List<Carte> cartes = carteService.getCartesParDresseur(dresseurId);
        return new ResponseEntity<>(cartes, HttpStatus.OK);
    }
}