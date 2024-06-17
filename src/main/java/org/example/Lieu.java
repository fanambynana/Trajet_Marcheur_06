package org.example;

import lombok.*;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lieu {
    private String nom;

    public static Lieu trouverLieuAleatoire(Lieu presDe, Carte carte) {
        List<Lieu> lieuxVoisins = obtenirLieuxVoisins(presDe, carte);

        Random random = new Random();

        int randomIndex = random.nextInt(lieuxVoisins.size());
        return lieuxVoisins.get(randomIndex);
    }

    public static List<Lieu> obtenirLieuxVoisins(Lieu presDe, Carte carte) {
        return carte.getRues()
                .stream().filter(rue -> rue.getLieuA().equals(presDe) || rue.getLieuB().equals(presDe))
                .map((rue -> {
                    if (rue.getLieuA().equals(presDe)) {
                        return rue.getLieuB();
                    } else {
                        return rue.getLieuA();
                    }
                })).toList();
    }
}
