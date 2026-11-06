package rpg.test;

import rpg.dominio.*;

// Exercício 46.
public class ReferenciaTest01 {
    public static void main(String[] args) {
        Heroi h = CenariosQA.heroi();
        Monstro original = CenariosQA.monstro(30);
        Monstro outraReferencia = original;
        System.out.println("Vida antes: " + original.vida);
        new Batalha().atacarComHeroi(h, original);
        System.out.println("Vida depois: " + original.vida);
        System.out.println("Vida pela outra referência: " + outraReferencia.vida);
        CenariosQA.verificar(original == outraReferencia && original.vida == 16 && outraReferencia.vida == 16,
                "As referências devem enxergar o mesmo objeto");
    }
}
