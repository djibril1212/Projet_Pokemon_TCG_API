package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import fr.efrei.pokemon_tcg.repositories.DresseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteService {

    private final CarteRepository carteRepository;
    private final DresseurRepository dresseurRepository;

    public CarteService(CarteRepository carteRepository, DresseurRepository dresseurRepository) {
        this.carteRepository = carteRepository;
        this.dresseurRepository = dresseurRepository;
    }

    public List<Carte> getCartesParDresseur(String dresseurId) {
        Dresseur dresseur = dresseurRepository.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));
        return carteRepository.findByDresseur(dresseur);
    }
}