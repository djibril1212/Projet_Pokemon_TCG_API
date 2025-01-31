package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Combat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatRepository extends JpaRepository<Combat, String> {
}