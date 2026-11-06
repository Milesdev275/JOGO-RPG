package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.Heroi;
import rpg.dominio.Inventario;

// Exercício 13.
public class HeroiTest03 {
    public static void main(String[] args) {
        Arma espada = new Arma();
        espada.nome = "Espada de Ferro";
        espada.bonusAtaque = 8;
        Heroi comArma = new Heroi();
        comArma.ataque = 15;
        comArma.inventario = new Inventario();
        comArma.inventario.armaEquipada = espada;
        Heroi semArma = new Heroi();
        semArma.ataque = 20;
        semArma.inventario = new Inventario();

        System.out.println("Ataque com arma: " + comArma.calcularAtaqueTotal());
        System.out.println("Ataque sem arma: " + semArma.calcularAtaqueTotal());
        assert comArma.calcularAtaqueTotal() == 23 : "Deve somar o bônus da arma";
        assert semArma.calcularAtaqueTotal() == 20 : "Sem arma, deve usar apenas o ataque básico";
        semArma.inventario = null;
        assert semArma.calcularAtaqueTotal() == 20 : "Sem inventário, deve usar o ataque básico";
    }
}
