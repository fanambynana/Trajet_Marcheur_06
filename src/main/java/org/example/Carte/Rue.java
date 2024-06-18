package org.example.Carte;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Rue {
    private String nom;
    @NonNull
    private Lieu lieuA;
    @NonNull
    private Lieu lieuB;

    protected String getNom() {
        return nom;
    }

    protected void setNom(String nom) {
        this.nom = nom;
    }

    protected @NonNull Lieu getLieuA() {
        return lieuA;
    }

    protected void setLieuA(@NonNull Lieu lieuA) {
        this.lieuA = lieuA;
    }

    protected @NonNull Lieu getLieuB() {
        return lieuB;
    }

    protected void setLieuB(@NonNull Lieu lieuB) {
        this.lieuB = lieuB;
    }
}
