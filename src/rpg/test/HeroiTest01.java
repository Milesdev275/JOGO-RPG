package rpg.test;

import rpg.dominio.Heroi;

// Exercício 3: dois objetos com todos os atributos preenchidos e exibidos.
public class HeroiTest01 {
    public static void main(String[] args) {
        Heroi arthur = new Heroi();
        arthur.nome = "Arthur";
        arthur.vida = 100;
        arthur.vidaMaxima = 100;
        arthur.ataque = 15;
        arthur.defesa = 5;
        arthur.nivel = 1;
        arthur.experiencia = 0;
        arthur.ouro = 30;

        Heroi luna = new Heroi();
        luna.nome = "Luna";
        luna.vida = 80;
        luna.vidaMaxima = 80;
        luna.ataque = 20;
        luna.defesa = 3;
        luna.nivel = 2;
        luna.experiencia = 10;
        luna.ouro = 50;

        System.out.printf("Herói: %s | Vida: %d/%d | Ataque: %d | Defesa: %d | Nível: %d | Experiência: %d | Ouro: %d%n",
                arthur.nome, arthur.vida, arthur.vidaMaxima, arthur.ataque, arthur.defesa,
                arthur.nivel, arthur.experiencia, arthur.ouro);
        System.out.printf("Herói: %s | Vida: %d/%d | Ataque: %d | Defesa: %d | Nível: %d | Experiência: %d | Ouro: %d%n",
                luna.nome, luna.vida, luna.vidaMaxima, luna.ataque, luna.defesa,
                luna.nivel, luna.experiencia, luna.ouro);
    }
}
