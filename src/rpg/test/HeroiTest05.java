package rpg.test;

import rpg.dominio.Heroi;

// Exercício 16.
public class HeroiTest05 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.vida = 100;
        System.out.println("Vida antes: " + heroi.vida);
        heroi.receberDano(25);
        System.out.println("Vida depois de 25 de dano: " + heroi.vida);
        assert heroi.vida == 75 : "O dano deve alterar a vida do próprio herói";
        heroi.receberDano(-10);
        assert heroi.vida == 75 : "Dano negativo não pode curar o herói";
        heroi.receberDano(0);
        assert heroi.vida == 75 : "Dano zero não deve alterar a vida";
        heroi.receberDano(75);
        assert heroi.vida == 0 : "Dano igual à vida deve deixar zero";
        assert !heroi.estaVivo() : "Herói com vida zero deve estar derrotado";
        heroi.vida = 10;
        heroi.receberDano(100);
        System.out.println("Vida após dano maior que a vida: " + heroi.vida);
        assert heroi.vida == 0 : "A vida não pode ficar negativa";
    }
}
