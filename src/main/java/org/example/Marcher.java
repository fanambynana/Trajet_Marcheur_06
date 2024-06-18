package org.example;

import org.example.Carte.Carte;
import org.example.Carte.Lieu;

import java.util.List;

public class Marcher {
    public List<Lieu> marcher(Marcheur marcheur, Lieu depart, Lieu arrive, Carte carte) {
        if (marcheur.getLieuxVisites().isEmpty()) {
            marcheur.ajouterUnLieuVisite(depart);
        }
        if (marcheur.getLieuxConnus().isEmpty()) {
            marcheur.ajouterPlusieursLieuxConnus(Lieu.obtenirLieuxVoisins(depart, carte));
        }

        Lieu prochainLieu = Lieu.trouverLieuAleatoire(marcheur.obtenirPositionActuelle(), carte);
        marcheur.ajouterUnLieuVisite(prochainLieu);

        if (marcheur.obtenirPositionActuelle().equals(arrive)) {
            return marcheur.getLieuxVisites();
        } else {
            return marcher(marcheur, depart, arrive, carte);
        }
    }
}
