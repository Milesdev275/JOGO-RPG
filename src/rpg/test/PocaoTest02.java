package rpg.test;

import rpg.dominio.*;

// Exercício 27. Execute com -ea para habilitar as verificações.
public class PocaoTest02 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        Pocao pocao = new Pocao();
        pocao.nome = "Poção Pequena";
        pocao.pontosCura = 20;
        pocao.preco = 10;
        heroi.vida = 70;
        boolean usada = heroi.usarPocao(pocao);
        System.out.println("Usou poção: " + usada + " | Vida: " + heroi.vida);
        assert usada && heroi.vida == 90 && heroi.inventario.quantidadePocoes == 1;
        usada = heroi.usarPocao(pocao);
        assert usada && heroi.vida == 100 && heroi.inventario.quantidadePocoes == 0;
        usada = heroi.usarPocao(pocao);
        assert !usada && heroi.vida == 100 && heroi.inventario.quantidadePocoes == 0;
        heroi.inventario.quantidadePocoes = 2;
        usada = heroi.usarPocao(pocao);
        assert !usada && heroi.inventario.quantidadePocoes == 2 : "Vida completa não consome poção";
        heroi.vida = 50;
        heroi.inventario.quantidadePocoes = 0;
        usada = heroi.usarPocao(pocao);
        assert !usada && heroi.vida == 50 : "Sem poções não deve curar";
        heroi.inventario.quantidadePocoes = 1;
        pocao.pontosCura = -10;
        usada = heroi.usarPocao(pocao);
        assert !usada && heroi.vida == 50 && heroi.inventario.quantidadePocoes == 1;
        usada = heroi.usarPocao(null);
        assert !usada && heroi.inventario.quantidadePocoes == 1;
        System.out.println("PocaoTest02: verificações concluídas.");
    }
}
