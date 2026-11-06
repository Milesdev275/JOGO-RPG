package rpg.test;

import rpg.dominio.*;

// Exercício 44.
public class PocaoTest03 {
    public static void main(String[] args) {
        Heroi h = CenariosQA.heroi();
        Pocao p = new Pocao();
        p.pontosCura = 20;
        h.vida = 50;
        boolean usada = h.usarPocao(p);
        CenariosQA.verificar(usada && h.vida == 70 && h.inventario.quantidadePocoes == 1, "Ferido com poção");
        h.vida = 100;
        usada = h.usarPocao(p);
        CenariosQA.verificar(!usada && h.inventario.quantidadePocoes == 1, "Vida cheia não consome");
        h.vida = 50;
        h.inventario.quantidadePocoes = 0;
        usada = h.usarPocao(p);
        CenariosQA.verificar(!usada && h.vida == 50, "Sem poção não cura");
        h.inventario.quantidadePocoes = 1;
        h.vida = 90;
        usada = h.usarPocao(p);
        CenariosQA.verificar(usada && h.vida == 100, "Cura não ultrapassa máximo");
        h.vida = 50;
        h.inventario.quantidadePocoes = 1;
        for (int cura : new int[]{0, -10}) {
            p.pontosCura = cura;
            usada = h.usarPocao(p);
            CenariosQA.verificar(!usada && h.vida == 50 && h.inventario.quantidadePocoes == 1, "Cura inválida altera estado");
        }
        System.out.println("Os cinco cenários de poções foram aprovados.");
    }
}
