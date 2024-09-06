package br.com.fiap.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Disciplina {

    public Double media1Semestre;
    public Double mediaCPs;
    public Double notaChallenge;
    public Double notaGS;

    public Double calcularMediaFianl() {
        Double mediaFinal = media1Semestre * 0.4 + (mediaCPs * 0.2 + notaChallenge * 0.2 + notaGS * 0.6) * 0.6;
        return mediaFinal;
    }
}
