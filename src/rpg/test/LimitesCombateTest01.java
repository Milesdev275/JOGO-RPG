package rpg.test;

import rpg.dominio.*;

// Exercício 47.
public class LimitesCombateTest01 {
    public static void main(String[] args) {
        int[] vidasHeroi = {100, 1, 100, 0, 100};
        int[] vidasMonstro = {30, 30, 1, 30, 0};
        int[] esperadoHeroi = {99, 0, 100, 0, 100};
        int[] esperadoMonstro = {16, 16, 0, 30, 0};
        for (int i = 0; i < vidasHeroi.length; i++) {
            Heroi h = CenariosQA.heroi();
            h.vida = vidasHeroi[i];
            Monstro m = CenariosQA.monstro(vidasMonstro[i]);
            new Batalha().executarTurno(h, m);
            CenariosQA.verificar(h.vida == esperadoHeroi[i] && m.vida == esperadoMonstro[i], "Falha na matriz de combate: " + i);
            CenariosQA.verificar(h.calcularDano(999) == 1 && m.calcularDano(999) == 1, "Dano mínimo incorreto");
            CenariosQA.verificar(h.vida >= 0 && m.vida >= 0, "Vida negativa");
        }
    }
}
