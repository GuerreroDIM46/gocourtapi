package es.mde.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PRINCIPIANTE")
public class Principiante extends Jugador {

    private float puntuacionLargo, puntuacionCorto;
    
    public Principiante() {}
      
        public float getPuntuacionLargo() {
        return puntuacionLargo;
    }

    public void setPuntuacionLargo(float puntuacionLargo) {
        this.puntuacionLargo = puntuacionLargo;
    }

    public float getPuntuacionCorto() {
        return puntuacionCorto;
    }
    
    public void setPuntuacionCorto(float puntuacionCorto) {
        this.puntuacionCorto = puntuacionCorto;
    }

    public float getHandicap() {
        return (float) (72 * ((Math.log(30.0 / puntuacionLargo) + Math.log(70.0 / puntuacionCorto)) + 121));
    }
}
