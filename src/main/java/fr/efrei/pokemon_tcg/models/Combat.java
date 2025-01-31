package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "dresseur1_id", nullable = false)
    private Dresseur dresseur1;

    @ManyToOne
    @JoinColumn(name = "dresseur2_id", nullable = false)
    private Dresseur dresseur2;

    @ManyToOne
    @JoinColumn(name = "gagnant_id")
    private Dresseur gagnant;

    private LocalDateTime dateCombat;

    public Combat() {
        this.dateCombat = LocalDateTime.now(); // Définit la date du combat automatiquement
    }

    public String getUuid() {
        return uuid;
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

    public Dresseur getGagnant() {
        return gagnant;
    }

    public void setGagnant(Dresseur gagnant) {
        this.gagnant = gagnant;
    }

    public LocalDateTime getDateCombat() {
        return dateCombat;
    }
}