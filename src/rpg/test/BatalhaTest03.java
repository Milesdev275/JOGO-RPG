package rpg.test;

import rpg.dominio.*;

// Exercício 26. Execute com -ea para habilitar as verificações.
public class BatalhaTest03 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        Monstro goblin = new Monstro();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        new CadastroMonstro().cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        Batalha batalha = new Batalha();
        int turnos = 0;
        while (heroi.estaVivo() && goblin.estaVivo()) {
            batalha.executarTurno(heroi, goblin);
            turnos++;
        }
        assert turnos == 3 : "O Goblin deve cair no terceiro ataque";
        assert heroi.vida == 98 : "O monstro só deve contra-atacar nos dois primeiros turnos";
        assert goblin.vida == 0;

        Heroi fragil = new Heroi();
        Monstro forte = new Monstro();
        new CadastroHeroi().cadastrar(fragil, "Luna", 1, 1, 0);
        new CadastroMonstro().cadastrar(forte, "Esqueleto", 45, 9, 2, 20, 40);
        while (fragil.estaVivo() && forte.estaVivo()) {
            batalha.executarTurno(fragil, forte);
        }
        assert fragil.vida == 0 && forte.vida == 44 : "O monstro deve poder vencer";
        batalha.executarTurno(fragil, forte);
        assert forte.vida == 44 : "Personagem derrotado não deve executar outro turno";
        System.out.println("BatalhaTest03: verificações concluídas.");
    }
}
