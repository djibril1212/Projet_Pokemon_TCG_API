package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.repositories.PokemonRepository;
import fr.efrei.pokemon_tcg.constants.TypePokemon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DrawService {

    private final PokemonRepository pokemonRepository;
    private final Random random = new Random();

    public DrawService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> tirerCartes() {
        List<Pokemon> cartesTirees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cartesTirees.add(genererPokemonAleatoire());
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
        int[] chances = {50, 30, 15, 4, 1}; // 1 étoile = 50%, 5 étoiles = 1%
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