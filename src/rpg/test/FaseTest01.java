package rpg.test;

import rpg.dominio.Fase;
import rpg.dominio.Monstro;

// Exercício 9: uma fase referencia seu inimigo.
public class FaseTest01 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.vida = 30;
        goblin.ataque = 6;
        goblin.defesa = 1;
        goblin.ouroRecompensa = 10;
        goblin.experienciaRecompensa = 20;

        Fase floresta = new Fase();
        floresta.nome = "Floresta Sombria";
        floresta.inimigo = goblin;
        floresta.concluida = false;
        System.out.println("Fase: " + floresta.nome);
        System.out.println("Monstro encontrado: " + floresta.inimigo.nome);
        System.out.println("Concluída: " + floresta.concluida);
    }
}
