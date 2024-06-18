package org.example.Carte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Carte {
    private List<Lieu> lieux;
    private List<Rue> rues;

    protected List<Lieu> getLieux() {
        return lieux;
    }

    protected void setLieux(List<Lieu> lieux) {
        this.lieux = lieux;
    }

    protected List<Rue> getRues() {
        return rues;
    }

    protected void setRues(List<Rue> rues) {
        this.rues = rues;
    }

    protected void ajouterUnLieu(Lieu lieuAjouter) {
        this.lieux.add(lieuAjouter);
    }
    protected void ajouterUneRue(Rue rueAjouter) {
        this.rues.add(rueAjouter);
    }
}
