package rpg.test;

import rpg.dominio.*;

// Exercício 28. Execute com -ea para habilitar as verificações.
public class LojaTest01 {
    public static void main(String[] args) {
        LojaTest02.main(args);
        Heroi heroi = new Heroi();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        Pocao pocao = new Pocao();
        pocao.nome = "Poção Pequena";
        pocao.pontosCura = 20;
        pocao.preco = 10;
        Loja loja = new Loja();
        boolean comprou = loja.comprarPocao(heroi, pocao);
        System.out.println("Comprou: " + comprou + " | Ouro: " + heroi.ouro + " | Poções: " + heroi.inventario.quantidadePocoes);
        assert comprou && heroi.ouro == 20 && heroi.inventario.quantidadePocoes == 3;
        heroi.ouro = 5;
        comprou = loja.comprarPocao(heroi, pocao);
        assert !comprou && heroi.ouro == 5 && heroi.inventario.quantidadePocoes == 3;
        heroi.ouro = 10;
        comprou = loja.comprarPocao(heroi, pocao);
        assert comprou && heroi.ouro == 0 && heroi.inventario.quantidadePocoes == 4;
        pocao.preco = -10;
        comprou = loja.comprarPocao(heroi, pocao);
        assert !comprou && heroi.ouro == 0 && heroi.inventario.quantidadePocoes == 4;
        System.out.println("LojaTest01: verificações concluídas.");
    }
}
