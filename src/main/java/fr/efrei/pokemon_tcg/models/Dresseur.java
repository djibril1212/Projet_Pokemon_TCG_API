package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dresseur {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String nom;
	private int age;
	private LocalDate dernierTirage; // Date du dernier tirage
	private LocalDateTime deletedAt; // Date de suppression

	@OneToMany
	private List<Pokemon> pokemonList; // Liste des Pokémon possédés

	public Dresseur() {
		this.pokemonList = new ArrayList<>(); // Initialisation de la liste pour éviter les erreurs
	}

	public String getUuid() {
		return uuid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDernierTirage() {
		return dernierTirage;
	}

	public void setDernierTirage(LocalDate dernierTirage) {
		this.dernierTirage = dernierTirage;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public List<Pokemon> getPokemonList() {
		return pokemonList;
	}

	public void setPokemonList(List<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}

	public void setPrenom(String prenom) {
	}
}