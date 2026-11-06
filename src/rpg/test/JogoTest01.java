package rpg.test;

import java.util.Scanner;
import rpg.dominio.*;

// Exercícios 32 e 50: ponto de entrada do RPG completo.
public class JogoTest01 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o nome do herói: ");
            String nome = "";
            while (nome.isBlank()) {
                if (!scanner.hasNextLine()) return;
                nome = scanner.nextLine().trim();
                if (nome.isBlank()) System.out.print("O nome não pode ser vazio. Tente novamente: ");
            }
            Heroi heroi = new Heroi();
            new CadastroHeroi().cadastrar(heroi, nome, 100, 15, 5);
            CadastroMonstro cadastro = new CadastroMonstro();
            Monstro goblin = new Monstro();
            Monstro esqueleto = new Monstro();
            Monstro guardiao = new Monstro();
            cadastro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
            cadastro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 20, 40);
            cadastro.cadastrar(guardiao, "Guardião Sombrio", 75, 12, 3, 50, 100);
            Fase floresta = new Fase();
            floresta.nome = "Floresta Sombria";
            floresta.inimigo = goblin;
            Fase caverna = new Fase();
            caverna.nome = "Caverna dos Ossos";
            caverna.inimigo = esqueleto;
            Fase castelo = new Fase();
            castelo.nome = "Castelo das Sombras";
            castelo.inimigo = guardiao;
            Jogo jogo = new Jogo();
            jogo.configurar(heroi, new Fase[]{floresta, caverna, castelo});
            jogo.iniciar(scanner);
        }
    }
}
