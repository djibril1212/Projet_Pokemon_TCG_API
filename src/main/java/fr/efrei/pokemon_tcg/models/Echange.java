package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Echange {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "dresseur1_id", nullable = false)
    private Dresseur dresseur1;

    @ManyToOne
    @JoinColumn(name = "dresseur2_id", nullable = false)
    private Dresseur dresseur2;

    @ManyToOne
    @JoinColumn(name = "carte1_id", nullable = false)
    private Carte carte1;

    @ManyToOne
    @JoinColumn(name = "carte2_id", nullable = false)
    private Carte carte2;

    private LocalDateTime dateEchange;

    public Echange() {
        this.dateEchange = LocalDateTime.now();
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

    public Carte getCarte1() {
        return carte1;
    }

    public void setCarte1(Carte carte1) {
        this.carte1 = carte1;
    }

    public Carte getCarte2() {
        return carte2;
    }

    public void setCarte2(Carte carte2) {
        this.carte2 = carte2;
    }

    public LocalDateTime getDateEchange() {
        return dateEchange;
    }

    public void setDateEchange(LocalDateTime dateEchange) {
        this.dateEchange = dateEchange;
    }
}