package org.example;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Rue {
    private String nom;
    @NonNull
    private Lieu lieuA;
    @NonNull
    private Lieu lieuB;
}
