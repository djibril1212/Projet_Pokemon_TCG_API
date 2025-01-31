package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.models.Combat;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.repositories.CombatRepository;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import fr.efrei.pokemon_tcg.repositories.DresseurRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CombatService {

    private final CombatRepository combatRepository;
    private final DresseurRepository dresseurRepository;
    private final CarteRepository carteRepository;

    public CombatService(CombatRepository combatRepository, DresseurRepository dresseurRepository, CarteRepository carteRepository) {
        this.combatRepository = combatRepository;
        this.dresseurRepository = dresseurRepository;
        this.carteRepository = carteRepository;
    }

    public Combat lancerCombat(String dresseur1Id, String dresseur2Id) {
        Dresseur dresseur1 = dresseurRepository.findById(dresseur1Id)
                .orElseThrow(() -> new RuntimeException("Dresseur 1 introuvable"));
        Dresseur dresseur2 = dresseurRepository.findById(dresseur2Id)
                .orElseThrow(() -> new RuntimeException("Dresseur 2 introuvable"));


        List<Carte> cartesDresseur1 = carteRepository.findByDresseur(dresseur1);
        List<Carte> cartesDresseur2 = carteRepository.findByDresseur(dresseur2);

        if (cartesDresseur1.isEmpty() || cartesDresseur2.isEmpty()) {
            throw new RuntimeException("Un des dresseurs n'a pas de carte !");
        }


        Carte meilleureCarteDresseur1 = cartesDresseur1.stream()
                .max(Comparator.comparingInt(c -> c.getPokemon().getNiveau()))
                .orElseThrow();
        Carte meilleureCarteDresseur2 = cartesDresseur2.stream()
                .max(Comparator.comparingInt(c -> c.getPokemon().getNiveau()))
                .orElseThrow();


        Dresseur vainqueur;
        Dresseur perdant;
        Carte cartePerdue;

        if (meilleureCarteDresseur1.getPokemon().getNiveau() >= meilleureCarteDresseur2.getPokemon().getNiveau()) {
            vainqueur = dresseur1;
            perdant = dresseur2;
            cartePerdue = meilleureCarteDresseur2;
        } else {
            vainqueur = dresseur2;
            perdant = dresseur1;
            cartePerdue = meilleureCarteDresseur1;
        }


        if (cartePerdue == null) {
            throw new RuntimeException("Erreur : aucune carte ne peut être transférée !");
        }

        cartePerdue.setDresseur(vainqueur);
        carteRepository.save(cartePerdue);

        Combat combat = new Combat();
        combat.setDresseur1(dresseur1);
        combat.setDresseur2(dresseur2);
        combat.setVainqueur(vainqueur);
        combat.setCarteTransferee(cartePerdue);
        combatRepository.save(combat);

        return combat;
    }
}