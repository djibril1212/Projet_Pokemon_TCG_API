package fr.efrei.pokemon_tcg.models;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import jakarta.persistence.*;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid; // Identifiant unique pour chaque Pokémon

	private String nom; // Nom du Pokémon
	private Integer niveau; // Niveau du Pokémon

	@Enumerated(EnumType.STRING) // Enum pour le type du Pokémon
	private TypePokemon type;

	private String attaque1; // Première attaque du Pokémon
	private String attaque2; // Deuxième attaque du Pokémon

	private int rarete; // Niveau de rareté du Pokémon (1 à 5)

	// Getters et Setters pour chaque champ
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public TypePokemon getType() {
		return type;
	}

	public void setType(TypePokemon type) {
		this.type = type;
	}

	public String getAttaque1() {
		return attaque1;
	}

	public void setAttaque1(String attaque1) {
		this.attaque1 = attaque1;
	}

	public String getAttaque2() {
		return attaque2;
	}

	public void setAttaque2(String attaque2) {
		this.attaque2 = attaque2;
	}

	public int getRarete() {
		return rarete;
	}

	public void setRarete(int rarete) {
		this.rarete = rarete;
	}
}