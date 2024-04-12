package es.mde.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARTIDOS")
public class Partido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)  
    private Long id;
    
    private LocalDateTime timeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAMPO")
    private Campo campo;
        
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Puntuacion.class, mappedBy = "partido")
    private Collection<Puntuacion> puntuaciones = new ArrayList<>();
    
    public Partido() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalDateTime timeDate) {
        this.timeDate = timeDate;
    }

    public Campo getCampo() {
        return campo;
    }
    
    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Collection<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }
    
    public void addPuntuacion(Puntuacion puntuacion) {
        getPuntuaciones().add(puntuacion);
        puntuacion.setPartido(this);
    }

}
