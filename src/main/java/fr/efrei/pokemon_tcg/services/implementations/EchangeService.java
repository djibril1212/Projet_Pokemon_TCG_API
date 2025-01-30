package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.models.Echange;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import fr.efrei.pokemon_tcg.repositories.DresseurRepository;
import fr.efrei.pokemon_tcg.repositories.EchangeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EchangeService {

    private final EchangeRepository echangeRepository;
    private final DresseurRepository dresseurRepository;
    private final CarteRepository carteRepository;

    public EchangeService(EchangeRepository echangeRepository, DresseurRepository dresseurRepository, CarteRepository carteRepository) {
        this.echangeRepository = echangeRepository;
        this.dresseurRepository = dresseurRepository;
        this.carteRepository = carteRepository;
    }

    public Echange echangerCartes(String dresseur1Id, String dresseur2Id, String carte1Id, String carte2Id) {
        // Récupérer les dresseurs
        Dresseur dresseur1 = dresseurRepository.findById(dresseur1Id)
                .orElseThrow(() -> new RuntimeException("Dresseur 1 introuvable"));
        Dresseur dresseur2 = dresseurRepository.findById(dresseur2Id)
                .orElseThrow(() -> new RuntimeException("Dresseur 2 introuvable"));

        // Vérifier si un échange a déjà eu lieu aujourd'hui
        LocalDateTime aujourdHui = LocalDateTime.now().minusDays(1);
        if (!echangeRepository.findByDresseur1AndDateEchangeAfter(dresseur1, aujourdHui).isEmpty() ||
                !echangeRepository.findByDresseur2AndDateEchangeAfter(dresseur2, aujourdHui).isEmpty()) {
            throw new RuntimeException("Un dresseur a déjà fait un échange aujourd'hui !");
        }

        // Récupérer les cartes
        Carte carte1 = carteRepository.findById(carte1Id)
                .orElseThrow(() -> new RuntimeException("Carte 1 introuvable"));
        Carte carte2 = carteRepository.findById(carte2Id)
                .orElseThrow(() -> new RuntimeException("Carte 2 introuvable"));

        // Vérifier que les cartes appartiennent aux bons dresseurs
        if (!carte1.getDresseur().equals(dresseur1) || !carte2.getDresseur().equals(dresseur2)) {
            throw new RuntimeException("Une carte n'appartient pas au bon dresseur !");
        }

        // Effectuer l'échange
        carte1.setDresseur(dresseur2);
        carte2.setDresseur(dresseur1);
        carteRepository.save(carte1);
        carteRepository.save(carte2);

        // Enregistrer l'échange
        Echange echange = new Echange();
        echange.setDresseur1(dresseur1);
        echange.setDresseur2(dresseur2);
        echange.setCarte1(carte1);
        echange.setCarte2(carte2);
        echangeRepository.save(echange);

        return echange;
    }
}