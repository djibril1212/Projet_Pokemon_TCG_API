package fr.efrei.pokemon_tcg.services.implementations;
import fr.efrei.pokemon_tcg.services.CombatService;
import org.springframework.stereotype.Service;
import fr.efrei.pokemon_tcg.models.Dresseur;

import fr.efrei.pokemon_tcg.repositories.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class CombatServiceImpl implements CombatService {

    @Autowired
    private CombatRepository combatRepository;

    @Override
    public String initierCombat(String dresseur1Uuid, String dresseur2Uuid) {

        if (dresseur1Uuid == null || dresseur2Uuid == null) {
            throw new IllegalArgumentException("Les UUID des dresseurs ne peuvent pas être null.");
        }


        // Logique pour commencer le combat
        return "Combat entre le dresseur " + dresseur1Uuid + " et le dresseur " + dresseur2Uuid + " initié.";
    }

    @Override
    public int calculerDegats(Dresseur attaquant) {
        if (attaquant == null) {
            throw new IllegalArgumentException("Le dresseur attaquant ne peut pas être null.");
        }

        // Exemple de logique pour calculer les dégâts
        int degats = attaquant.getNiveau() * 2; // Les dégâts sont proportionnels au niveau du dresseur
        return Math.max(degats, 1); // Assurez-vous que les dégâts soient au moins de 1
    }

    @Override
    public String determinerVainqueur(Dresseur dresseur1, Dresseur dresseur2) {
        if (dresseur1 == null || dresseur2 == null) {
            throw new IllegalArgumentException("Les dresseurs ne peuvent pas être null.");
        }

        // début de logique pour déterminer le vainqueur
        int puissanceDresseur1 = dresseur1.getNiveau() * 3; // Puissance calculée en fonction du niveau
        int puissanceDresseur2 = dresseur2.getNiveau() * 3;

        if (puissanceDresseur1 > puissanceDresseur2) {
            return dresseur1.getNom(); // Dresseur1 est le gagnant
        } else if (puissanceDresseur1 < puissanceDresseur2) {
            return dresseur2.getNom(); // Dresseur2 est le gagnant
        } else {
            return "Égalité"; // Si les deux ont la même puissance
        }
    }

    @Override
    public void mettreAJourDresseurs(Dresseur gagnant, Dresseur perdant) {
        if (gagnant == null || perdant == null) {
            throw new IllegalArgumentException("Les dresseurs gagnant et perdant ne peuvent pas être null.");
        }

        // Logique pour mettre à jour les dresseurs après le combat
        gagnant.setNiveau(gagnant.getNiveau() + 1); // Le gagnant gagne un niveau
        perdant.setNiveau(Math.max(1, perdant.getNiveau() - 1)); // Le perdant perd un niveau, mais ne peut pas aller en dessous de 1

    }
}