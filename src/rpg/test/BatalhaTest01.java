package rpg.test;

import rpg.dominio.*;

// Exercício 24. Execute com -ea para habilitar as verificações.
public class BatalhaTest01 {
    public static void main(String[] args) {
        LimitesCombateTest01.main(args);
        Heroi heroi = new Heroi();
        Monstro goblin = new Monstro();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        new CadastroMonstro().cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        Batalha batalha = new Batalha();
        System.out.println("Vida antes: " + goblin.vida);
        batalha.atacarComHeroi(heroi, goblin);
        System.out.println("Vida restante: " + goblin.vida);
        assert goblin.vida == 16 : "Ataque 15 contra defesa 1 deve tirar 14 pontos";
        heroi.vida = 0;
        batalha.atacarComHeroi(heroi, goblin);
        assert goblin.vida == 16 : "Herói morto não pode atacar";
        heroi.vida = 100;
        goblin.vida = 0;
        batalha.atacarComHeroi(heroi, goblin);
        assert goblin.vida == 0 : "Não deve atacar um monstro derrotado";
        System.out.println("BatalhaTest01: verificações concluídas.");
    }
}
