package rpg.test;

import rpg.dominio.Monstro;

// Exercício 15.
public class MonstroTest03 {
    public static void main(String[] args) {
        Monstro monstro = new Monstro();
        monstro.ataque = 6;
        System.out.println("Ataque 6, defesa 0: " + monstro.calcularDano(0));
        System.out.println("Ataque 6, defesa 2: " + monstro.calcularDano(2));
        System.out.println("Ataque 6, defesa 6: " + monstro.calcularDano(6));
        System.out.println("Ataque 6, defesa 20: " + monstro.calcularDano(20));
        assert monstro.calcularDano(0) == 6 : "Sem defesa, deve causar o ataque básico";
        assert monstro.calcularDano(2) == 4 : "6 - 2 deve resultar em 4";
        assert monstro.calcularDano(6) == 1 : "Defesa igual ao ataque deve causar dano mínimo";
        assert monstro.calcularDano(20) == 1 : "Defesa maior deve causar dano mínimo";
    }
}
