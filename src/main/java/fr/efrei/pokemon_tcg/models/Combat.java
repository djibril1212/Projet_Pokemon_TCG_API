package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Combat {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "dresseur1_id", nullable = false)
    private Dresseur dresseur1;

    @ManyToOne
    @JoinColumn(name = "dresseur2_id", nullable = false)
    private Dresseur dresseur2;

    @ManyToOne
    @JoinColumn(name = "vainqueur_id", nullable = false)
    private Dresseur vainqueur;

    @ManyToOne
    @JoinColumn(name = "carte_transferee_id", nullable = true)
    private Carte carteTransferee;

    private LocalDateTime dateCombat;

    public Combat() {
        this.dateCombat = LocalDateTime.now();
    }

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Dresseur getDresseur1() {
        return dresseur1;
    }

    public void setDresseur1(Dresseur dresseur1) {
        this.dresseur1 = dresseur1;
    }

    public Dresseur getDresseur2() {
        return dresseur2;
    }

    public void setDresseur2(Dresseur dresseur2) {
        this.dresseur2 = dresseur2;
    }

    public Dresseur getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(Dresseur vainqueur) {
        this.vainqueur = vainqueur;
    }

    public Carte getCarteTransferee() {
        return carteTransferee;
    }

    public void setCarteTransferee(Carte carteTransferee) {
        this.carteTransferee = carteTransferee;
    }

    public LocalDateTime getDateCombat() {
        return dateCombat;
    }
}