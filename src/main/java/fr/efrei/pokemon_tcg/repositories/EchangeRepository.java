package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.models.Echange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EchangeRepository extends JpaRepository<Echange, String> {
    List<Echange> findByDresseur1AndDateEchangeAfter(Dresseur dresseur, LocalDateTime date);
    List<Echange> findByDresseur2AndDateEchangeAfter(Dresseur dresseur, LocalDateTime date);
}