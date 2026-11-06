package rpg.test;

import rpg.dominio.Monstro;

// Exercício 17: ataques até a vida chegar a zero.
public class MonstroTest04 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.vida = 30;
        System.out.println("Vida inicial: " + goblin.vida);
        goblin.receberDano(-10);
        assert goblin.vida == 30 : "Dano negativo não pode curar o monstro";
        goblin.receberDano(0);
        assert goblin.vida == 30 : "Dano zero não deve alterar a vida";

        while (goblin.estaVivo()) {
            int vidaAntes = goblin.vida;
            goblin.receberDano(12);
            System.out.println("Vida antes: " + vidaAntes + " | Depois: " + goblin.vida);
        }
        System.out.println("Monstro está vivo? " + goblin.estaVivo());
        assert goblin.vida == 0 : "A vida deve parar em zero, mesmo com dano excedente";
        assert !goblin.estaVivo() : "Monstro com vida zero deve estar derrotado";
        goblin.receberDano(12);
        assert goblin.vida == 0 : "Monstro derrotado não deve ficar com vida negativa";
        goblin.vida = 30;
        goblin.receberDano(30);
        assert goblin.vida == 0 : "Dano igual à vida deve deixar zero";
    }
}
