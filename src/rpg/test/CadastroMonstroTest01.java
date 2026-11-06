package rpg.test;

import rpg.dominio.*;

// Exercício 23. Execute com -ea para habilitar as verificações.
public class CadastroMonstroTest01 {
    public static void main(String[] args) {
        CadastroMonstro cadastro = new CadastroMonstro();
        Monstro goblin = new Monstro();
        Monstro esqueleto = new Monstro();
        Monstro guardiao = new Monstro();
        cadastro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        cadastro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 20, 40);
        cadastro.cadastrar(guardiao, "Guardião Sombrio", 75, 12, 3, 50, 100);
        ImpressoraRPG impressora = new ImpressoraRPG();
        impressora.imprimirMonstro(goblin);
        impressora.imprimirMonstro(esqueleto);
        impressora.imprimirMonstro(guardiao);
        assert goblin.nome.equals("Goblin") && goblin.vida == 30 && goblin.ataque == 6 && goblin.defesa == 1;
        assert goblin.ouroRecompensa == 10 && goblin.experienciaRecompensa == 20;
        assert esqueleto.nome.equals("Esqueleto") && esqueleto.vida == 45 && esqueleto.ataque == 9 && esqueleto.defesa == 2;
        assert esqueleto.ouroRecompensa == 20 && esqueleto.experienciaRecompensa == 40;
        assert guardiao.nome.equals("Guardião Sombrio") && guardiao.vida == 75 && guardiao.ataque == 12 && guardiao.defesa == 3;
        assert guardiao.ouroRecompensa == 50 && guardiao.experienciaRecompensa == 100;
        System.out.println("CadastroMonstroTest01: verificações concluídas.");
    }
}
