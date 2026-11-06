package rpg.test;

import rpg.dominio.*;

// Exercício 29. Execute com -ea para habilitar as verificações.
public class LojaTest02 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        Arma madeira = new Arma();
        madeira.nome = "Espada de Madeira";
        madeira.bonusAtaque = 2;
        madeira.preco = 50;
        Arma ferro = new Arma();
        ferro.nome = "Espada de Ferro";
        ferro.bonusAtaque = 8;
        ferro.preco = 150;
        Loja loja = new Loja();
        System.out.println("Ataque antes: " + heroi.calcularAtaqueTotal());
        boolean comprou = loja.comprarArma(heroi, madeira);
        assert !comprou && heroi.ouro == 30 && heroi.inventario.armaEquipada == null;
        heroi.ouro = 200;
        comprou = loja.comprarArma(heroi, madeira);
        assert comprou && heroi.ouro == 150 && heroi.inventario.armaEquipada == madeira;
        assert heroi.calcularAtaqueTotal() == 17;
        comprou = loja.comprarArma(heroi, ferro);
        System.out.println("Ataque depois: " + heroi.calcularAtaqueTotal());
        assert comprou && heroi.ouro == 0 && heroi.inventario.armaEquipada == ferro;
        assert heroi.calcularAtaqueTotal() == 23 : "O bônus deve substituir o da arma anterior";
        ferro.preco = -1;
        comprou = loja.comprarArma(heroi, ferro);
        assert !comprou && heroi.ouro == 0;
        ferro.preco = Double.NaN;
        comprou = loja.comprarArma(heroi, ferro);
        assert !comprou;
        heroi.ouro = 10;
        ferro.preco = 2.5;
        comprou = loja.comprarArma(heroi, ferro);
        assert !comprou && heroi.ouro == 10 : "Preço fracionado não pode ser truncado silenciosamente";
        System.out.println("LojaTest02: verificações concluídas.");
    }
}
