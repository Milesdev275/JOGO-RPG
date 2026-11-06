package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.Heroi;
import rpg.dominio.Inventario;

// Exercício 14.
public class HeroiTest04 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.ataque = 15;
        System.out.println("Ataque 15, defesa 3: " + heroi.calcularDano(3));
        System.out.println("Ataque 15, defesa 15: " + heroi.calcularDano(15));
        System.out.println("Ataque 15, defesa 30: " + heroi.calcularDano(30));
        assert heroi.calcularDano(3) == 12 : "15 - 3 deve resultar em 12";
        assert heroi.calcularDano(15) == 1 : "Defesa igual ao ataque deve causar dano mínimo";
        assert heroi.calcularDano(30) == 1 : "Defesa maior que o ataque deve causar dano mínimo";
        heroi.inventario = new Inventario();
        heroi.inventario.armaEquipada = new Arma();
        heroi.inventario.armaEquipada.bonusAtaque = 8;
        assert heroi.calcularDano(3) == 20 : "O dano deve considerar o bônus da arma";
    }
}
