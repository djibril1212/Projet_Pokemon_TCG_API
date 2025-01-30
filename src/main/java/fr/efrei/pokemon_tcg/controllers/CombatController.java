package fr.efrei.pokemon_tcg.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import fr.efrei.pokemon_tcg.services.CombatService;


@RestController
@RequestMapping("/combat")
public class CombatController {

    private final CombatService combatService;

    @Autowired
    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    @PostMapping
    public ResponseEntity<String> lancerCombat(
            @RequestParam String dresseur1Uuid,
            @RequestParam String dresseur2Uuid) {
        try {
            String resultat = combatService.initierCombat(dresseur1Uuid, dresseur2Uuid);
            return ResponseEntity.ok(resultat);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}