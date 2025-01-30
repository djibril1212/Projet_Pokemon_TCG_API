package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import fr.efrei.pokemon_tcg.repositories.PokemonRepository;
import fr.efrei.pokemon_tcg.repositories.DresseurRepository;
import fr.efrei.pokemon_tcg.constants.TypePokemon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DrawService {

    private final PokemonRepository pokemonRepository;
    private final CarteRepository carteRepository;
    private final DresseurRepository dresseurRepository;
    private final Random random = new Random();

    public DrawService(PokemonRepository pokemonRepository, CarteRepository carteRepository, DresseurRepository dresseurRepository) {
        this.pokemonRepository = pokemonRepository;
        this.carteRepository = carteRepository;
        this.dresseurRepository = dresseurRepository;
    }

    public List<Carte> tirerCartes(String dresseurId) {
        Optional<Dresseur> dresseurOpt = dresseurRepository.findById(dresseurId);
        if (dresseurOpt.isEmpty()) {
            throw new RuntimeException("Dresseur introuvable !");
        }
        Dresseur dresseur = dresseurOpt.get();

        List<Carte> cartesTirees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Pokemon pokemon = genererPokemonAleatoire();
            Carte carte = new Carte(pokemon, dresseur, false); // Deck secondaire par défaut
            carteRepository.save(carte);
            cartesTirees.add(carte);
        }
        return cartesTirees;
    }

    private Pokemon genererPokemonAleatoire() {
        Pokemon pokemon = new Pokemon();
        pokemon.setNom(genererNomPokemon());
        pokemon.setNiveau(random.nextInt(100) + 1);
        pokemon.setType(TypePokemon.values()[random.nextInt(TypePokemon.values().length)]);
        pokemon.setAttaque1(genererAttaque());
        pokemon.setAttaque2(genererAttaque());
        pokemon.setRarete(genererRarete());

        pokemonRepository.save(pokemon);
        return pokemon;
    }

    private String genererNomPokemon() {
        String[] noms = {"Pikachu", "Bulbizarre", "Salamèche", "Carapuce", "Evoli"};
        return noms[random.nextInt(noms.length)];
    }

    private String genererAttaque() {
        String[] attaques = {"Éclair", "Charge", "Flamme", "Hydrocanon", "Tranch'Herbe"};
        return attaques[random.nextInt(attaques.length)];
    }

    private int genererRarete() {
        int[] chances = {50, 30, 15, 4, 1};
        int roll = random.nextInt(100);
        int cumulative = 0;

        for (int i = 0; i < chances.length; i++) {
            cumulative += chances[i];
            if (roll < cumulative) {
                return i + 1;
            }
        }
        return 1;
    }
}