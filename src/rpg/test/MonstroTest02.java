package rpg.test;

import rpg.dominio.Monstro;

// Exercício 12.
public class MonstroTest02 {
    public static void main(String[] args) {
        Monstro vivo = new Monstro();
        vivo.vida = 30;
        Monstro derrotado = new Monstro();
        derrotado.vida = 0;
        System.out.println("Monstro com 30 de vida: " + vivo.estaVivo());
        System.out.println("Monstro com 0 de vida: " + derrotado.estaVivo());
        assert vivo.estaVivo() : "Monstro com vida positiva deve estar vivo";
        assert !derrotado.estaVivo() : "Monstro sem vida deve estar derrotado";
        derrotado.vida = -1;
        assert !derrotado.estaVivo() : "Vida negativa também deve retornar false";
    }
}
