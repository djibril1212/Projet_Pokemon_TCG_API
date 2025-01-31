package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Dresseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DresseurRepository extends JpaRepository<Dresseur, String> {
	List<Dresseur> findAllByDeletedAtNull();
	Optional<Dresseur> findByUuid(String uuid);
}