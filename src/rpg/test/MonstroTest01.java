package rpg.test;

import rpg.dominio.Monstro;

// Exercício 5: monstros e suas recompensas.
public class MonstroTest01 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.vida = 30;
        goblin.ataque = 6;
        goblin.defesa = 1;
        goblin.ouroRecompensa = 10;
        goblin.experienciaRecompensa = 20;

        Monstro esqueleto = new Monstro();
        esqueleto.nome = "Esqueleto";
        esqueleto.vida = 45;
        esqueleto.ataque = 9;
        esqueleto.defesa = 2;
        esqueleto.ouroRecompensa = 20;
        esqueleto.experienciaRecompensa = 40;

        Monstro guardiaoSombrio = new Monstro();
        guardiaoSombrio.nome = "Guardião Sombrio";
        guardiaoSombrio.vida = 75;
        guardiaoSombrio.ataque = 12;
        guardiaoSombrio.defesa = 3;
        guardiaoSombrio.ouroRecompensa = 50;
        guardiaoSombrio.experienciaRecompensa = 100;

        System.out.printf("%s | Vida: %d | Ataque: %d | Defesa: %d | Ouro: %d | Experiência: %d%n",
                goblin.nome, goblin.vida, goblin.ataque, goblin.defesa, goblin.ouroRecompensa, goblin.experienciaRecompensa);
        System.out.printf("%s | Vida: %d | Ataque: %d | Defesa: %d | Ouro: %d | Experiência: %d%n",
                esqueleto.nome, esqueleto.vida, esqueleto.ataque, esqueleto.defesa, esqueleto.ouroRecompensa, esqueleto.experienciaRecompensa);
        System.out.printf("%s | Vida: %d | Ataque: %d | Defesa: %d | Ouro: %d | Experiência: %d%n",
                guardiaoSombrio.nome, guardiaoSombrio.vida, guardiaoSombrio.ataque, guardiaoSombrio.defesa,
                guardiaoSombrio.ouroRecompensa, guardiaoSombrio.experienciaRecompensa);
    }
}
