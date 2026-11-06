package rpg.test;

import rpg.dominio.*;

// Objetos independentes para os testes, sem frameworks.
public class CenariosQA {
    public static Heroi heroi() {
        Heroi h = new Heroi();
        new CadastroHeroi().cadastrar(h, "Arthur", 100, 15, 5);
        return h;
    }
    public static Monstro monstro(int vida) {
        Monstro m = new Monstro();
        new CadastroMonstro().cadastrar(m, "Goblin", vida, 6, 1, 10, 20);
        return m;
    }
    public static Jogo jogo() {
        Fase[] fases = new Fase[3];
        String[] nomes = {"Floresta Sombria", "Caverna dos Ossos", "Castelo das Sombras"};
        String[] inimigos = {"Goblin", "Esqueleto", "Guardião Sombrio"};
        int[] vidas = {30, 45, 75};
        int[] ataques = {6, 9, 12};
        int[] defesas = {1, 2, 3};
        int[] ouro = {10, 20, 50};
        int[] xp = {20, 40, 100};
        for (int i = 0; i < fases.length; i++) {
            fases[i] = new Fase();
            fases[i].nome = nomes[i];
            fases[i].inimigo = new Monstro();
            new CadastroMonstro().cadastrar(fases[i].inimigo, inimigos[i], vidas[i], ataques[i], defesas[i], ouro[i], xp[i]);
        }
        Jogo jogo = new Jogo();
        jogo.configurar(heroi(), fases);
        return jogo;
    }
    public static void verificar(boolean condicao, String mensagem) {
        if (!condicao) throw new AssertionError(mensagem);
    }
}
