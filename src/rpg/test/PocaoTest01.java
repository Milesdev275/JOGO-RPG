package rpg.test;

import rpg.dominio.Pocao;

// Exercício 7: neste ponto apenas criamos e exibimos as poções.
public class PocaoTest01 {
    public static void main(String[] args) {
        PocaoTest03.main(args);
        Pocao pequena = new Pocao();
        pequena.nome = "Poção Pequena";
        pequena.pontosCura = 20;
        pequena.preco = 10;

        Pocao grande = new Pocao();
        grande.nome = "Poção Grande";
        grande.pontosCura = 50;
        grande.preco = 25;

        System.out.printf("%s | Cura: %d | Preço: %d%n", pequena.nome, pequena.pontosCura, pequena.preco);
        System.out.printf("%s | Cura: %d | Preço: %d%n", grande.nome, grande.pontosCura, grande.preco);
    }
}
