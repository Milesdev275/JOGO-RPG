package rpg.test;

import rpg.dominio.*;

// Exercício 21. Execute com -ea para habilitar as verificações.
public class ImpressoraRPGTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        Heroi arthur = new Heroi();
        Heroi luna = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);
        cadastroHeroi.cadastrar(luna, "Luna", 80, 20, 3);
        CadastroMonstro cadastroMonstro = new CadastroMonstro();
        Monstro goblin = new Monstro();
        Monstro esqueleto = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        cadastroMonstro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 20, 40);

        ImpressoraRPG impressora = new ImpressoraRPG();
        impressora.imprimirHeroi(arthur);
        impressora.imprimirHeroi(luna);
        impressora.imprimirMonstro(goblin);
        impressora.imprimirMonstro(esqueleto);
        assert arthur.vida == 100 && luna.vida == 80 : "Imprimir não deve mudar os heróis";
        assert goblin.vida == 30 && esqueleto.vida == 45 : "Imprimir não deve mudar os monstros";
        System.out.println("ImpressoraRPGTest01: verificações concluídas.");
    }
}
