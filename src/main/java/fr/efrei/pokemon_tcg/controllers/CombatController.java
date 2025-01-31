package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Combat;
import fr.efrei.pokemon_tcg.services.implementations.CombatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/combat")
public class CombatController {

    private final CombatService combatService;

    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    @PostMapping
    public ResponseEntity<?> lancerCombat(
            @RequestParam String dresseur1Id,
            @RequestParam String dresseur2Id) {
        try {
            Combat combat = combatService.lancerCombat(dresseur1Id, dresseur2Id);
            return new ResponseEntity<>(combat, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Erreur lors du combat : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}