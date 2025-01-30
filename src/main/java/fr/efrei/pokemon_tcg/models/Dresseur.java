package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Dresseur {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String nom;
	private int age;

	private LocalDate dernierTirage; // Date du dernier tirage

	public Dresseur() {
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
}