package org.example;

import org.example.Carte.Carte;
import lombok.*;
import org.example.Carte.Lieu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Marcheur {
    @NonNull
    private String nom;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Lieu> lieuxConnus = new ArrayList<>();
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Lieu> lieuxVisites = new ArrayList<>();

    public Lieu obtenirPositionActuelle() {
        return new LinkedList<>(lieuxVisites).getLast();
    }
    public void ajouterUnLieuVisite(Lieu lieuVisiteAjouter) {
        this.lieuxVisites.add(lieuVisiteAjouter);
    }
    public void ajouterUnLieuConnu(Lieu lieuConnusAjouter) {
        this.lieuxConnus.add(lieuConnusAjouter);
    }
    public void ajouterPlusieursLieuxConnus(List<Lieu> plusieursLieuxConnus) {
        this.lieuxConnus.addAll(plusieursLieuxConnus);
    }
}
