package rpg.test;

import rpg.dominio.Arma;

public class ArmaTest01 {
    public static void main(String[] args) {
        Arma espadaMadeira = new Arma();
        Arma espadaMetal = new Arma();

        espadaMadeira.nome = "Espada de Madeira";
        espadaMadeira.bonusAtaque = 2;
        espadaMadeira.preco = 50;

        espadaMetal.nome = "Espada de Ferro";
        espadaMetal.bonusAtaque = 8;
        espadaMetal.preco = 150;

        System.out.printf("""
                %s
                [Bonus Ataque] - %d
                [Preco] - %.2f 
         
                """, espadaMadeira.nome, espadaMadeira.bonusAtaque, espadaMadeira.preco);

        System.out.println("-----------------------------");

        System.out.printf("""
                %s
                [Bonus Ataque] - %d
                [Preco] - %.2f 
         
                """, espadaMetal.nome, espadaMetal.bonusAtaque, espadaMetal.preco);
    }
}
