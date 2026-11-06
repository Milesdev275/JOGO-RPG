package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.Heroi;
import rpg.dominio.Inventario;

// Exercício 8: referências entre herói, inventário e arma.
public class InventarioTest01 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        Inventario inventario = new Inventario();
        Arma espada = new Arma();
        espada.nome = "Espada de Madeira";
        espada.bonusAtaque = 2;
        espada.preco = 50;
        inventario.armaEquipada = espada;
        inventario.quantidadePocoes = 2;
        heroi.inventario = inventario;

        System.out.println("Arma equipada: " + heroi.inventario.armaEquipada.nome);
        System.out.println("Quantidade de poções: " + heroi.inventario.quantidadePocoes);
    }
}
