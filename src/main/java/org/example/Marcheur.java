package org.example;

import lombok.*;

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

    public List<Lieu> marcher(Lieu depart, Lieu arrive, Carte carte) {
        if (lieuxVisites.isEmpty()) {
            lieuxVisites.add(depart);
        }
        if (this.lieuxConnus.isEmpty()) {
            lieuxConnus.addAll(Lieu.obtenirLieuxVoisins(depart, carte));
        }

        Lieu prochainLieu = Lieu.trouverLieuAleatoire(obtenirPositionActuelle(), carte);
        lieuxVisites.add(prochainLieu);

        if (obtenirPositionActuelle().equals(arrive)) {
            return lieuxVisites;
        } else {
            return marcher(depart, arrive, carte);
        }
    }

    public Lieu obtenirPositionActuelle() {
        return new LinkedList<>(lieuxVisites).getLast();
    }
}
