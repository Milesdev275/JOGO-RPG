package rpg.test;

import rpg.dominio.*;

// Exercício 18. Execute com -ea para habilitar as verificações.
public class HeroiTest06 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        heroi.vida = 50;
        heroi.vidaMaxima = 100;
        heroi.curar(20);
        System.out.println("Depois de curar 20: " + heroi.vida);
        assert heroi.vida == 70 : "Deve recuperar os pontos de vida";
        heroi.vida = 90;
        heroi.curar(20);
        System.out.println("Cura limitada à vida máxima: " + heroi.vida);
        assert heroi.vida == 100 : "Não pode ultrapassar a vida máxima";
        heroi.vida = 60;
        heroi.curar(0);
        heroi.curar(-10);
        assert heroi.vida == 60 : "Cura inválida não deve alterar a vida";
        heroi.curar(Integer.MAX_VALUE);
        assert heroi.vida == 100 : "Cura muito grande deve respeitar o limite";
        System.out.println("HeroiTest06: verificações concluídas.");
    }
}
