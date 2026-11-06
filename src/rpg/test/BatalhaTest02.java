package rpg.test;

import rpg.dominio.*;

// Exercício 25. Execute com -ea para habilitar as verificações.
public class BatalhaTest02 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        Monstro goblin = new Monstro();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        new CadastroMonstro().cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        Batalha batalha = new Batalha();
        batalha.atacarComHeroi(heroi, goblin);
        batalha.atacarComMonstro(goblin, heroi);
        new ImpressoraRPG().imprimirHeroi(heroi);
        assert goblin.vida == 16 && heroi.vida == 99 : "Os dois ataques devem alterar seus alvos";
        goblin.vida = 0;
        batalha.atacarComMonstro(goblin, heroi);
        assert heroi.vida == 99 : "Monstro morto não pode atacar";
        goblin.vida = 30;
        heroi.vida = 0;
        batalha.atacarComMonstro(goblin, heroi);
        assert heroi.vida == 0 : "Não deve atacar herói derrotado";
        System.out.println("BatalhaTest02: verificações concluídas.");
    }
}
