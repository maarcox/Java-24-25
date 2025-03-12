package interfaces;

import Personajes.Enano;
import Personajes.WarhamerPersonaje;
import armas.interfaces.ArmaAtaque;

public interface ICombate{
    void atacar(WarhamerPersonaje victima);
    void defender(ArmaAtaque arma);
}
