package fr.efrei.pokemon_tcg.services;
import fr.efrei.pokemon_tcg.models.Dresseur;

public interface CombatService {
    String initierCombat(String dresseur1Uuid, String dresseur2Uuid);

    int calculerDegats(Dresseur attaquant);

    String determinerVainqueur(Dresseur dresseur1, Dresseur dresseur2);

    void mettreAJourDresseurs(Dresseur gagnant, Dresseur perdant);
}