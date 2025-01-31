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
	private Integer age;
	private LocalDate dernierTirage;
	private LocalDateTime deletedAt;

	private Integer niveau;

	@OneToMany
	private List<Pokemon> pokemonList;

	public Dresseur() {
		this.pokemonList = new ArrayList<>();
		this.niveau = 1;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
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