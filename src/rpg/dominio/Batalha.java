package rpg.dominio;

import java.util.Scanner;

public class Batalha {
    // Exercício 24.
    public void atacarComHeroi(Heroi heroi, Monstro monstro) {
        if (!heroi.estaVivo() || !monstro.estaVivo()) {
            return;
        }
        int dano = heroi.calcularDano(monstro.defesa);
        monstro.receberDano(dano);
        System.out.println(heroi.nome + " causou " + dano + " de dano em " + monstro.nome + ".");
    }

    // Exercício 25.
    public void atacarComMonstro(Monstro monstro, Heroi heroi) {
        if (!monstro.estaVivo() || !heroi.estaVivo()) {
            return;
        }
        int dano = monstro.calcularDano(heroi.defesa);
        heroi.receberDano(dano);
        System.out.println(monstro.nome + " causou " + dano + " de dano em " + heroi.nome + ".");
    }

    // Exercícios 26 e 30: ao vencer um turno, entrega a recompensa uma única vez.
    public void executarTurno(Heroi heroi, Monstro monstro) {
        if (!heroi.estaVivo() || !monstro.estaVivo()) {
            return;
        }
        atacarComHeroi(heroi, monstro);
        if (monstro.estaVivo()) {
            atacarComMonstro(monstro, heroi);
        }
        System.out.println("Vida de " + heroi.nome + ": " + heroi.vida);
        System.out.println("Vida de " + monstro.nome + ": " + monstro.vida);

        if (heroi.estaVivo() && !monstro.estaVivo()) {
            heroi.receberRecompensa(monstro);
        }
    }

    // Exercício 38: esta versão devolve a vitória ao Jogo, que conclui a fase.
    public boolean iniciarBatalha(Heroi heroi, Monstro monstro, Pocao pocao, Scanner scanner) {
        if (!heroi.estaVivo() || !monstro.estaVivo()) {
            return false;
        }
        while (heroi.estaVivo() && monstro.estaVivo()) {
            System.out.println("\n1 - Atacar\n2 - Usar poção\n3 - Fugir");
            System.out.print("Escolha uma ação: ");
            if (!scanner.hasNextLine()) {
                System.out.println("Entrada encerrada. Combate interrompido sem recompensa.");
                return false;
            }
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
                continue;
            }
            boolean acaoValida = false;
            switch (opcao) {
                case 1:
                    atacarComHeroi(heroi, monstro);
                    acaoValida = true;
                    break;
                case 2:
                    acaoValida = heroi.usarPocao(pocao);
                    System.out.println(acaoValida ? "Poção utilizada." : "Não foi possível usar a poção.");
                    break;
                case 3:
                    System.out.println("Você fugiu. Nenhuma recompensa recebida.");
                    return false;
                default:
                    System.out.println("Opção inexistente. Escolha 1, 2 ou 3.");
            }
            if (acaoValida && heroi.estaVivo() && monstro.estaVivo()) {
                atacarComMonstro(monstro, heroi);
            }
            System.out.println("Vida do herói: " + heroi.vida + " | Vida do monstro: " + monstro.vida);
        }
        return heroi.estaVivo() && !monstro.estaVivo();
    }
}
