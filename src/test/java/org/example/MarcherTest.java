package org.example;

import org.example.Carte.Carte;
import org.example.Carte.Lieu;
import org.example.Carte.Rue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class MarcherTest {
    static Lieu lieuMarais = new Lieu("Marais");
    static Lieu lieuSekolintsika = new Lieu("Sekolintsika");
    static Lieu lieuHei = new Lieu("HEI");
    static Lieu lieuPullman = new Lieu("Pullman");
    static Lieu lieuNexta = new Lieu("Nexta");
    static Lieu lieuBalancoire = new Lieu("Balancoire");
    static Lieu lieuEsti = new Lieu("ESTI");
    static Lieu lieuBoulevard = new Lieu("Boulevard de l'Europe");

    static Rue rueRanaivo = new Rue("Ranaivo", lieuPullman, lieuBalancoire);
    static Rue rueAndriatsihoarana = new Rue("Andriatsihoarana", lieuHei, lieuPullman);
    static Rue rue01 = new Rue(lieuMarais, lieuSekolintsika);
    static Rue rue02 = new Rue(lieuSekolintsika, lieuHei);
    static Rue rue03 = new Rue(lieuPullman, lieuNexta);
    static Rue rue04 = new Rue(lieuBalancoire, lieuBoulevard);
    static Rue rue05 = new Rue(lieuBalancoire, lieuEsti);
    static Rue rue06 = new Rue(lieuBoulevard, lieuEsti);
    static Rue rue07 = new Rue(lieuBalancoire, lieuHei);

    static Carte carte = new Carte(
            List.of(
                    lieuMarais,
                    lieuEsti,
                    lieuBalancoire,
                    lieuBoulevard,
                    lieuNexta,
                    lieuPullman,
                    lieuSekolintsika,
                    lieuHei
            ),
            List.of(
                    rueRanaivo,
                    rueAndriatsihoarana,
                    rue01,
                    rue02,
                    rue03,
                    rue04,
                    rue05,
                    rue06,
                    rue07
            )
    );

    static Marcheur marcheurBjarni = new Marcheur(" Bjarni");

    @Test
    void BjarniMarcheDepuisHeiVersEsti() {
        Marcher BjarniMarcher = new Marcher();
        List<Lieu> trajet = BjarniMarcher.marcher(marcheurBjarni, lieuHei, lieuEsti, carte);

        Assertions.assertNotNull(trajet);
        Assertions.assertFalse(trajet.isEmpty());
        Assertions.assertTrue(trajet.size() >= 3);
        Assertions.assertEquals(lieuHei, new LinkedList<>(trajet).getFirst());
        Assertions.assertEquals(lieuEsti, new LinkedList<>(trajet).getLast());
        Assertions.assertTrue(trajet.contains(lieuBalancoire));
    }

    @Test
    void retournerLieuAleatoirePresDeHei() {
        Lieu lieuAleatoire = Lieu.trouverLieuAleatoire(new Lieu("HEI"), carte);

        Assertions.assertNotNull(lieuAleatoire);
    }

    @Test
    void retournerLieuxVoisinsDeHei() {
        List<Lieu> lieuxVoisins = Lieu.obtenirLieuxVoisins(new Lieu("HEI"), carte);
        int nombreLieuxVoisins = 3;

        Assertions.assertNotNull(lieuxVoisins);
        Assertions.assertFalse(lieuxVoisins.isEmpty());
        Assertions.assertEquals(nombreLieuxVoisins, lieuxVoisins.size());
    }
}
