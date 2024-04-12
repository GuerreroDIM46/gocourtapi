package es.mde.entidades;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FEDERADO")
public class Federado extends Jugador {
    
    private boolean profesional;
    private float handicap;    
    
    public Federado() {}

    public boolean isProfesional() {
        return profesional;
    }

    public void setProfesional(boolean profesional) {
        this.profesional = profesional;
    }

    public float getHandicap() {
        return handicap;
    }

    public void setHandicap(float handicap) {
        this.handicap = handicap;
    }
    
    public void calcularHandicap() {
        // Obtener los últimos 20 resultados del jugador
        List<Puntuacion> ultimosResultados = this.getPuntuaciones().stream()
                .sorted(Comparator.comparing(Puntuacion::getPartidoTimestamp))
                .limit(20)
                .collect(Collectors.toList());
        
        // Filtrar los 8 mejores resultados
        List<Puntuacion> mejoresResultados = ultimosResultados.stream()
                .sorted(Comparator.comparing(Puntuacion::getPuntuacion))
                .limit(8)
                .collect(Collectors.toList());
        
        // Calcular el promedio de los 8 mejores resultados ajustados con el rating y el slope del campo
        handicap = (float) mejoresResultados.stream()
                .mapToDouble(puntuacion -> {
                    float ajuste = (puntuacion.getPuntuacion() - puntuacion.getPartido().getCampo().getValorCampo()) * 113 
                                   / puntuacion.getPartido().getCampo().getValorSlope();
                    return puntuacion.getPuntuacion() + ajuste;
                })
                .average()
                .orElse(0);
    }
        
}
