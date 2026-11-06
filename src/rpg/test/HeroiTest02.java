package rpg.test;

import rpg.dominio.Heroi;

// Exercício 11: executar com -ea para habilitar as verificações.
public class HeroiTest02 {
    public static void main(String[] args) {
        Heroi vivo = new Heroi();
        vivo.vida = 100;
        Heroi derrotado = new Heroi();
        derrotado.vida = 0;
        System.out.println("Herói com 100 de vida: " + vivo.estaVivo());
        System.out.println("Herói com 0 de vida: " + derrotado.estaVivo());
        assert vivo.estaVivo() : "Herói com vida positiva deve estar vivo";
        assert !derrotado.estaVivo() : "Herói sem vida deve estar derrotado";
        derrotado.vida = -1;
        assert !derrotado.estaVivo() : "Vida negativa também deve retornar false";
    }
}
