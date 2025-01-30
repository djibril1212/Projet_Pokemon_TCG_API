package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon; // Référence au Pokémon associé

    @ManyToOne
    @JoinColumn(name = "dresseur_id", nullable = false)
    private Dresseur dresseur; // À qui appartient la carte

    private boolean dansDeckPrincipal; // True = dans le deck principal, False = dans le deck secondaire

    public Carte() {
    }

    public Carte(Pokemon pokemon, Dresseur dresseur, boolean dansDeckPrincipal) {
        this.pokemon = pokemon;
        this.dresseur = dresseur;
        this.dansDeckPrincipal = dansDeckPrincipal;
    }

    public String getId() {
        return id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Dresseur getDresseur() {
        return dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    public boolean isDansDeckPrincipal() {
        return dansDeckPrincipal;
    }

    public void setDansDeckPrincipal(boolean dansDeckPrincipal) {
        this.dansDeckPrincipal = dansDeckPrincipal;
    }
}