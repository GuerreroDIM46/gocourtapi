package es.mde.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PUNTUACIONES")
public class Puntuacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)  
    private Long id;
    
    float puntuacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JUGADOR")
    private Jugador jugador;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTIDO")
    private Partido partido;
    
    public Puntuacion() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }
    
    public LocalDateTime getPartidoTimestamp() {
        return partido.getTimeDate();
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
